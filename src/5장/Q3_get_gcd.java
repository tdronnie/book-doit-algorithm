import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_get_gcd {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("최대공약수 구할 배열 요소개수 입력: ");
		int n = Integer.parseInt(br.readLine()); //배열 크기
		
		int[] arr = new int[n]; //크기가 n인 배열 생성
		
		//배열에 요소 입력
		for(int i=0; i<n; i++) {
			System.out.print("배열 " + i + "번째 요소입력: ");
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println("배열 요소들의 최대공약수는 " + gcdArray(arr) + "입니다.");
		
	}
	
	//int형 배열 안 요소들의 최대공약수 구하는 메소드
	public static int gcdArray(int[] a) {
		
		int len = a.length;
		if(len == 1) //배열 요소 하나인 경우
			return a[0];
		
		//처음 두 요소의 최대공약수 구하기
		int rslt = gcd(a[0], a[1]);
		
		//2번째 요소부터 gcd(최대공약수, a[i])
		for(int i=2; i<len; i++) {
			if(rslt == 1) //최대공약수가 1이 나올 경우 멈춤
				break;
			rslt = gcd(rslt, a[i]);
		}
		return rslt;
		
	}
	
	//두 수 최대공약수 구하는 메소드
	public static int gcd(int n1, int n2) {
		if(n2 == 0)
			return n1;
		else {
			return gcd(n2, n1%n2);
		}
	}

}
