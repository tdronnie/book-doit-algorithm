
public class Q12 {

	public static void main(String[] args) {

		//열의 더하는 수 출력
		System.out.print("   |");
		for(int i=1; i<=9; i++) {
			System.out.print(String.format("%3d", i));
		}
		System.out.println();
		
		//구분선 출력
		System.out.println("---+---------------------------");
		
		//행의 더하는 수와 덧셈 결과 출력
		for(int i=1; i<=9; i++) {
			System.out.print(" " + i + " |");
			for(int j=1; j<=9; j++) {
				System.out.print(String.format("%3d", i+j));
			}
			System.out.println();
		}

	}

}
