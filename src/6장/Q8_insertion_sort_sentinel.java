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

		insertionSort(a, n);
	}

	// 배열안에 들어오는 요소는 자연수라고 가정, a[0]은 -1로 한다
	static void insertionSort(int[] a, int n) {
		a[0] = -1; //보초값 저장
		for (int i = 2; i < n + 1; i++) {
			int j;
			int tmp = a[i];
			for (j = i; tmp < a[j - 1]; j--) { // a[0]까지 갈 경우 끝
				a[j] = a[j - 1]; // 요소 뒤로 밀기
			}
			a[j] = tmp; // tmp보다 작은 요소 바로 다음에 배치

		}

		for (int z = 0; z < n+1; z++) // 정렬 완료 배열 출력
			System.out.printf("%2d", a[z]);
		System.out.println();

	}

}
