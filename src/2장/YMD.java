import java.util.Scanner;

public class YMD {

	int y; //년
	int m; //월
	int d; //일
	
	public YMD(int y, int m, int d) {
		super();
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	public YMD after(int n) {
		YMD value = new YMD(this.y, this.m, this.d);
		
		value.d += n;
		
		if(value.d>28) {
			if((value.m==2)) { //2월인 경우
	            value.m++;
	            value.d -= 28;
			}
		}
		else if(value.d>30) {
			if((value.m==4)||(value.m==6)||(value.m==9)||(value.m==11)) { //30일 달
				value.m++;
	            value.d -= 30;
			}
		}
		else {
            if(value.d>31) { //31일 달
            	value.m++;
	            value.d -= 31;
            }
        }
		
		if(value.m > 13) {
			value.y++;
			value.m = 1; 
		}
		return value;
	}
	
	public YMD before(int n) {
		YMD value = new YMD(this.y, this.m, this.d);
		
		value.d -= n;
		
		if(value.d<0) {
			value.m--;
			if((value.m==2)) { //2월인 경우
	            value.d = 28 + value.d;
			}
			else if((value.m==4)||(value.m==6)||(value.m==9)||(value.m==11)) { //30일 달
	            value.d = 30 + value.d;
			}
			else { //31일 달
	            value.d = 30 + value.d;
			}
		}
		
		if(value.m < 1) {
			value.y--;
			value.m = 12; 
		}
		return value;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
	
		System.out.print("년 : ");
		int y = stdIn.nextInt();
		System.out.print("월 : ");
		int m = stdIn.nextInt();
		System.out.print("일 : ");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);
	
		System.out.print("며칠 전/후의 날짜를 구할까요? : ");
		int n = stdIn.nextInt();
	
		YMD d1 = date.after(n);
		System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다.\n", n, d1.y, d1.m, d1.d);
	
		YMD d2 = date.before(n);
		System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다.\n", n, d2.y, d2.m, d2.d);
	
	}

}
