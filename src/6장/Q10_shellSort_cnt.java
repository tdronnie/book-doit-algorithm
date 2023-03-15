import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10_shellSort_cnt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �� �迭 ��� ����: ");
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // ��Ұ� n���� �迭 ����
		int[] a1 = new int[n]; // ����2 ���� �迭

		// �迭�� ��� ����
		for (int i = 0; i < n; i++) {
			System.out.print("�ε��� " + i + " ��� �Է�: ");
			a[i] = Integer.parseInt(br.readLine());
			a1[i] = a[i]; // �迭 a1���� ����
		}

		int cnt1 = shellSort(a, n);
		int cnt2 = shellSort2(a, n);

		for (int i = 0; i < n; i++)
			System.out.println("x[" + i + "]��" + a[i]);
		System.out.println("����1 ��� �̵� Ƚ��: " + cnt1);
		System.out.println("����2 ��� �̵� Ƚ��: " + cnt2);

	}

	static int shellSort(int[] a, int n) {
		int cnt1 = 0;
		for (int h = n / 2; h > 0; h /= 2) { // 4 -> 2 -> 1
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) { // ���� �׷� ������ ����, i��° ��� i+h��° ���
					a[j + h] = a[j]; // ���� ���� ��Ұ� �� ũ�� swap
					cnt1++; // �̵�Ƚ��
				}
				a[j + h] = tmp;
				cnt1++; // �̵�Ƚ��

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
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) { // ���� �׷� ������ ����, i��° ��� i+h��° ���
					a[j + h] = a[j]; // ���� ���� ��Ұ� �� ũ�� swap
					cnt2++; // �̵�Ƚ��
				}
				a[j + h] = tmp;
				cnt2++; // �̵�Ƚ��
			}

		}
		return cnt2;
	}

}
