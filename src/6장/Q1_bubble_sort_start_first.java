//배열의 앞에서 시작해서 오름차순으로 버블정렬하기
import java.io.*;
import java.util.Arrays;

public class Q1_bubble_sort_start_first {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("버블정렬 할 배열 요소 개수: ");
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n]; //요소가 n개인 배열 생성
		
		//배열에 요소 저장
		for(int i=0; i<n; i++) {
			System.out.print("인덱스 " + i + " 요소 입력: ");
			a[i] = Integer.parseInt(br.readLine());
		}
		
		bubbleSort(a, n);
		
		System.out.println(Arrays.toString(a));

	}
	
	//n개 요소를 가지는 배열 a를 버블정렬하는 메소드 
	static void bubbleSort(int[] arr, int n) {
		for(int i=n-1; i>0; i--) { //배열 끝에 정렬 완료한 부분
			for(int j=0; j<i; j++) { //정렬되지 않은 요소 정렬, i-1까지 실행
				if(arr[j+1] < arr[j]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	//이웃한 두 요소 스위칭 해주는 메소드
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
