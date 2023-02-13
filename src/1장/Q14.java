//직각이등변삼각형 출력
import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직각이등변삼각형의 한변의 길이 입력: ");
		int n = sc.nextInt();
		triangleLB(n); //왼쪽아래가 직각
		System.out.println();
		triangleLU(n); //왼쪽위가 직각
		System.out.println();
		triangleRU(n); //오른쪽위가 직각
		System.out.println();
		triangleRB(n); //오른쪽아래가 직각

	}
	
	static void triangleLB(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) { //1에서 1씩 증가하면서 출력
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	static void triangleLU(int n) {
		for(int i=n; i>=1; i--) {
			for(int j=i; j>=1; j--) { //n에서 1씩 감소하면서 출력
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	static void triangleRU(int n) {
		int j;
		for(int i=1; i<=n; i++) {
			for(j=1; j<i; j++) { //1개 공백부터 먼저 채우기
				System.out.print(" ");
			}
			for(int k=j; k<=n; k++) { //공백 이후로 남은 공간 *로 채우기
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRB(int n) {
		int j;
		for(int i=1; i<=n; i++) {
			for(j=n; j>i; j--) { //n-1개 공백부터 먼저 채우기
				System.out.print(" ");
			}
			for(int k=j; k>=1; k--) { //공백 이후로 남은 공간 *로 채우기
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
