import java.util.Scanner;

public class Q17_counting_sort {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("���� ����");
		System.out.print("��ڼ� : ");
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

		countingSort(x, nx, max); // �迭 x�� ���� ����

		System.out.println("������������ �����Ͽ����ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]��" + x[i]);

	}

	static void countingSort(int[] a, int n, int max) {
		int[] f = new int[max + 1]; // ��������
		int[] b = new int[n]; // �۾��� ��ǥ �迭

		System.out.println("Step 1 : ��������ǥ �ۼ�"); // Step 1
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= max; k++)
				System.out.printf("%3d", f[k]);
			System.out.println();
			f[a[i]]++; // ��Ұ��� �ش��ϴ� �ε����� +1 ���ش�
		}
		for (int k = 0; k <= max; k++)
			System.out.printf("%3d", f[k]);
		System.out.println();

		System.out.println("Step 2 : ������������ǥ �ۼ�"); // Step 2
		for (int i = 1; i <= max; i++) {
			for (int k = 0; k <= max; k++)
				System.out.printf("%3d", f[k]);
			System.out.println();
			f[i] += f[i - 1]; // �ε��� 1���� �ڽ� ������ �ε��������� �����ؼ� �����ְ� �����Ѵ�.
		}
		for (int k = 0; k <= max; k++)
			System.out.printf("%3d", f[k]);
		System.out.println();

		System.out.println("Step 3 : ����"); // Step 3
		for (int i = n - 1; i >= 0; i--) {
			for (int k = 0; k < n; k++)
				System.out.printf("%3d", b[k]);
			System.out.println();
			b[--f[a[i]]] = a[i]; // ������������ǥ������ ���� ������ a�迭�� ���� �����Ѵ�
		}
		for (int k = 0; k < n; k++)
			System.out.printf("%3d", b[k]);
		System.out.println();

		// ��� �迭�� �־��� �迭�� ����
		for (int i = 0; i < n; i++)
			a[i] = b[i]; // Step 4

	}
}
