import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Q11_QuickSort_spec {

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

		quickSort(a, 0, n-1);
		
		System.out.println(Arrays.toString(a));

	}

	static void quickSort(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1); //분할하려는 배열의 시작 인덱스
		IntStack rstack = new IntStack(right - left + 1); //분할하려는 배열의 끝 인덱스

		lstack.push(left);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop(); // 왼쪽 포인터 업데이트
			int pr = right = rstack.pop(); // 오른쪽 포인터 업데이트
			int x = a[(left + right) / 2]; // 가운데 요소 피벗으로 한다
			System.out.printf("스택에서 팝. 범위 %d부터 %d까지 퀵 정렬 시작\n", left, right);

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (left < pr) {
				lstack.push(left); // 왼쪽 그룹의 시작 인덱스 푸시
				rstack.push(pr); // 왼쪽 그룹의 끝 인덱스 푸시
				System.out.printf("왼쪽 그룹, 인덱스 %d부터 인덱스%d까지 스택 푸시\n", left, pr);
				System.out.print("왼쪽 그룹: ");
				lstack.dump();
				System.out.print("오른쪽 그룹: ");
				rstack.dump();
			}
			if (pl < right) {
				lstack.push(pl); // 오른쪽 그룹의 시작 인덱스 푸시
				rstack.push(right); // 오른쪽 그룹의 끝 인덱스 푸시
				System.out.printf("오른쪽 그룹, 인덱스 %d부터 인덱스%d까지 스택 푸시\n", pl, right);
				System.out.print("왼쪽 그룹:");
				lstack.dump();
				System.out.print("오른쪽 그룹: ");
				rstack.dump();
			}
		}
	}

	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
