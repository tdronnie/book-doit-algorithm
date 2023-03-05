import java.util.ArrayList;

public class Q6_no_recur {

	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {

		recur3(5);

	}

	public static void recur3(int n) {
		while (true) {
			if (n > 0) { //조건이 만족하는 이상 첫번째 재귀를 끝내줘야 함, 그동안 연산에서 사용되는 n을 저장해둠(두번째 재귀에서 쓰기 위함)
				list.add(n);
				n--;
				continue;
			}
			if (!list.isEmpty()) {
				n = list.remove(list.size()-1); //리스트에 마지막에 저장된 값을 n으로
				System.out.println(n);
				n = n - 2;
				continue;
			}
			
			break;

		}
	}

}
