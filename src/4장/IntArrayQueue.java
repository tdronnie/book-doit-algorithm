
public class IntArrayQueue {
	private int[] que; // 큐 배열
	private int capacity; // 큐 용량
	private int num; // 현재 데이터 개수

	//예외 처리
	
	//큐가 비어있을 경우
	public class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() {
		}
	}

	//큐가 가득 찼을 경우
	public class OverflowIntArrayQueueException extends RuntimeException {
		public OverflowIntArrayQueueException() {
		}
	}
	
	public IntArrayQueue(int maxLen) {
		num = 0;
		capacity = maxLen;
		try {
				que = new int[capacity];
		}catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	//인큐
	public int enqueue(int x) throws OverflowIntArrayQueueException{
		if(num >= capacity) {
			throw new OverflowIntArrayQueueException();
		}
		return que[num++] = x;
	}
	
	//디큐
	public int dequeue() throws EmptyIntArrayQueueException{
		if(num <= 0) {
			throw new EmptyIntArrayQueueException();
		}
		int item = que[0];
		for(int i=0; i < num-1; i++)
			que[i] = que[i+1]; //하나씩 앞으로 당겨준다.
		num--;
		return item;
	}
	
	//피크
	public int peek() throws EmptyIntArrayQueueException{
		if(num <= 0) {
			throw new EmptyIntArrayQueueException();
		}
		return que[0]; //프론트 요소 보기
	}
	
	//검색
	public int indexOf(int x) {
		for(int i=0; i< num; i++) {
			if(que[i] == x)
				return i;
		}
		return -1;
	}
	
	//클리어
	public void clear() {
		num=0;
	}
	
	//용량 반환
	public int capacity() {
		return capacity;
	}
	
	//데이터 수 반환
	public int size() {
		return num;
	}
	
	//가득 찼는지 확인
	public boolean isFull() {
		return num>=capacity;
	}
	
	//비어 있는지 확인
	public boolean isEmpty() {
		return num<=0;
	}
	
	//덤프
	public void dump() {
		if(num <= 0)
			System.out.println("큐가 비어있음");
		else {
			for(int i=0; i<num; i++)
				System.out.print(que[i] + " ");
			System.out.println();
		}
	}
	

}
