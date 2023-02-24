
public class TwowayStack {

	private int[] stk;
	private int capacity;
	private int APtr; // 왼쪽 사이드 스택 포인터
	private int BPtr; // 오른쪽 사이드 스택 포인터

	// 예외 처리

	// 스택이 비어있을 경우
	public class EmptyTwowayStackException extends RuntimeException {
		public EmptyTwowayStackException() {
		}
	}

	// 스택이 모두 찼을 경우
	public class OverflowTwowayStackException extends RuntimeException {
		public OverflowTwowayStackException() {
		}
	}

	// 생성자
	public TwowayStack(int maxLen) {
		APtr = 0; // 왼쪽 스택 밑바닥은 배열 인덱스 0
		BPtr = maxLen - 1; // 오른쪽 스택 밑바닥은 배열 인덱스 마지막
		capacity = maxLen; // 스택 가용 범위
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) { // 메모리 여유가 없을 때 메모리 에러
			capacity = 0;
		}
	}

	// A 배열에 push
	public int pushA(int x) throws OverflowTwowayStackException {
		// push 전에 B스택의 포인터의 넘어갈 경우 예외처리
		if (APtr >= BPtr) {
			throw new OverflowTwowayStackException();
		}
		return stk[APtr++] = x; // 포인터에 값 넣어주고 값 리턴, 포인터+1
	}

	// A 배열에서 pop
	public int popA() throws EmptyTwowayStackException {
		// pop 전에 스택이 비어있을 경우 예외 처리
		if (APtr <= 0) {
			throw new EmptyTwowayStackException();
		}
		return stk[--APtr]; // 해당 포인터 요소 리턴 후 포인터 하나 당겨줌

	}

	// B 배열에 push
	public int pushB(int x) throws OverflowTwowayStackException {
		// push 전에 A스택의 포인터의 넘어갈 경우 예외처리
		if (BPtr <= APtr) {
			throw new OverflowTwowayStackException();
		}
		return stk[BPtr--] = x; // 포인터에 값 넣어주고 값 리턴, 포인터+1
	}

	// B 배열에서 pop
	public int popB() throws EmptyTwowayStackException {
		// pop 전에 스택이 비어있을 경우 예외 처리
		if (BPtr >= capacity) {
			throw new EmptyTwowayStackException();
		}
		return stk[++BPtr]; // 해당 포인터 요소 리턴 후 포인터 하나 당겨줌

	}

	// A배열 peek
	public int peekA() throws EmptyTwowayStackException {
		// peek 전에 스택이 비어있을 경우 예외 처리
		if (APtr <= 0) {
			throw new EmptyTwowayStackException();
		}
		return stk[APtr - 1]; // 꼭대기 요소 리턴
	}

	// B배열 peek
	public int peekB() throws EmptyTwowayStackException {
		// peek 전에 스택이 비어있을 경우 예외 처리
		if (BPtr >= capacity) {
			throw new EmptyTwowayStackException();
		}
		return stk[BPtr + 1]; // 꼭대기 요소 리턴
	}

	// 스택 모두 비우기
	public void clear() {
		APtr = 0; // 포인터를 0으로 초기화해서 A스택을 bottom부터 다시 저장되도록 함
		BPtr = capacity - 1; // 포인터를 배열의 마지막 인덱스로 초기화해서 B스택을 bottom부터 다시 저장되도록 함
	}

	// A스택 내 요소 검색
	public int indexOfA(int x) {
		for (int i = 0; i < APtr; i++) { // bottom부터 포인터-1(요소가 있는 곳)까지 검색 -> 나중에 pop되는 요소를 먼저 찾음
			if (stk[i] == x)
				return i;
		}
		return -1;
	}

	// B스택 내 요소 검색
	public int indexOfB(int x) {
		for (int i = capacity - 1; i > BPtr; i--) { // bottom부터 포인터+1(요소가 있는 곳)까지 검색 -> 나중에 pop되는 요소를 먼저 찾음
			if (stk[i] == x)
				return -(i-capacity+1);
		}
		return -1;
	}

	// 스택 용량 반환
	public int getCapacity() {
		return capacity;
	}

	// A스택 안에 있는 데이터 개수 반환
	public int sizeA() {
		return APtr; // 포인터는 마지막으로 push한 인덱스 다음 인덱스를 가리키고 있지만 애초에 인덱스가 0부터 시작하기 때문에 서로 상쇄된다.
	}

	// B스택 안에 있는 데이터 개수 반환
	public int sizeB() {
		return -(BPtr-capacity+1); //capacity-1 인덱스부터 시작함, 시작 인덱스부터 포인터를 기준으로 사이즈를 측정하므로 부호 양수로 바꿔준다
	}

	// 스택 가득찼는지 여부 반환
	public boolean isFull() {
		return APtr == BPtr;
	}

	// A스택과 B스택 안 요소들을 bottom -> top순으로 출력
	public void dump() {
		//A스택 덤프
		if (APtr <= 0) {
			System.out.println("A스택 비었음");
		} else {
			System.out.println("A스택");
			for (int i = 0; i < APtr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
		//B스택 덤프
		if (BPtr >= capacity) {
			System.out.println("B스택 비었음");
		} else {
			System.out.println("B스택");
			for (int i = capacity-1; i > BPtr; i--) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}

}
