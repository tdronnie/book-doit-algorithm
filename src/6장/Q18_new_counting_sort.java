import java.util.Scanner;

public class Q18_new_counting_sort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("새로운 도수 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < 0);
		}

		int max = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] > max)
				max = x[i];
		
		int min = x[0];
		for(int i=1; i < nx; i++)
			if(x[i] < min)
				min = x[i];

		countingSort(x, nx, min, max); // 배열 x를 도수 정렬

		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);

	}

	//min이상 max 이하의 값 도수정렬
	static void countingSort(int[] a, int n, int min, int max) {
		int[] f = new int[max - min + 2];
		int[] b = new int[n]; //결과 배열

		for (int i = 0; i < n; i++) {
			f[a[i]-min]++; // 요소값에 해당하는 인덱스에 +1 해준다, 최소값 크기 만큼 빼준다.
		}
		for (int i = 1; i <= max-min+1; i++) {
			f[i] += f[i - 1]; // 인덱스 1부터 자신 이전의 인덱스값들을 누적해서 더해주고 저장한다, 최소값 크기 만큼 빼준다.
		}
		for (int i = n - 1; i >= 0; i--) {
			b[--f[a[i]-min]] = a[i]; // 누적도수분포표에서의 값의 순번에 a배열의 값을 저장한다, 최소값 크기 만큼 빼준다.
		}

		// 결과 배열을 주어진 배열에 복사
		for (int i = 0; i < n; i++)
			a[i] = b[i]; // Step 4

	}
}
