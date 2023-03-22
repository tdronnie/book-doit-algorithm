import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_bmMatch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է�: ");
		String str = br.readLine();

		System.out.print("���� �Է�: ");
		String pattern = br.readLine();

		int idx = bmMatch(str, pattern);

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
	
	static int bmMatch(String txt, String pat) {
		int pt; //��ü ���ڿ� �ε���
		int pp;	//���� �ε���
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1];	// �ǳʶٱ� ǥ
		int count = 0;   // �� ȸ��
		int k = -1;

		// �ǳʶٱ� ǥ �ۼ�
		for (pt = 0; pt <= Character.MAX_VALUE; pt++) //��ü ���ĺ��� ���ؼ� ����
			skip[pt] = patLen;
		for (pt = 0; pt < patLen - 1; pt++)
			skip[pat.charAt(pt)] = patLen - pt - 1;
		// pt == patLen - 1
		// �˻�
		while (pt < txtLen) {
			pp = patLen - 1; //������ ���ں��� �˻�

			
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

			for (int i = 0; i < (pt-pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			count++;

			while (txt.charAt(pt) == pat.charAt(pp)) {

				if (pp == 0)
					return pt;         // �˻� ����
				pp--;
				pt--;
				
				//�˻��ϴ� ���� �����ε���(�����˻�� ������ �ε�������)
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

				for (int i = 0; i < (pt-pp) * 2 + 4; i++)
					System.out.print(" ");

				for (int i = 0; i < pat.length(); i++)
					System.out.print(pat.charAt(i) + " ");
				System.out.println();
				System.out.println();
				count++;
			}
			pt += skip[txt.charAt(pt)]; //ǥ�� ���� �ű�
		}
		return -1;									// �˻� ����
	}

}
