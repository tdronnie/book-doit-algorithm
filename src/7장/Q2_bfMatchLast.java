import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_bfMatchLast {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է�: ");
		String str = br.readLine();

		System.out.print("���� �Է�: ");
		String pattern = br.readLine();

		bfMatchLast(str, pattern);

	}
	static int bfMatchLast(String str, String p) {
		int ps = str.length()-1; // ���ڿ��� ������
		int pp = str.length()-1; // ������ ������

		while (ps >= 0 && pp >= 0) { //�ں��� Ž�� �����ؼ� 0�̻� �϶�����

			if (str.charAt(ps) == p.charAt(pp)) {				
				ps--;
				pp--;
			} else {
				ps = ps + (p.length() - pp) - 2; //?
				pp = p.length() - 1; //���� �� �ε����� �ʱ�ȭ
			}
		}
		if (pp < 0)
			return ps + 1;
		return -1;	
	}
}
