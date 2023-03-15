import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q13_change_insertSort {

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

		quickSort(a, 0, n - 1);

		System.out.println(Arrays.toString(a));

	}

	static void quickSort(int[] a, int left, int right) {
		int pl = left; // ���� ������ ������Ʈ
		int pr = right; // ������ ������ ������Ʈ
		int x = a[(pl + pr) / 2]; // ��� ��� �ǹ����� �Ѵ�

		// �����Ϸ��� ��Ҽ��� 9�� ������ ��� �ܼ��������ķ� �����Ѵ�.
		if (pr - pl + 1 <= 9) {
			System.out.printf("�ε��� %d���� %d���� ��Ҽ��� 9�� �����̹Ƿ� �������� ����\n", pl, pr);
			insertionSort(a, pl, pr); //�ش� �κи� ��������
			return;
		}

		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		if (left < pr) {
			quickSort(a, left, pr);
		}
		if (pl < right) {
			quickSort(a, pl, right);
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