import java.util.Scanner;

public class Q16_heap_sort_spec {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("힙 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		heapSort(x, nx);

		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);

	}

	// --- 힙 정렬 ---//
	static void heapSort(int[] a, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			downHeap(a, i, n - 1); // 초기배열 힙으로 만들기
		}

		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i); // 가장 큰 요소와 제일 끝 요소 교환
			downHeap(a, 0, i - 1); // 정렬된 부분 제외하고 힙으로 만들기
		}
	}

	// --- a[left]~a[right]을 힙으로 만들기 ---//
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left]; // 루트
		int child; // 큰 쪽의 자식
		int parent; // 부모

		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1; // 왼쪽 자식
			int cr = cl + 1; // 오른쪽 자식
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 쪽
			if (temp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;

		print(a, a.length);
	}

	static void print(int[] a, int n) {
		int i = n;
		int height = 1; // 트리의 높이
		while ((i >>= 1) > 0) //트리의 높이 계산, i가 1비트 오른쪽으로,i/2구하기 위함
			height++;
		i = 0;
		int w = 1; //층
		Loop: {
			for (int level = 0; level < height; level++) {
				dispSpace(pow2(height - level) - 2);
				for (int k = 0; k < w; k++) {
					System.out.printf("%02d", a[i++]); //배열 요소 출력
					if (i >= n) //배열 요소 모두 출력했다면
						break Loop; //level 0으로 돌아가서 다시 시작
					if (k < w - 1) //공백 띄우기
						dispSpace(pow2(height - level + 1) - 2);
				}
				System.out.println(); //가지 층으로 개행

				dispSpace(pow2(height - level) - 3); //가지 층에 공백 띄우기
				for (int k = 0; k < w; k++) {
					if (2 * k + i < n) //왼쪽 자식
						System.out.print("/");
					if (2 * k + i + 1 < n) //오른쪽 자식
						System.out.print("＼");
					if (k < w - 1) //공백 띄우기
						dispSpace(pow2(height - level + 1) - 4);
				}
				System.out.println();
				w *= 2; //다음 숫자층
			}
		}
		System.out.println();
		System.out.println();
	}

	// --- 2의 n승을 구합니다 ---*/
	static int pow2(int n) {
		int k = 1;

		while (n-- > 0)
			k *= 2;
		return k;
	}

	// --- n개의 스페이스(공백문자)를 출력 ---//
	static void dispSpace(int n) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

}
