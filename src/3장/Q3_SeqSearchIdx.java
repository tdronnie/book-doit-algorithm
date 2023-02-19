import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Q3_SeqSearchIdx {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("요소 수 입력:" );
		int n = Integer.parseInt(br.readLine()); //배열 
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.print("찾으려는 키 입력:" );
		int key = Integer.parseInt(br.readLine());
		
		int[] idx = new int[n]; //일단 최대 담을 수 있는 n으로 크기 설정 , 책에서 searchIdx의 매개변수를 배열로 잡음
		int idxNum = searchIdx(arr, n, key, idx);
		System.out.print("총 " + idxNum + "번 검색이 되었습니다.\n검색 인덱스 위치: ");
		for(int val: idx) {
			if(val == -1)
				break;
			System.out.print(val + " ");
		}
		
	}
	
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		
		int j=0;
		for(int i=0; i<n; i++) {
			if(a[i] == key) {
				idx[j++] = i; // 키값을 찾았을 경우 idx배열에 인덱스 저장
			}
		}
		idx[j] = -1; //인덱스 저장한 부분과 단순 초기화 부분 나누기 위한 표시
		return j; 
	}

}
