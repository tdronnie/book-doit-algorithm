import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14_newQuickSort {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �� �迭 ��� ����: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // ��Ұ� n���� �迭 ����

		// �迭�� ��� ����
		for (int i = 0; i < n; i++) {
			System.out.print("�ε��� " + i + " ��� �Է�: ");
			a[i] = Integer.parseInt(br.readLine());
		}

		quickSort(a, n);

		System.out.println(Arrays.toString(a));

	}

	//quickSort(�迭, ��Ҽ�)�� ����
	static void quickSort(int[] x, int n) {
		int pl = 0; // ���� ������ ������Ʈ
		int pr = n-1; // ������ ������ ������Ʈ
		int pivot = x[(pl + pr) / 2]; // ��� ��� �ǹ����� �Ѵ�

		// �����Ϸ��� ��Ҽ��� 9�� ������ ��� �ܼ��������ķ� �����Ѵ�.
		if (n <= 9) {
			System.out.printf("�ε��� %d���� %d���� ��Ҽ��� 9�� �����̹Ƿ� �������� ����\n", pl, pr);
			insertionSort(x, pl, pr); // �ش� �κи� ��������
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
			int[] arrL = new int[pr+1]; //�迭�� ��Ҽ��� �����ϱ� ���� ���� �迭�� ������ ��� ����
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
			for (j = i; j > start && a[j - 1] > tmp; j--) { // �ε��� 0�̻��̸鼭 tmp��Һ��� ū ��ҵ�
				a[j] = a[j - 1]; // ��� �ڷ� �б�
			}
			a[j] = tmp; // tmp���� ���� ��� �ٷ� ������ ��ġ
		}

	}

	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}