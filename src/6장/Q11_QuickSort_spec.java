import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Q11_QuickSort_spec {

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

		quickSort(a, 0, n-1);
		
		System.out.println(Arrays.toString(a));

	}

	static void quickSort(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1); //�����Ϸ��� �迭�� ���� �ε���
		IntStack rstack = new IntStack(right - left + 1); //�����Ϸ��� �迭�� �� �ε���

		lstack.push(left);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop(); // ���� ������ ������Ʈ
			int pr = right = rstack.pop(); // ������ ������ ������Ʈ
			int x = a[(left + right) / 2]; // ��� ��� �ǹ����� �Ѵ�
			System.out.printf("���ÿ��� ��. ���� %d���� %d���� �� ���� ����\n", left, right);

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (left < pr) {
				lstack.push(left); // ���� �׷��� ���� �ε��� Ǫ��
				rstack.push(pr); // ���� �׷��� �� �ε��� Ǫ��
				System.out.printf("���� �׷�, �ε��� %d���� �ε���%d���� ���� Ǫ��\n", left, pr);
				System.out.print("���� �׷�: ");
				lstack.dump();
				System.out.print("������ �׷�: ");
				rstack.dump();
			}
			if (pl < right) {
				lstack.push(pl); // ������ �׷��� ���� �ε��� Ǫ��
				rstack.push(right); // ������ �׷��� �� �ε��� Ǫ��
				System.out.printf("������ �׷�, �ε��� %d���� �ε���%d���� ���� Ǫ��\n", pl, right);
				System.out.print("���� �׷�:");
				lstack.dump();
				System.out.print("������ �׷�: ");
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
