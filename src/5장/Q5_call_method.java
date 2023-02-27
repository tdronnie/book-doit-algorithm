import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_call_method {
	
	static String[] memo;
	//각 메소드 호출 카운터, 
	static int cnt1;
	static int cnt2;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("메소드 매개변수 입력: ");
		int n = Integer.parseInt(br.readLine());
		
		memo = new String[n+2]; // 인덱스 0과1에 0, -1 매개변수에 대한 값 메모하기 위해 n보다 +2공간의 배열 생성
		
		cnt1++; //기본 recur함수 호출 시작
		recur(n);
		cnt2++; //메모화 recur함수 호출 시작
		recurMemo(n);
		
		System.out.println("기본 recur함수 메소드 호출 횟수: " + cnt1);
		System.out.println("메모화한 recur함수 메소드 호출 횟수: " + cnt2);

	}

	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
			cnt1 = cnt1+2;
		}
	}

	static void recurMemo(int n) {
		if (memo[n + 1] != null)
			System.out.print(memo[n + 1]);
		else {
			if (n > 0) {
				recurMemo(n - 1);
				System.out.println(n);
				recurMemo(n - 2);
				cnt2 = cnt2+2;
				memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
			} else {
				memo[n + 1] = ""; // n이 0이나 -1인 경우
			}
		}
	}

}
