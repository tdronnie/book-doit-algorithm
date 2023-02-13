import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("1에서 n까지의 총합을 구합니다.");
 		System.out.print("n의 값 : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;

		while (i <= n) {
			System.out.println("i: " + i);
			sum += i;
			i++;
		}
		System.out.println("1에서 " + n + "까지의 총합은 " + sum + "입니다.");
	}

}
