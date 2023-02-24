import java.util.Scanner;

public class Q6_EQueueTest {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		EQueue<String> eq = new EQueue<String>(5);

		while (true) {
			System.out.printf("현재 데이터 개수 : %d / %d\n", eq.size(), eq.getCapacity());
			System.out.print("(1) 인큐　(2) 디큐　(3) 피크 (4) 덤프 (5) 검색 (0) 종료 : ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int idx;
			String x;

			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = stdIn.next();
				try {
					eq.enqueue(x);
				} catch (EQueue.OverflowEQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2:
				try {
					x = eq.dequeue();
					System.out.println(" 디큐한 데이터는 " + x + "입니다.");
				} catch (EQueue.EmptyEQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3:
				try {
					x = eq.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (EQueue.EmptyEQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				eq.dump();
				break;

			case 5: { // 검색
				System.out.print("데이터 : ");
				String str = stdIn.next();
				int n = eq.search(str);
				if (n != 0)
					System.out.printf("%d번째 데이터로 인덱스%d의 위치에 저장되어 있습니다.\n", n, eq.indexOf(str));
				else
					System.out.println("그 데이터는 등록되어 있지 않습니다.");
				break;
			}
			}
		}
	}
}
