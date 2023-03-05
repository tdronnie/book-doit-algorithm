import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Q8_hanoi_no_recur {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("하노이 탑 원반의 개수: ");
		int n = Integer.parseInt(br.readLine());

		move(n, 1, 3); // n개의 원반을 1번 기둥에서 3번 기둥으로 옮기기
	}

	// no번 원반을 x번 기둥에서 y번 기둥으로 옮기기
	static void move(int no, int x, int y) {

		Stack<Integer> s = new Stack<>();
		
		//메소드 처음 호출 될 때 먼저 매개변수 push
		s.push(no);
		s.push(x);
		s.push(y);
		while (true) {

			if (no > 1) {
				// 첫번째 재귀 로직 시점의 매개변수 push
				no--;
				y = 6 - x - y;
				s.push(no);
				s.push(x);
				s.push(y);
				continue;
			}

			if (!s.isEmpty()) {
				// LIFO 반대방향으로 값 받음
				y = s.pop();
				x = s.pop();
				no = s.pop();
				System.out.printf("원반 [%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);
				if (no > 1) {
					// 두번째 재귀 로직 시점의 매개변수 push
					no--;
					x = 6 - x - y;
					s.push(no);
					s.push(x);
					s.push(y);
				}
				continue;
			}
			break;
		}
	}
}