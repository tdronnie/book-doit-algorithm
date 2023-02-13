import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt=0; //자릿수
		while(n%10>0) {
			n /= 10;
			cnt++;
		}
		System.out.println("그 수는 " + cnt + "자리입니다.");

	}

}
