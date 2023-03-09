import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_selection_sort_spec {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("선택정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n개인 배열 생성

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		selectionSort(a, n);

	}

	static void selectionSort(int[] a, int n) {

		for (int i = 0; i < n - 1; i++) { // 인덱스 i와 교환
			int min = i;
			System.out.printf(String.format("%%%ds*", (i * 2) + 1), ""); //정렬 완료된 부분, 공백2칸으로 함
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			System.out.printf(String.format("%%%ds+", (min*2)-((i * 2) + 1)), ""); //(min까지 길이 - *까지 길이)만큼 공백 확보 후 출력
			System.out.println();
			for (int z = 0; z < n; z++)
				System.out.printf("%2d", a[z]);
			System.out.println();
			swap(a, i, min);
		}
		System.out.println();
		for (int z = 0; z < n; z++) //정렬 최종 결과
			System.out.printf("%2d", a[z]);
		System.out.println();
	}

	// 이웃한 두 요소 스위칭 해주는 메소드
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
