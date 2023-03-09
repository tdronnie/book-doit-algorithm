import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_bubble_sort_remove_dup_spec {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("버블정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n개인 배열 생성

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		bubbleSort(a, n);

	}

	// n개 요소를 가지는 배열 a를 버블정렬하는 메소드
	static void bubbleSort(int[] arr, int n) {
		int cprCnt = 0; // 비교 카운터
		int exCnt = 0; // 교환 카운터
		int exNum = 0; // 한 패스에서 교환 카운터
		int flag = 0; // 정렬 중단여부 위한 플래그변수

		int done = 0; // arr[done] 앞부분은 정렬완료
		int i = 1; // 패스 카운터
		while (done < n - 1) { // done이 n-2고 n-1에 대해서 정렬할 때까지
			System.out.println("패스" + i++ + ":"); // 한 사이클 나타내는 패스 부분

			int last = n - 1; // 마지막 교환 위치
			for (int j = n - 1; j > done; j--) { // done+1까지만 정렬 작업
				for (int k = 0; k < j - 1; k++) {
					System.out.printf("%2d", arr[k]); // 정렬 범위 중 교환부분 앞부분 j-1까지 출력
				}
				cprCnt++;
				if (arr[j - 1] > arr[j]) {
					System.out.printf("%2d%c%d", arr[j - 1], '+', arr[j]);// 요소와 교환 수행O 출력
					swap(arr, j - 1, j);
					exCnt++; // 교환 카운터+1
					exNum++; // 한 패스에서 교환 카운터+1
					last = j; // 마지막 교환 인덱스 갱신
				} else { // 이미 정렬되어있음
					System.out.printf("%2d%c%d", arr[j - 1], '-', arr[j]);// 요소와 교환 수행X 출력
				}
				if (j != n - 1) { // j가 마지막 요소 아니라면 정렬 범위 중 교환부분 뒷부분 j+1부터 출력
					for (int k = j + 1; k < n; k++)
						System.out.printf("%2d", arr[k]);
				}
				System.out.println();
			}
			for (int z = 0; z < n; z++) // 패스 끝난 결과 마지막줄 출력
				System.out.printf("%2d", arr[z]);
			System.out.println("\n");

			if (exNum == 0) { // 교환 횟수가 0이라면 정렬 끝내기
				flag = 1; // 정렬 중단!
				break;
			}
			done = last; // 마지막 교환 인덱스까지 정렬 완료
		}

		if (flag == 1)
			System.out.println("정렬 중단");
		System.out.println("비교를 " + cprCnt + "회 했습니다");
		System.out.println("교환을 " + exCnt + "회 했습니다");
	}

	// 이웃한 두 요소 스위칭 해주는 메소드
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}