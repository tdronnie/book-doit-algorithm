import java.io.*;

public class Q1_search_pattern_brute_force {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է�: ");
		String str = br.readLine();

		System.out.print("���� �Է�: ");
		String pattern = br.readLine();

		drawFlow(str, pattern);

	}

	public static void drawFlow(String str, String p) {

		int ps = 0; // ���ڿ��� ������
		int pp = 0; // ������ ������
		int cnt = 0; // �� Ƚ��
		int idx = ps; // ���ϴ� ���� �ε���

		while (ps != str.length() && pp != p.length()) {
			cnt++;
			if (pp == 0) { // ���� Ž�� ������ ���
				System.out.printf("%2d %s\n", ps, str);
			} else {
				System.out.printf("   %s\n", str);
			}

			if (str.charAt(ps) == p.charAt(pp)) {
				
				System.out.printf(String.format("   %%%ds\n", idx + pp + 1), "+");
				System.out.printf(String.format("   %%%ds\n", idx + 1), p); //���� ���ڿ��� �̵����� ����...
//				System.out.println(ps + " " + pp + "���� ����" + " idx: " + idx);
//				System.out.println("idx: " + idx);
				ps++;
				pp++;
			} else {
				
				System.out.printf(String.format("   %%%ds\n", idx + pp + 1), "|");
				System.out.printf(String.format("   %%%ds\n", idx + 1), p);
//				System.out.println(ps + " " + pp + "���� �ٸ�" + " idx: " + idx);
//				System.out.println("idx: " + idx);
				ps = ps - pp + 1; // ppŽ���� ��ŭ �ٽ� �ǵ��ư��ְ� +1
				idx = ps; // ���� �ε��� ������Ʈ
				pp = 0; // Ž�� �ʱ�ȭ
			}
			System.out.println();
		}

		

		if (pp == p.length()) {
//			return ps - pp; //������ ã���� ��� ������ ��ġ�ϴ� ù��° �ε��� ����
			System.out.println("�񱳸� " + cnt + "ȸ �߽��ϴ�");
			return;
		}
		System.out.println("�񱳸� " + cnt + "ȸ �߽��ϴ�");
		System.out.println("�ش� ������ ã�� ���߽��ϴ�.");
	}

}
