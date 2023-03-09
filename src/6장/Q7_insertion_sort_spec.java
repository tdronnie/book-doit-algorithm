import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_insertion_sort_spec {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("삽입정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n개인 배열 생성

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		insertionSort(a, n);

	}

	static void insertionSort(int[] a, int n) {

		for (int i = 1; i < n; i++) {
			for (int z = 0; z < n; z++) // 정렬 전 배열 출력
				System.out.printf("%2d", a[z]);
			System.out.println();

			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--) { // 인덱스 0이상이면서 tmp요소보다 큰 요소들
				a[j] = a[j - 1]; // 요소 뒤로 밀기
			}
			a[j] = tmp; // tmp보다 작은 요소 바로 다음에 배치

			int cnt = i - j; //i인덱스와 j인덱스차이만큼 -출력, 2칸 공백이므로 1차이->1개 출력, 2차이->3개 출력과 같이 홀수개 출력해야함
			if(cnt == 0)
				System.out.printf(String.format("%%%ds+",i*2+1), "");
			else {
				System.out.printf(String.format("%%%ds^",(j*2+1)), "");
				for(int k=1; k<=cnt*2-1; k++)
					System.out.print("-");
				System.out.print("+");
			}
				
			System.out.println();

		}
		for (int z = 0; z < n; z++) // 정렬 완료 배열 출력
			System.out.printf("%2d", a[z]);
		System.out.println();
	}

}
