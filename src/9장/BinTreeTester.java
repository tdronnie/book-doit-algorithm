
// 이진검색트리클래스BinTree<K,V>의 사용 예

import java.util.Scanner;

class BinTreeTester {
	static Scanner stdIn = new Scanner(System.in);

	// --- 데이터(회원 번호＋이름) ---//
	static class Data {
		public static final int NO = 1; // 번호를 읽어 들일까요?
		public static final int NAME = 2; // 이름을 읽어 들일까요?

		private Integer no; // 회원번호(키값)
		private String name; // 이름

		// --- 키값 ---//
		Integer keyCode() {
			return no;
		}

		// --- 문자열 표현을 반환 ---//
		public String toString() {
			return name;
		}

		// --- 데이터를 읽어 들임 ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호  ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름  ");
				name = stdIn.next();
			}
		}
	}

	// --- 메뉴 열거형 ---//
	enum Menu {
		//열거체는 첫번째 상숫값이 0부터 설정되고, 그 다음부터는 1씩 증가하며 설정된다.
		//상수 이름 옆에 괄호로 특정 상숫값을 줄 수도 있다.이 프로그램에서는 특정상숫값은 주지 않고 괄호로 메시지 저장
		ADD("삽입"), REMOVE("삭제"), SEARCH("검색"), PRINT("표시"),
		PRINTREVERSE("거꾸로 표시"), GETMIN("가장 작은 키값을 반환"),
		GETDATAWITHMINKEY("가장 작은 키값 가지는 데이터 반환"),
		GETMAX("가장 큰 키값을 반환"), GETDATAWITHMAXKEY("가장 큰 키값 가지는 데이터 반환"),
		TERMINATE("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx) //ordinal()은 열거체 정의에서 정의된 순서를 반환
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Data data; // 추가용 데이터 참조
		Data ptr; // 검색용 데이터 참조
		Data temp = new Data(); // 입력용 데이터
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

		do {
			switch (menu = SelectMenu()) {
			case ADD: // 노드 삽입
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				break;

			case REMOVE: // 노드 삭제
				temp.scanData("삭제", Data.NO);
				tree.remove(temp.keyCode());
				break;

			case SEARCH: // 노드 검색
				temp.scanData("검색", Data.NO);
				ptr = tree.search(temp.keyCode());
				if (ptr != null)
					System.out.println("그 번호의 이름은 " + ptr + "입니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case PRINT: // 전체 노드를 키값의 오름차순으로 표시
				tree.print();
				break;

			case PRINTREVERSE: // 전체 노드를 키값의 내림차순으로 표시
				tree.printReverse();
				break;
				
			case GETMIN: // 가장 작은 키값 반환
				int minKey = tree.getMinKey();
				System.out.println("가장 작은 키값은 " + minKey + "입니다");
				break;
				
			case GETDATAWITHMINKEY: // 가장 작은 키값을 가지는 데이터 반환
				Data minData = tree.getDataWithMinKey();
				System.out.println("가장 작은 키값의 데이터는 " + minData + "입니다");
				break;
				
			case GETMAX: // 가장 큰 키값 반환
				int maxKey = tree.getMaxKey();
				System.out.println("가장 큰 키값은" + maxKey + "입니다");
				break;
				
			case GETDATAWITHMAXKEY: // 가장 큰 키값을 가지는 데이터 반환
				Data maxData = tree.getDataWithMaxKey();
				System.out.println("가장 큰 키값의 데이터는 " + maxData + "입니다");
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
}
