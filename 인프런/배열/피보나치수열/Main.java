package 인프런.배열.피보나치수열;

import java.util.Scanner;

public class Main {
    // 피보나치
    // 앞의 두 수를 합쳐서 다음 숫자가 되는 수열이다.
    public int[] solution(int N) {
        // 초기화
        int[] list = new int[N];
        list[0] = 1;
        list[1] = 1;

        for(int i = 2; i < N; i ++){
            list[i] = list[i-1] + list[i-2];
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        // 입력은 총 항의 개수이다.
        int N = in.nextInt();
        int[] list = T.solution(N);
        for(int i : list){
            System.out.print(i +" ");
        }
    }
}
