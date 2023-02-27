import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_Euclid_no_recursive {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("최대공약수 구할 두 정수 입력(스페이스바 구분): ");
		String[] str = (br.readLine()).split(" ");

		int n1 = Integer.parseInt(str[0]);
		int n2 = Integer.parseInt(str[1]);

		System.out.println("두 수의 최대공약수는 " + getRslt(n1, n2) + "입니다.");

	}

	//n1과 n2의 최대공약수 구하는 메소드
	public static int getRslt(int n1, int n2) {

		if (n1 > n2) { // n1이 큰 수일 경우
			if (n2 == 0) { // 작은 수가 0일 경우 큰 수가 최대공약수
				return n1;
			} else {
				while (true) {
					if (n1 % n2 == 0) { // 큰 수가 작은 수로 나누어 떨어진다면
						return n2;
					} else { // 큰 수가 작은 수로 나누어 떨어지지 않는다면
						n2 = n1 % n2; // 큰 수를 작은 수로 나눈 나머지를 작은 수로 업데이트
					}
				}
			}
		} else { // n1이 작은 수일 경우, n1과 n2만 바꿈
			if (n1 == 0) {
				return n2;
			} else {
				while (true) {
					if (n2 % n1 == 0) {
						return n1;
					} else {
						n1 = n2 % n1;
					}
				}
			}

		}

	}
}
