import java.io.*;

public class Q1_factorial_no_recursive {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("팩토리얼 진행할 숫자 입력: ");
		int num = Integer.parseInt(br.readLine()); //팩토리얼 진행할 숫자 입력
		
		System.out.print(num + "!은 ");
		
		for(int i=num-1; i>0; i--)
			num *= i;
		
		System.out.println(num);
	}

}
