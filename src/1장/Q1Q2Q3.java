//최댓값, 최소값 구하기
import java.util.Scanner;

public class Q1Q2Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //정수1
		int b = sc.nextInt(); //정수2
		int c = sc.nextInt(); //정수3
		int d = sc.nextInt(); //정수4
		
		System.out.println(max4(a, b, c, d));
		System.out.println(min3(a, b, c));
		System.out.println(min4(a, b, c, d));

	}
	
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(a > b) {
			if(c > a) {
				max = c;
				if(d > c) {
					max = d;
				}
			}
		}
		else {
			max = b;
			if(c > b) {
				max = c;
				if(d > c) {
					max = d;
				}
			}
		}
		return max;
	}
	
	
	static int min3(int a, int b, int c) {
		int min = a;
		if(a < b) {
			if(c < a) {
				min = c;
			}
		}
		else {
			min = b;
			if(c < b) {
				min = c;
			}
		}
		return min;
	}
	
	static int min4(int a, int b, int c, int d) {
		int min = a;
		if(a < b) {
			if(c < a) {
				min = c;
				if(d < c) {
					min = d;
				}
			}
		}
		else {
			min = b;
			if(c < b) {
				min = c;
				if(d < c) {
					min = d;
				}
			}
		}
		return min;
	}

}
