import java.util.Scanner;

public class Q4_binSearchSpec {

	static int binSearchSen(int[] a, int n, int key) {
		
		System.out.print("   |");
		for(int j=0; j<n; j++)
			System.out.printf("%2d", j);
		System.out.print("\n---+");
		for(int j=0; j<n; j++)
			System.out.print("---");
		System.out.println();
		
		int i=0;
		int pl = 0; //검색 범위 시작점
		int pr = n-1; //검색 범위 끝점
		do{ //검색 범위가 유효한 동안
			int pc = (pl+pr)/2; //중앙 인덱스
        	System.out.print("   |");
        	if(pl < pc)
        		System.out.printf(String.format("%%%ds%%%ds+", pl*2+1, (pc-pl)*2), "<-", ""); //pl과 pc이 떨어져 있는 경우
        	else
        		System.out.printf(String.format("%%%ds<-+", pc*2), ""); //pl과 pc붙는 경우
        	
        	if(pc < pr)
        		System.out.printf(String.format("%%%ds->\n", (pr-pc)+1), ""); //pc와 pr이 떨어져 있는 경우
        	else
        		System.out.println("->"); //pc와 pr이 붙는 경우 띄어줄 필요없이 그냥 써주기
        	System.out.printf("%3d|", pc);
        	for(int j=0;j<n;j++) {
    			System.out.printf("%2d", a[j]);
        	}
        	System.out.println(); 
        	System.out.println("   |");  
        	if (a[pc] == key)    // 검색 성공
	        	return pc;
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

        int idx = binSearchSen(x, num, ky);              // 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("검색 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        

	}

}
