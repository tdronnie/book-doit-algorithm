import java.io.*;
public class Q13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("정사각형을 출력합니다.\n변의 길이: ");
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
