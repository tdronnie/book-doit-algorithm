import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_kmp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력: ");
		String str = br.readLine();

		System.out.print("패턴 입력: ");
		String pattern = br.readLine();

		int idx = kmpMatch(str, pattern);
		
		if (idx == -1)
	         System.out.println("텍스트에 패턴이 없습니다.");
	      else {
	         // 일치하는 문자 바로 앞까지의 문자 개수를 반각문자로 환산하여 구함
	         int len = 0;
	         for (int i = 0; i < idx; i++)
	            len += str.substring(i, i + 1).getBytes().length;
	         len += pattern.length();

	         System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
	         System.out.println("텍스트 : " + str);
	         System.out.printf(String.format("패  턴 : %%%ds\n", len), pattern);
	      }

	}

	// --- KMP법에 의한 문자열검색 ---//
	static int kmpMatch(String txt, String pat) {
		int pt = 1; // 전체 문자열 인덱스
		int pp = 0; // 패턴 인덱스
		int count = 0; // 비교 회수
		int[] skip = new int[pat.length() + 1]; // 건너뛰기 표, 중복되는 부분 찾아서 다시 검사할 부분 저장
		int k = -1;

		// 건너뛰기표 작성
		System.out.println("건너뛰기표 작성");
		skip[pt] = 0;
		while (pt != pat.length()) { //패턴 길이만큼
			//탐색 시작하는 인덱스 출력
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			//전체 문자열 출력
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();
			
			//기호까지 공백처리
			for (int i = 0; i < pt * 2 + 4; i++) 
				System.out.print(" ");
			
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|'); //같은 경우 + 다른 경우 |
			System.out.println();

			//패턴 문자열 공백처리
			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			//패턴 문자열 출력
			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			
			System.out.println();
			System.out.println();
			
			//비교회수 증가 및 문자 비교해서 표에 다시 검사 시작할 인덱스 넣기
			count++;
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0) //처음 인덱스의 경우 그냥 넘긴다
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}

		// 검색
		System.out.println("검색");
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();

			for (int i = 0; i < pt * 2 + 4; i++)
				System.out.print(" ");
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			
			//동일한 비교 브루트포스와는 다르게 후진하는 경우가 없다.
			count++;
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];
		}

		System.out.printf("비교를 %d회 했습니다.\n", count);
		if (pp == pat.length()) // 패턴의 모든 문자를 대조
			return pt - pp;
		return -1; // 검색 실패
	}

}
