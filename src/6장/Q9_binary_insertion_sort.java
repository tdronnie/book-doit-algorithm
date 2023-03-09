import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9_binary_insertion_sort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("이진검색을 이용한 삽입정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n+1개인 배열 생성, a[0]에 보초값 저장

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		insertionSort(a, n);

	}

	static void insertionSort(int[] a, int n) {

		for (int i = 1; i < n; i++) {
			int tmp = a[i];
			//아래 로직이 이미 정렬된 부분에서 a[i]가 들어갈 위치 찾는 것
//			for (j = i; j > 0 && a[j - 1] > tmp; j--) { // 인덱스 0이상이면서 tmp요소보다 큰 요소들
//				a[j] = a[j - 1]; // 요소 뒤로 밀기
//			}
			int loc = binarySearch(a, 0, i, tmp); //배열 a의 정렬된 부분 인덱스 0부터 i까지 tmp가 들어갈 위치 이진검색으로 찾기
			
			//한자리씩 뒤로 밀기
			for(int j=i; loc<j; j-- ) {
				a[j] = a[j-1];
			}
			a[loc] = tmp; // tmp보다 작은 요소 바로 다음에 배치

		}
		for (int z = 0; z < n; z++) // 정렬 완료 배열 출력
			System.out.printf("%2d", a[z]);
		System.out.println();
	}

	static int binarySearch(int[] a, int start, int end, int key) {

		int pl = start; // 검색 범위 시작점
		int pr = end; // 검색 범위 끝점
		do { // 검색 범위가 유효한 동안
			int pc = (pl + pr) / 2; // 중앙 인덱스

			if (a[pc] >= key && a[pc-1] <= key) // pc자리 들어갈 수 있음
				return pc;
			else if (a[pc] < key) { // 검색 범위가 중앙보다 왼쪽에 존재
				pl = pc + 1;
			} else // 검색 범위가 중앙보다 오른쪽에 존재
				pr = pc - 1;

		} while (pl <= pr);

		return -1; // 검색 실패
	}

}
