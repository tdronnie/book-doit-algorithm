
public class Q11 {

	public static void main(String[] args) {
		
		//열의 곱하는 수 출력
		System.out.print("   |");
		for(int i=1; i<=9; i++) {
			System.out.print(String.format("%3d", i));
		}
		System.out.println();
		
		//구분선 출력
//		System.out.print("---+");
//		for(int i=1; i<=9; i++) {
//			System.out.print("---");
//		}
//		System.out.println();
		System.out.println("---+---------------------------");
		
		//행의 곱하는 수와 구구단 출력
		for(int i=1; i<=9; i++) {
			System.out.print(" " + i + " |");
			for(int j=1; j<=9; j++) {
				System.out.print(String.format("%3d", i*j));
			}
			System.out.println();
		}
	}

}
