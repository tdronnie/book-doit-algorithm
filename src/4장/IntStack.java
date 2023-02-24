
public class IntStack {
	
	private int[] stk; //스택용 배열
	private int capacity; //배열에 담을 수 있는 용량
	private int ptr; //포인터
	
	//예외 처리
	
	//스택이 비어있을 경우
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { }
	}
	
	//스택이 모두 찼을 경우
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { }
	}
	
	//생성자
	public IntStack(int maxLen) {
		ptr = 0; //스택 밑바닥에서 시작
		capacity = maxLen; //스택 가용 범위
		try {
			stk = new int[capacity];
		}catch (OutOfMemoryError  e) { //메모리 여유가 없을 때 메모리 에러
			capacity = 0;
		}
	}
	
	//push
	public int push(int x) throws OverflowIntStackException{
		//push 전에 스택 가득 찼을 경우 예외 처리
		if(ptr >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x; //포인터에 값 넣어주고 값 리턴, 포인터+1
	}
	
	//pop
	public int pop() throws EmptyIntStackException{
		//pop 전에 스택이 비어있을 경우 예외 처리
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr]; // 해당 포인터 요소 리턴 후 포인터 하나 당겨줌
		
	}
	
	//peek
	public int peek() throws EmptyIntStackException{
		//스택 peek 전에 스택 비어있다면 예외 처리
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1]; //꼭대기 요소 리턴
	}
	
	//스택 모두 비우기
	public void clear() {
		ptr = 0; //포인터를 0으로 초기화해서 bottom부터 다시 저장되도록 함
	}
	
	//스택 내 요소 검색
	public int indexOf(int x) {
		//for(int i= ptr-1; i >= 0; i++) { //top부터 bottom까지 검색 -> 먼저 pop되는 요소를 먼저 찾음
		for(int i = 0; i < ptr; i++) { //bottom부터 포인터-1(요소가 있는 곳)까지 검색 -> 나중에 pop되는 요소를 먼저 찾음
			if(stk[i] == x)
				return i;
		}
		return -1;
	}
	
	//스택 용량 반환
	public int getCapacity() {
		return capacity;
	}
	
	//스택 안에 있는 데이터 개수 반환
	public int size() {
		return ptr; //포인터는 마지막으로 push한 인덱스 다음 인덱스를 가리키고 있지만 애초에 인덱스가 0부터 시작하기 때문에 서로 상쇄된다.
	}
	
	//스택 가득찼는지 여부 반환
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	//스택 안 요소들을 bottom -> top순으로 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택 비었음");
		}
		else {
			for(int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}

}
