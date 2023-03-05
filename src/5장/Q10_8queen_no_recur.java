import java.util.Stack;

public class Q10_8queen_no_recur {

	static boolean[] flag_a = new boolean[8]; // 행에 하나씩 배치하기 위한 배열
	static boolean[] flag_b = new boolean[15]; // 대각선에 하나씩 배치하기 위한 배열
	static boolean[] flag_c = new boolean[15];
	static int[] pos = new int[8]; // 각 열에서 퀸의 행 위치

	static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == pos[i])
					System.out.printf("%2s", "■");
				else
					System.out.printf("%2s", "□");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void set(int i) {

		Stack<Integer> s = new Stack<>();
		boolean keepGoing = false;
		int keepJ = 0;

		while (true) {
			//스택에 담겨있던 행,열 연산 계속 해주기 위해서 j가 0으로 초기화되는 것 막기
			//초반에 flag_a[0]가 false인가 따질때만 사용되고 그 이후로는 사용되지 않음
			int j = 0; 
			if (keepGoing == true) { // 다시 해주던 반복문 해주기 위해서 하던 j값 이어서 사용
				j = keepJ;
			}
			
			for (; j < 8; j++) {
				if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {
					pos[i] = j; // i열의 퀸을 j행에 위치하도록 한다
					if (i == 7)
						print();
					else {
						flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
						// 현재 i와 j 저장

						s.push(i);
						s.push(j);
						j = 0;
						i++;
						continue;

					}
				}
			}
			if (!s.isEmpty()) {
				// 다시 역순으로 flag변수 false로 바꾸기
				j = s.pop();
				i = s.pop();
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++; // 다시 logicLoop로 이동할 때를 위해서 j++해주기
				keepJ = j;
				keepGoing = true;
			}
		}

	}

	public static void main(String[] args) {
		set(0);
	}
}
