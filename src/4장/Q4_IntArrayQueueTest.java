import java.util.Scanner;

public class Q4_IntArrayQueueTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntArrayQueue q = new IntArrayQueue(64); // 최대 64개를 푸시할 수 있는 큐

		while (true) {
			System.out.println("현재 데이터 개수 : " + q.size() + " / " + q.capacity());
			System.out.print("(1) 인큐　(2) 디큐　(3) 피크 (4) 덤프　(5) 클리어(0) 종료 : ");

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

			case 4: // 덤프
				q.dump();
				break;

			case 5: // 클리어
				q.clear();
				break;
			}
		}
	}
}
