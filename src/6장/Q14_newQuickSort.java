import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14_newQuickSort {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("퀵정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n개인 배열 생성

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		quickSort(a, n);

		System.out.println(Arrays.toString(a));

	}

	//quickSort(배열, 요소수)로 변경
	static void quickSort(int[] x, int n) {
		int pl = 0; // 왼쪽 포인터 업데이트
		int pr = n-1; // 오른쪽 포인터 업데이트
		int pivot = x[(pl + pr) / 2]; // 가운데 요소 피벗으로 한다

		// 정렬하려는 요소수가 9개 이하일 경우 단순삽입정렬로 정렬한다.
		if (n <= 9) {
			System.out.printf("인덱스 %d부터 %d까지 요소수가 9개 이하이므로 삽입정렬 진행\n", pl, pr);
			insertionSort(x, pl, pr); // 해당 부분만 삽입정렬
			return;
		}

		do {
			while (x[pl] < pivot)
				pl++;
			while (x[pr] > pivot)
				pr--;
			if (pl <= pr)
				swap(x, pl++, pr--);
		} while (pl <= pr);

		if (0 < pr) {
			int[] arrL = new int[pr+1]; //배열과 요소수만 전달하기 위해 새로 배열을 생성해 재귀 실행
			quickSort(arrL,arrL.length);
		}
		if (pl < n-1) {
			int[] arrR = new int[(n-1)-pl+1];
			quickSort(arrR, arrR.length);
		}
	}

	static void insertionSort(int[] a, int start, int end) {

		int len = end - start + 1;
		for (int i = start + 1; i < len; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > start && a[j - 1] > tmp; j--) { // 인덱스 0이상이면서 tmp요소보다 큰 요소들
				a[j] = a[j - 1]; // 요소 뒤로 밀기
			}
			a[j] = tmp; // tmp보다 작은 요소 바로 다음에 배치
		}

	}

	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}