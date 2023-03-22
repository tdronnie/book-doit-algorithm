import java.io.*;

public class Q1_search_pattern_brute_force {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력: ");
		String str = br.readLine();

		System.out.print("패턴 입력: ");
		String pattern = br.readLine();

		drawFlow(str, pattern);

	}

	public static void drawFlow(String str, String p) {

		int ps = 0; // 문자열의 포인터
		int pp = 0; // 패턴의 포인터
		int cnt = 0; // 비교 횟수
		int idx = ps; // 비교하는 시작 인덱스

		while (ps != str.length() && pp != p.length()) {
			cnt++;
			if (pp == 0) { // 패턴 탐색 시작인 경우
				System.out.printf("%2d %s\n", ps, str);
			} else {
				System.out.printf("   %s\n", str);
			}

			if (str.charAt(ps) == p.charAt(pp)) {
				
				System.out.printf(String.format("   %%%ds\n", idx + pp + 1), "+");
				System.out.printf(String.format("   %%%ds\n", idx + 1), p); //패턴 문자열이 이동하지 않음...
//				System.out.println(ps + " " + pp + "문자 같음" + " idx: " + idx);
//				System.out.println("idx: " + idx);
				ps++;
				pp++;
			} else {
				
				System.out.printf(String.format("   %%%ds\n", idx + pp + 1), "|");
				System.out.printf(String.format("   %%%ds\n", idx + 1), p);
//				System.out.println(ps + " " + pp + "문자 다름" + " idx: " + idx);
//				System.out.println("idx: " + idx);
				ps = ps - pp + 1; // pp탐색한 만큼 다시 되돌아가주고 +1
				idx = ps; // 시작 인덱스 업데이트
				pp = 0; // 탐색 초기화
			}
			System.out.println();
		}

		

		if (pp == p.length()) {
//			return ps - pp; //패턴을 찾았을 경우 패턴이 위치하는 첫번째 인덱스 리턴
			System.out.println("비교를 " + cnt + "회 했습니다");
			return;
		}
		System.out.println("비교를 " + cnt + "회 했습니다");
		System.out.println("해당 패턴을 찾지 못했습니다.");
	}

}
