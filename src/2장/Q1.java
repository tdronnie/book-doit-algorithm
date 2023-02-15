import java.util.Random;
//import java.util.Scanner;

public class Q1 {

	static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
//        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        
        int num = 1 + rand.nextInt(10); //1~10까지 사람 수 난수로 결정, seed=10
        System.out.println("사람 수: " + num);
        
        int[] height = new int[num];              // 요솟수가 num인 배열을 생성

        System.out.println("키의 최댓값을 구합니다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);        // 요솟값을 난수로 결정
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}