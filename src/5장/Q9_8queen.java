
public class Q9_8queen {

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
		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {
				pos[i] = j; // i열의 퀸을 j행에 위치하도록 한다
				if (i == 7)
					print();
				else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
