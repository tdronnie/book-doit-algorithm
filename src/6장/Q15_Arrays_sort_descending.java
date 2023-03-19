import java.util.*;

public class Q15_Arrays_sort_descending {

	static class PhyscData {
		String name;
		int height;
		double vision;

		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		@Override
		public String toString() {
			return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}

		// Comparator ��ü ����
		static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();

		// �÷� �������� �����ϱ� ���� Comparator
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision < d2.vision) ? 1 : // �÷� ��������
						(d1.vision > d2.vision) ? -1 : 0;
			}
		}

	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("������", 162, 0.3),
				new PhyscData("������", 173, 0.7),
				new PhyscData("���ؼ�", 175, 2.0),
				new PhyscData("������", 171, 1.5), 
				new PhyscData("�̼���", 168, 0.4),
				new PhyscData("����", 174, 1.2), 
				new PhyscData("Ȳ����", 169, 0.8), };

		Arrays.sort(x, // �迭 x��
				PhyscData.VISION_ORDER // VISION_RORDER�� ����Ͽ� ����
		);

		System.out.println("�� ��ü �˻� ����Ʈ ��");
		System.out.println(" �̸�        Ű     �÷� ");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

	}

}
