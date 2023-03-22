import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_bmMatch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력: ");
		String str = br.readLine();

		System.out.print("패턴 입력: ");
		String pattern = br.readLine();

		int idx = bmMatch(str, pattern);

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
	
	static int bmMatch(String txt, String pat) {
		int pt; //전체 문자열 인덱스
		int pp;	//패턴 인덱스
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1];	// 건너뛰기 표
		int count = 0;   // 비교 회수
		int k = -1;

		// 건너뛰기 표 작성
		for (pt = 0; pt <= Character.MAX_VALUE; pt++) //전체 알파벳에 대해서 저장
			skip[pt] = patLen;
		for (pt = 0; pt < patLen - 1; pt++)
			skip[pat.charAt(pt)] = patLen - pt - 1;
		// pt == patLen - 1
		// 검색
		while (pt < txtLen) {
			pp = patLen - 1; //마지막 문자부터 검사

			
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

			for (int i = 0; i < (pt-pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			count++;

			while (txt.charAt(pt) == pat.charAt(pp)) {

				if (pp == 0)
					return pt;         // 검색 성공
				pp--;
				pt--;
				
				//검사하는 패턴 시작인덱스(실제검사는 마지막 인덱스부터)
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

				for (int i = 0; i < (pt-pp) * 2 + 4; i++)
					System.out.print(" ");

				for (int i = 0; i < pat.length(); i++)
					System.out.print(pat.charAt(i) + " ");
				System.out.println();
				System.out.println();
				count++;
			}
			pt += skip[txt.charAt(pt)]; //표에 따라서 옮김
		}
		return -1;									// 검색 실패
	}

}
