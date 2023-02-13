import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("합: " + sumof(a,b));
	}
	
	static int sumof(int a, int b) {
		if(a > b) { //a가 큰 경우
			if((a-b+1) % 2 == 0) { //숫자 짝수개 더하는 경우
				return (a+b)*((a-b+1)/2); //가우스 덧셈
			}
			else { //홀수개 더하는 경우
				return (a+b)*((a-b+1)/2) + (a+b)/2; //가우스 덧셈
				
			}
		}
		else if(a < b) { //b가 큰 경우
			if((b-a+1) % 2 == 0) { //숫자 짝수개 더하는 경우
				return (a+b)*((b-a+1)/2); //가우스 덧셈
			}
			else { //홀수개 더하는 경우
				return (a+b)*((b-a+1)/2)+ (a+b)/2; //가우스 덧셈
				
			}
			
		}
		else { //a와 b가 같은 경우 해당 수 출력
			return a;
		}
	}

}
