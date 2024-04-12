package 인프런.배열.격자판최대합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력
    public int solution(int N, int[][] input) {
        int answer = 0;

        // 행 검사
        for (int i = 0; i < N; i++) {
            int[] row = input[i];
            int sumRow = Arrays.stream(row).sum();
            answer = Math.max(answer, sumRow);
        }

        // 열 검사
        for (int i = 0; i < N; i++) { // 열
            int sumCol = 0;
            for (int j = 0; j < N; j++) { // 행
                int cur = input[j][i];
                sumCol += cur;
            }
            answer = Math.max(answer, sumCol);
        }

        // 대각선 검사
        // [0,0][1,1][2,2][3,3][4,4]
        // [0,5][1,4][2,2][3,2][4,0]
        int diagonal = 0;
        int diagonal2 = 0;
        for (int i = 0; i < N; i++) {
            diagonal += input[i][i];
            diagonal2 += input[i][N - i - 1];
        }
        answer = Math.max(answer, diagonal);
        answer = Math.max(answer, diagonal2);

        return answer;
    }

    public int solution2(int n, int[][] arr) {
        int answer = -2147000000;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        // 배열은 N*N 크기로 고정
        int N = Integer.parseInt(in.nextLine());
        int[][] input = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input[i] = arr;
        }
        System.out.println(T.solution(N, input));
    }
}
