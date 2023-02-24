
public class IntQueue {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;

	// 큐가 비어있을 경우
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// 큐가 가득 찼을 경우
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// 생성자
	public IntQueue(int maxLen) {
		num = 0;
		front = 0;
		rear = 0;
		capacity = maxLen;
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// 인큐
	public int enqueue(int x) throws OverflowIntQueueException {
		if (num >= capacity) {
			throw new OverflowIntQueueException();
		}
		que[rear++] = x; // 데이터 추가
		num++; // 데이터수 +1

		// 마지막 인덱스까지 데이터를 인큐한 경우 rear인덱스 0으로 해줘서 계속 인큐 가능하도록
		if (rear == capacity) {
			rear = 0;
		}
		return x;
	}

	// 디큐
	public int dequeue() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		int item = que[front++]; // 맨 앞 요소 빼주고 front를 뒤의 요소로 변경
		num--; // 데이터수 -1

		// 마지막 인덱스까지 데이터를 디큐한 경우 front인덱스 0으로 해줘서 계속 디큐 가능하도록
		if (front == capacity) {
			front = 0;
		}
		return item;
	}

	// 프런트 데이터 보기
	public int peek() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		return que[front];
	}

	// 클리어
	public void clear() {
		num = 0;
		front = 0;
		rear = 0;
	}

	// 검색, 데이터가 저장되는 인덱스가 정해져있는 것이 아니므로 주의
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity; // front인덱스부터 시작, 만약 인덱스 최대값에 도달하면 배열 크기로 나눠줘서 다시 인덱스 0부터 다시 시작하도록
			if (que[idx] == x)
				return idx;
		}
		return -1;
	}
	
	//절대적 위치가 아닌 큐 안에서의 논리적위치 반환(1부터시작)
	public int search(int x) {
		for(int i=0; i<num; i++) { //데이터 수만큼
			int idx = (i + front) % capacity;
			if (que[idx] == x)
				return i+1; //검색은 같은 방법으로 하되 반환을 논리적인 위치로
		}
		return -1;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= capacity;
	}

	public void dump() {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		} else {
			for (int i = 0; i < num; i++) { // 프론트 - 리어 출력
				System.out.println(que[(i + front) % capacity] + " ");
			}
			System.out.println();
		}
	}

}
