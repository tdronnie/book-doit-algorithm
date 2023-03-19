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

		// Comparator 객체 생성
		static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();

		// 시력 내림차순 정렬하기 위한 Comparator
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision < d2.vision) ? 1 : // 시력 내림차순
						(d1.vision > d2.vision) ? -1 : 0;
			}
		}

	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("강민하", 162, 0.3),
				new PhyscData("김찬우", 173, 0.7),
				new PhyscData("박준서", 175, 2.0),
				new PhyscData("유서범", 171, 1.5), 
				new PhyscData("이수연", 168, 0.4),
				new PhyscData("장경오", 174, 1.2), 
				new PhyscData("황지안", 169, 0.8), };

		Arrays.sort(x, // 배열 x를
				PhyscData.VISION_ORDER // VISION_RORDER을 사용하여 정렬
		);

		System.out.println("■ 신체 검사 리스트 ■");
		System.out.println(" 이름        키     시력 ");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

	}

}
