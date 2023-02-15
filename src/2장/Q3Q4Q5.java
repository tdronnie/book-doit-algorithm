import java.util.Arrays;

public class Q3Q4Q5 {

	//--- 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 배열 a의 요소를 역순으로 정렬 ---//
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++)
            swap(a, i, a.length - i - 1);
        System.out.println("역순 복사 배열: " + Arrays.toString(a));
    }
    
    //배열 합 구하는 메소드
    static int sumOf(int[] a) {
    	int sum = 0;
    	for(int i=0; i<a.length; i++) {
    		sum += a[i];
    	}
    	return sum;
    }
    
    //배열 b를 a에 복사하는 메소드
    static void copy(int[] a, int[] b) {
    	//1
    	a = b.clone();
    	//2. 끝 지정 (인덱스0부터 시작)
//    	Arrays.copyOf(a, a.length);
    	//3. 시작점, 끝 지정 가능
//    	Arrays.copyOfRange(a, 0, a.length);
    	//4. 대상 배열 복사 위치 지정 가능
//    	System.arraycopy(b, 0, a, 0, a.length);
    	System.out.println("복사 배열: " + Arrays.toString(a));
    	
    }
    
    static void rcopy(int[] a, int[] b) {
    	a = b.clone(); //배열 복사
    	reverse(a); //역순 정렬
    }

    public static void main(String[] args) {

        int[] x = {2,5,1,3,9,6,7};
        
        int[] y = new int[x.length]; //복사할 배열
        int[] z = new int[x.length];//거꾸로 복사할 배열

        int sum = sumOf(x); //배열 값들 합
        System.out.println("배열 합: " + sum);
        copy(y, x); //배열 복사
        rcopy(z, x); //배열 거꾸로 복사

    }
}