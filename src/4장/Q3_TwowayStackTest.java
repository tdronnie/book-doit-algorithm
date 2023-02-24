import java.util.Scanner;

public class Q3_TwowayStackTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		TwowayStack s = new TwowayStack(64); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 A스택 데이터 개수: %d B스택 데이터 개수: %d / %d\n", s.sizeA(), s.sizeB(), s.getCapacity());
			System.out.print("(1)A푸시　(2)B푸시\n(3)A팝 (4)B팝\n(5)A피크 (6)B피크\n(7)덤프 (8)A검색 (9)B검색 (10)클리어 (11)찼는지 확인 (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 푸시
				System.out.print("A스택에 넣을 데이터: ");
				x = stdIn.nextInt();
				try {
					s.pushA(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2: // 푸시
				System.out.print("B스택에 넣을 데이터: ");
				x = stdIn.nextInt();
				try {
					s.pushB(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 3: // 팝
				try {
					x = s.popA();
					System.out.println("A스택에서 팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4: // 팝
				try {
					x = s.popB();
					System.out.println("B스택에서 팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 5: // 피크
				try {
					x = s.peekA();
					System.out.println("A스택에서 피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 6: // 피크
				try {
					x = s.peekB();
					System.out.println("B스택에서 피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 7: // 덤프
				s.dump();
				break;

			case 8:
				System.out.print("A스택에서 검색할 데이터 입력: ");
				int searchA = stdIn.nextInt();
				try {
					int idx = s.indexOfA(searchA);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 9:
				System.out.print("B스택에서 검색할 데이터 입력: ");
				int searchB = stdIn.nextInt();
				try {
					int idx = s.indexOfB(searchB);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 10:
				System.out.print("스택을 전부 비울까요?(N/y): ");
				char ch = stdIn.next().charAt(0);
				if (ch == 'y') {
					s.clear();
					System.out.println("스택을 전부 비웠습니다");
				} else {
					System.out.println("스택 비우기 취소");
				}
				break;

			case 11:
				if (s.isFull())
					System.out.println("스택이 모두 찼습니다.");
				else
					System.out.println("스택이 아직 차지 않았습니다.");
				break;

			}
		}
	}
}