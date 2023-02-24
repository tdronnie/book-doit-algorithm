import java.util.Scanner;

public class Q1_IntStackTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(5)검색 (6)클리어 (7)찼는지 확인 (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;

			case 5:
				System.out.print("검색할 데이터 입력: ");
				int search = stdIn.nextInt();
				try {
					int idx = s.indexOf(search);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 6:
				System.out.print("스택을 전부 비울까요?(N/y): ");
				char ch = stdIn.next().charAt(0);
				if (ch == 'y') {
					s.clear();
					System.out.println("스택을 전부 비웠습니다");
				} else {
					System.out.println("스택 비우기 취소");
				}
				break;

			case 7:
				if (s.isFull())
					System.out.println("스택이 모두 찼습니다.");
				else
					System.out.println("스택이 아직 차지 않았습니다.");
				break;

			}
		}
	}
}
