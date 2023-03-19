import java.util.Scanner;

public class Q18_new_counting_sort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("���ο� ���� ����");
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
		
		int min = x[0];
		for(int i=1; i < nx; i++)
			if(x[i] < min)
				min = x[i];

		countingSort(x, nx, min, max); // �迭 x�� ���� ����

		System.out.println("������������ �����Ͽ����ϴ�.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]��" + x[i]);

	}

	//min�̻� max ������ �� ��������
	static void countingSort(int[] a, int n, int min, int max) {
		int[] f = new int[max - min + 2];
		int[] b = new int[n]; //��� �迭

		for (int i = 0; i < n; i++) {
			f[a[i]-min]++; // ��Ұ��� �ش��ϴ� �ε����� +1 ���ش�, �ּҰ� ũ�� ��ŭ ���ش�.
		}
		for (int i = 1; i <= max-min+1; i++) {
			f[i] += f[i - 1]; // �ε��� 1���� �ڽ� ������ �ε��������� �����ؼ� �����ְ� �����Ѵ�, �ּҰ� ũ�� ��ŭ ���ش�.
		}
		for (int i = n - 1; i >= 0; i--) {
			b[--f[a[i]-min]] = a[i]; // ������������ǥ������ ���� ������ a�迭�� ���� �����Ѵ�, �ּҰ� ũ�� ��ŭ ���ش�.
		}

		// ��� �迭�� �־��� �迭�� ����
		for (int i = 0; i < n; i++)
			a[i] = b[i]; // Step 4

	}
}
