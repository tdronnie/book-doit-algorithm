import java.util.Scanner;

public class Q7_IntDequeTest {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntDeque dq = new IntDeque(64); // 최대 64개를 인큐할 수 있는 덱

		while (true) {
			System.out.println("현재 데이터 개수 : " + dq.size() + " / " + dq.getCapacity());
			System.out.print("(1)앞 인큐　(2)뒤 인큐 (3)앞 디큐 (4)뒤 디큐 (5)앞 피크 (6)뒤 피크 (7)덤프 (8)검색 (9)클리어 (0) 종료 : ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x = 0;
			switch (menu) {
			case 1: // 앞 인큐
				System.out.print("앞에 인큐할 데이터 : ");
				x = stdIn.nextInt();
				try {
					dq.enqueueF(x);
				} catch (IntArrayQueue.OverflowIntArrayQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
				
			case 2: // 뒤 인큐
				System.out.print("뒤에 인큐할 데이터 : ");
				x = stdIn.nextInt();
				try {
					dq.enqueueR(x);
				} catch (IntArrayQueue.OverflowIntArrayQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 3: // 앞 디큐
				try {
					x = dq.dequeueF();
					System.out.println("앞에서 디큐한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
				
			case 4: // 뒤 디큐
				try {
					x = dq.dequeueR();
					System.out.println("뒤에서 디큐한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 5: // 앞에서 피크
				try {
					x = dq.peekF();
					System.out.println("앞에서 피크한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
				
			case 6: // 뒤에서 피크
				try {
					x = dq.peekR();
					System.out.println("뒤에서 피크한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 7: // 덤프
				dq.dump();
				break;

			case 8: // 검색
				System.out.print("덱에서 검색할 데이터 입력: ");
				int search = stdIn.nextInt();
				try {
					int idx = dq.search(search);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 9: // 클리어
				dq.clear();
				break;
			}
		}
	}
}
