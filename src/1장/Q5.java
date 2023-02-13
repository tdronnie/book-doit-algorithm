
public class Q5 {

	public static void main(String[] args) {
		System.out.println("med3(1,2,3) = " + med3(1,2,3));      // c＞b＞a
	}
	
	static int med3(int a, int b, int c) {
		if ((b >= a && c <= a) || (b <= a && c >= a))
			return a;
		else if ((a > b && c < b) || (a < b && c > b))
			return b;
		return c;
	}

}
/***
 * 첫번째 조건문에서 이미 a와 b의 대소가 가려지기 때문에 
 * 그 이후에 또 대소를 다루는 것은 같은 연산을 반복하는 것이므로 효율이 좋지 않다
 */
