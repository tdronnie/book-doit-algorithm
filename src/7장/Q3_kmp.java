import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_kmp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է�: ");
		String str = br.readLine();

		System.out.print("���� �Է�: ");
		String pattern = br.readLine();

		int idx = kmpMatch(str, pattern);
		
		if (idx == -1)
	         System.out.println("�ؽ�Ʈ�� ������ �����ϴ�.");
	      else {
	         // ��ġ�ϴ� ���� �ٷ� �ձ����� ���� ������ �ݰ����ڷ� ȯ���Ͽ� ����
	         int len = 0;
	         for (int i = 0; i < idx; i++)
	            len += str.substring(i, i + 1).getBytes().length;
	         len += pattern.length();

	         System.out.println((idx + 1) + "��° ���ں��� ��ġ�մϴ�.");
	         System.out.println("�ؽ�Ʈ : " + str);
	         System.out.printf(String.format("��  �� : %%%ds\n", len), pattern);
	      }

	}

	// --- KMP���� ���� ���ڿ��˻� ---//
	static int kmpMatch(String txt, String pat) {
		int pt = 1; // ��ü ���ڿ� �ε���
		int pp = 0; // ���� �ε���
		int count = 0; // �� ȸ��
		int[] skip = new int[pat.length() + 1]; // �ǳʶٱ� ǥ, �ߺ��Ǵ� �κ� ã�Ƽ� �ٽ� �˻��� �κ� ����
		int k = -1;

		// �ǳʶٱ�ǥ �ۼ�
		System.out.println("�ǳʶٱ�ǥ �ۼ�");
		skip[pt] = 0;
		while (pt != pat.length()) { //���� ���̸�ŭ
			//Ž�� �����ϴ� �ε��� ���
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			//��ü ���ڿ� ���
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();
			
			//��ȣ���� ����ó��
			for (int i = 0; i < pt * 2 + 4; i++) 
				System.out.print(" ");
			
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|'); //���� ��� + �ٸ� ��� |
			System.out.println();

			//���� ���ڿ� ����ó��
			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			//���� ���ڿ� ���
			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			
			System.out.println();
			System.out.println();
			
			//��ȸ�� ���� �� ���� ���ؼ� ǥ�� �ٽ� �˻� ������ �ε��� �ֱ�
			count++;
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0) //ó�� �ε����� ��� �׳� �ѱ��
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}

		// �˻�
		System.out.println("�˻�");
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();

			for (int i = 0; i < pt * 2 + 4; i++)
				System.out.print(" ");
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			
			//������ �� ���Ʈ�����ʹ� �ٸ��� �����ϴ� ��찡 ����.
			count++;
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];
		}

		System.out.printf("�񱳸� %dȸ �߽��ϴ�.\n", count);
		if (pp == pat.length()) // ������ ��� ���ڸ� ����
			return pt - pp;
		return -1; // �˻� ����
	}

}
