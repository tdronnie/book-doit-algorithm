import java.util.Scanner;

public class Q5_IntQueueTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue q = new IntQueue(5);

		while (true) {
			System.out.println("현재 데이터 개수 : " + q.size() + " / " + q.getCapacity());
			System.out.print("(1) 인큐　(2) 디큐　(3) 피크 　(4)indexof (5)search (6) 덤프  (7) 클리어(0) 종료 : ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x = 0;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					q.enqueue(x);
				} catch (IntArrayQueue.OverflowIntArrayQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = q.dequeue();
					System.out.println(" 디큐한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = q.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntArrayQueue.EmptyIntArrayQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: //indexof
				System.out.print("큐에서 절대적 위치 검색할 데이터 입력: ");
				int find = stdIn.nextInt();
				try {
					int idx = q.indexOf(find);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
			} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;

			case 5: // search
				System.out.print("큐에서 논리적 위치 검색할 데이터 입력: ");
				int search = stdIn.nextInt();
				try {
					int idx = q.search(search);
					System.out.println("해당 데이터는 인덱스" + idx + "에 있습니다.");
			} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				
				break;
				
			case 6: //dump
				q.dump();
				break;
				
			case 7: //클리어
				q.clear();
				break;
			}
		}
	}
}
