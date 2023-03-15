import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10_shellSort_cnt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("셸정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 요소가 n개인 배열 생성
		int[] a1 = new int[n]; // 버전2 위한 배열

		// 배열에 요소 저장
		for (int i = 0; i < n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
			a1[i] = a[i]; // 배열 a1에도 저장
		}

		int cnt1 = shellSort(a, n);
		int cnt2 = shellSort2(a, n);

		for (int i = 0; i < n; i++)
			System.out.println("x[" + i + "]＝" + a[i]);
		System.out.println("버전1 요소 이동 횟수: " + cnt1);
		System.out.println("버전2 요소 이동 횟수: " + cnt2);

	}

	static int shellSort(int[] a, int n) {
		int cnt1 = 0;
		for (int h = n / 2; h > 0; h /= 2) { // 4 -> 2 -> 1
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) { // 같은 그룹 내에서 정렬, i번째 요소 i+h번째 요소
					a[j + h] = a[j]; // 만약 이전 요소가 더 크면 swap
					cnt1++; // 이동횟수
				}
				a[j + h] = tmp;
				cnt1++; // 이동횟수

			}
		}
		return cnt1;
	}

	static int shellSort2(int[] a, int n) {
		int cnt2 = 0;
		int h;

		for (h = 1; h < n; h = n * 3 + 1) // 40 -> 13 -> 4 -> 1
			;
		for (; h > 0; h /= 3) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) { // 같은 그룹 내에서 정렬, i번째 요소 i+h번째 요소
					a[j + h] = a[j]; // 만약 이전 요소가 더 크면 swap
					cnt2++; // 이동횟수
				}
				a[j + h] = tmp;
				cnt2++; // 이동횟수
			}

		}
		return cnt2;
	}

}
