import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		if(n%2 == 0) { //n이 짝수라면 정확히 떨어짐
			sum = (1+n)*(n/2);
		}
		else { //n이 홀수인 경우 마지막으로 양끝 더한수/2가 하나 남음
			sum = (1+n)*(n/2) + (1+n)/2;
			
		}
		System.out.println("sum: " + sum);
	}

}
