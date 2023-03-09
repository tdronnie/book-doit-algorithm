import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8_insertion_sort_sentinel {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("보초를 이용한 삽입정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n + 1]; // 요소가 n+1개인 배열 생성, a[0]에 보초값 저장

		// 배열에 요소 저장
		for (int i = 1; i < n + 1; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		insertionSort(a, n+1);
	}

	// 배열안에 들어오는 요소는 자연수라고 가정
	static void insertionSort(int[] a, int n) {
		for (int i = 2; i < n; i++) {
			int j;
			int tmp = a[0] = a[i]; //tmp와 a[0]에 a[i] 값 저장
			for (j = i; tmp < a[j - 1]; j--) {
				a[j] = a[j - 1]; // 요소 뒤로 밀기
			}
			if (j > 0) a[j] = tmp; // 보초값인 0인덱스 바로 다음까지 왔을 경우 바로 다음에 배치

		}

		for (int z = 1; z < n; z++) // 정렬 완료 배열 출력, 보초 제외 출력
			System.out.printf("%2d", a[z]);
		System.out.println();

	}

}
