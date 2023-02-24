import java.util.EmptyStackException;

public class EStack<E> {

	private E[] stk; // 객체형 스택
	private int capacity; // 스택 용량
	private int ptr; // 스택 포인터

	// 예외 처리
//	아래 예외들(RuntimeException 상속)은 어떤 타입이 들어올지 모르기 때문에 JVM이 예외 인스턴스를 구별할수 있는 방법이 없다?
//	static붙이니까 가능해짐
//		//스택이 비어있을 경우
//		public class EmptyIntStackException extends RuntimeException {
//			public EmptyIntStackException() { }
//		}
//		
//		//스택이 모두 찼을 경우
//		public class OverflowIntStackException extends RuntimeException {
//			public OverflowIntStackException() { }
//		}

	// 생성자
	// 런타임 동안 배열의 타입은 Object로 타입 안정성 문제가 생길 수 있는데
	// 우리는 push 시 E타입만 담을 것이므로 타입 안정성이 보장된다. 따라서 경고 제외시키면 된다.
	@SuppressWarnings("unchecked")
	public EStack(int maxLen) {
		ptr = 0; // 스택 밑바닥에서 시작
		capacity = maxLen; // 스택 가용 범위
		try {
			stk = (E[]) new Object[capacity]; // 모든 객체 타입을 받을 수 있게 해주고 제네릭 타입캐스팅
		} catch (OutOfMemoryError e) { // 메모리 여유가 없을 때 메모리 에러
			capacity = 0;
		}
	}

	public E push(E e) throws StackOverflowError {
		// push전에 스택 가득 찼을 경우 예외처리
		if (ptr >= capacity) {
			throw new StackOverflowError("스택이 가득 찼습니다.");
		}
		return stk[ptr++] = e; // 현재 포인터 배열에 값 넣어주고 값 리턴, 포인터 +1
	}

	public E pop() throws EmptyStackException {
		// pop전에 스택이 비어있을 경우 예외처리
		if (ptr <= 0) {
			throw new EmptyStackException();
		}
		return stk[ptr--]; // 해당 포인터 요소 리턴 후 포인터 하나 당겨줌
	}

	// peek
	public E peek() throws EmptyStackException {
		// peek전에 스택 비어있을 경우 예외처리
		if (ptr <= 0) {
			throw new EmptyStackException();
		}
		return stk[ptr - 1]; // top요소 리턴
	}

	public void clear() {
		ptr = 0;
	}

	// 요소 검색
	public int indexOf(E e) {
		for (int i = 0; i < ptr; i++) {
			if (stk[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// 스택 용량 반환
	public int getCapacity() {
		return capacity;
	}

	// 스택 안에 있는 데이터 개수 반환
	public int size() {
		return ptr; // 포인터는 마지막으로 push한 인덱스 다음 인덱스를 가리키고 있지만 애초에 인덱스가 0부터 시작하기 때문에 서로 상쇄된다.
	}

	// 스택 가득찼는지 여부 반환
	public boolean isFull() {
		return ptr >= capacity;
	}

	// 스택 안 요소들을 bottom -> top순으로 출력
	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택 비었음");
		} else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}
