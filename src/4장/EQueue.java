
public class EQueue<E> {
	private E[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;
	
	// 큐가 비어있을 경우
		public static class EmptyEQueueException extends RuntimeException {
			public EmptyEQueueException() {
			}
		}

		// 큐가 가득 찼을 경우
		public static class OverflowEQueueException extends RuntimeException {
			public OverflowEQueueException() {
			}
		}

	// 생성자
	@SuppressWarnings("unchecked")
	public EQueue(int maxLen) {
		num = 0;
		front = 0;
		rear = 0;
		capacity = maxLen;
		try {
			que = (E[]) new Object[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// 인큐
	public E enqueue(E e) throws OverflowEQueueException {
		if (num >= capacity) {
			throw new  OverflowEQueueException();
		}
		que[rear++] = e; // 데이터 추가
		num++; // 데이터수 +1

		// 마지막 인덱스까지 데이터를 인큐한 경우 rear인덱스 0으로 해줘서 계속 인큐 가능하도록
		if (rear == capacity) {
			rear = 0;
		}
		return e;
	}

	// 디큐
	public E dequeue() throws EmptyEQueueException{
		if (num <= 0) {
			throw new EmptyEQueueException();
		}
		E e = que[front++]; // 맨 앞 요소 빼주고 front를 뒤의 요소로 변경
		num--; // 데이터수 -1

		// 마지막 인덱스까지 데이터를 디큐한 경우 front인덱스 0으로 해줘서 계속 디큐 가능하도록
		if (front == capacity) {
			front = 0;
		}
		return e;
	}

	// 프런트 데이터 보기
	public E peek() throws EmptyEQueueException {
		if (num <= 0) {
			throw new EmptyEQueueException();
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
	public int indexOf(E e) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity; // front인덱스부터 시작, 만약 인덱스 최대값에 도달하면 배열 크기로 나눠줘서 다시 인덱스 0부터 다시 시작하도록
			if (que[idx].equals(e)) //모든 타입 비교하기 위해서 equals
				return idx;
		}
		return -1;
	}
	
	//절대적 위치가 아닌 큐 안에서의 논리적위치 반환(1부터시작)
	public int search(E e) {
		for(int i=0; i<num; i++) { //데이터 수만큼
			int idx = (i + front) % capacity;
			if (que[idx].equals(e))
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
			throw new EmptyEQueueException();
		} else {
			for (int i = 0; i < num; i++) { // 프론트 - 리어 출력
				System.out.println(que[(i + front) % capacity] + " ");
			}
			System.out.println();
		}
	}

}
