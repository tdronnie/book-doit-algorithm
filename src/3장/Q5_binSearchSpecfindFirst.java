import java.util.Scanner;

public class Q5_binSearchSpecfindFirst {

static int binSearchX(int[] a, int n, int key) {
		
		int pl = 0; //검색 범위 시작점
		int pr = n-1; //검색 범위 끝점
		do{ //검색 범위가 유효한 동안
			int pc = (pl+pr)/2; //중앙 인덱스

        	if (a[pc] == key) {    // 검색 성공
        		for(;pc>pl;pc--) { //맨 앞의 키값 찾기
        			if(a[pc] != key) //키값이 아닐 때 끝
        				break;
        		}
	        	return pc+1;
        	}
        	else if(a[pc] < key) { //검색 범위가 중앙보다 왼쪽에 존재
        		pl = pc+1;
        	}
        	else //검색 범위가 중앙보다 오른쪽에 존재
        		pr = pc-1;
        	         
        } while(pl <= pr);
		
        return -1; //검색 실패
	}
	
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];                        // 요솟수가 num + 1인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색 값 : ");                    // 키값을 읽력받음
        int ky = stdIn.nextInt();

        int idx = binSearchX(x, num, ky);              // 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("검색 값의 요소가 없습니다.");
        else
            System.out.println("첫번째 " + ky + "은(는) x[" + idx + "]에 있습니다.");
        

	}

}