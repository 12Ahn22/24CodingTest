package 인프런.배열.큰수출력하기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) answer.add(arr[i]);
        }
        return answer;
    }

    public String solution(int N, String input) {
        StringBuilder answer = new StringBuilder();

        // 공백으로 쪼개서 배열을 만들어야하는구나..
        String[] list = input.split(" ");

        // 첫 글자는 무조곤 입력
        int prev = Integer.parseInt(list[0]);
        answer.append(prev);
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(list[i]);
            if (cur > prev) {
                answer.append(" ");
                answer.append(cur);
            }
            prev = cur;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = Integer.parseInt(in.nextLine());
        String input = in.nextLine();
        System.out.println(T.solution(N, input));
    }
}
