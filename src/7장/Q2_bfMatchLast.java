import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_bfMatchLast {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력: ");
		String str = br.readLine();

		System.out.print("패턴 입력: ");
		String pattern = br.readLine();

		bfMatchLast(str, pattern);

	}
	static int bfMatchLast(String str, String p) {
		int ps = str.length()-1; // 문자열의 포인터
		int pp = str.length()-1; // 패턴의 포인터

		while (ps >= 0 && pp >= 0) { //뒤부터 탐색 시작해서 0이상 일때까지

			if (str.charAt(ps) == p.charAt(pp)) {				
				ps--;
				pp--;
			} else {
				ps = ps + (p.length() - pp) - 2; //?
				pp = p.length() - 1; //패턴 끝 인덱스로 초기화
			}
		}
		if (pp < 0)
			return ps + 1;
		return -1;	
	}
}
