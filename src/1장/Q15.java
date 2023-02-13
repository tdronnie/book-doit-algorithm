//피라미드 별찍기
import java.util.Scanner;
public class Q15 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 층: ");
		int n = sc.nextInt();
		
		spira(n);
	}
	
	static void spira(int n) {
		for(int i=1; i<=n; i++) { //행 개수
			int j;
			for(j=1; j<=n-i; j++) { //앞쪽 공백 처리
				System.out.print(" ");
			}
			//공백처리 이후부터 앞쪽 공백처리 해준 만큼 대칭으로 뒤쪽도 해준 곳까지 *채우기
			//j 인덱스를 1부터 세기 때문에 n번째 줄에 *2하더라도 -1만큼 *출력
			for(int k=j; k<=n*2-j; k++) { 
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
