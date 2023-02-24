public class IntDeque {

	private int[] deque;
	private int capacity;
	private int front;
	private int rear;
	private int num;

	// 덱이 비어있을 경우
	public static class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// 덱이 가득 찼을 경우
	public static class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}

	public IntDeque(int maxLen) {
		num = 0;
		front = 0;
		rear = 0;
		capacity = maxLen;
		try {
			deque = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// 앞에서 인큐, 포인터 처리 후 데이터 인큐
	public int enqueueF(int x) {
		if (num >= capacity) {
			throw new OverflowIntDequeException();
		}
		front--; //다음 저장할 곳으로 포인터 옮김
		if (front< 0) {
			front = capacity - 1; // 저장할 곳이 배열 인덱스 0보다 작아질 경우 front를 뒤로 넘겨주기
		}
		deque[front] = x; // 옮겨진 포인터에 따라 데이터 추가
		num++; // 데이터수 +1

		return x;
	}

	// 뒤에서 인큐, 데이터 인큐 후 포인터 처리
	public int enqueueR(int x) {
		if (num >= capacity) {
			throw new OverflowIntDequeException();
		}
		deque[rear++] = x; //데이터 먼저 추가 후, 다음 저장할 곳으로 포인터 옮김
		if (rear == capacity) {
			rear = 0; // 다음 저장할 곳이 배열을 넘어설 경우 다시 rear를 앞으로 넘겨주기 
		}
		num++; // 데이터수 +1

		return x;
	}

	// 앞에서 디큐, 데이터 디큐한 후 포인터 처리
	public int dequeueF() {
		if (num <= 0) {
			throw new EmptyIntDequeException();
		}
		int item = deque[front++];
		if (front == capacity) {
			front = 0; // 데이터가 배열 마지막까지 다 디큐된 경우 front를 앞으로 넘겨주기
		}
		num--; // 데이터 수 -1
		return item;
	}

	// 뒤에서 디큐, 포인터 처리 후 데이터 디큐
	public int dequeueR() {
		if (num <= 0) {
			throw new EmptyIntDequeException();
		}
		if (--rear < 0) {
			rear = capacity-1; // 다음 디큐할 곳이 배열 인덱스0보다 작아질 경우 rear를 뒤로 넘겨주기
		}
		num--; // 데이터 수 -1
		int item = deque[rear];
		return item;
	}
	
	//앞에서 peek
	public int peekF() throws EmptyIntDequeException{
		if(num <= 0) {
			throw new EmptyIntDequeException();
		}
		return deque[front];
	}
	
	//뒤에서 peek
	public int peekR() throws EmptyIntDequeException{
		if(num <= 0) {
			throw new EmptyIntDequeException();
		}
		if(rear == 0) { //현재 rear 포인터가 배열 제일 앞에 있는 경우 제일 뒤 데이터를 보여준다
			return deque[capacity-1];
		}
		return deque[rear-1]; //아니라면 단순히 한 칸 앞에 있는 데이터를 보여준다
	}
	
	//검색
	public int indexOf(int x) {
		for(int i=0; i<num; i++) {
			int idx = (i + front) % capacity;
			if(deque[idx] == x)
				return idx;
		}
		return -1;
	}
	
	//논리적 위치 검색
	public int search(int x) {
		for(int i=0; i<num; i++) {
			int idx = (i + front) % capacity;
			if(deque[idx] == x)
				return i+1;
		}
		return -1;
	}
	
	//클리어
	public void clear() {
		num=0;
		front=0;
		rear=0;
	}
	
	//용량
	public int getCapacity() {
		return capacity;
	}
	
	//데이터수
	public int size() {
		return num;
	}
	
	//비어있는지
	public boolean isEmpty() {
		return num==0;
	}
	
	//가득 차있는지
	public boolean isFull() {
		return num==capacity;
	}
	
	//덤프
	public void dump() {
		if(num <= 0) {
			throw new EmptyIntDequeException();
		}
		for(int i=0; i<num; i++)
			System.out.print(deque[(i+front) % capacity] + " ");
		System.out.println();
	}
}
