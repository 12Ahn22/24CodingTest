package 인프런.배열.점수계산;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int N, int[] input) {
        int answer = 0;
        int add = 0;

        for(int v : input){
            if(v == 1){
                answer += 1 + add;
                add++;
            }else{
                add = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int N = Integer.parseInt(in.nextLine());
        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(T.solution(N, input));
    }
}
