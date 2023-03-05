import java.io.*;

public class Q7_tower_of_hanoi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("하노이 탑 원반의 개수: ");
		int n = Integer.parseInt(br.readLine());
				
		move(n, 1, 3); //n개의 원반을 1번 기둥에서 3번 기둥으로 옮기기
	}

	// no번 원반을 x번 기둥에서 y번 기둥으로 옮기기
	static void move(int no, int x, int y) {
		if (no > 1) {
			move(no - 1, x, 6 - x - y); // 기둥이 1, 2, 3번 이므로 6
		}

		System.out.printf("원반 [%d]을(를) %c번 기둥에서 %c번 기둥으로 옮김\n", no, (char)x+64, (char)y+64); // 아스키코드 65 -> A

		if (no > 1) {
			move(no - 1, 6 - x - y, y);
		}
	}
}
