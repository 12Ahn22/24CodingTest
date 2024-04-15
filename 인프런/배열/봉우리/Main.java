package 인프런.배열.봉우리;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 자신의 상하좌우보다 숫자가 크다면, 봉우리다.
    // 가장자리들은 모두 0으로 초기화 되었다고 가정한다.

    /**
     * 4방향을 하나씩 비교한 방법
     */
    public int solution(int N, int[][] input) {
        int answer = 0;

        // 배열을 순회한다.
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                // 비교 대상
                int cur = input[row][col];
                boolean isPeak = true;

                // 상
                if (row - 1 >= 0) { // row가 터지지않을 경우
                    if (input[row - 1][col] >= cur) isPeak = false;
                }
                // 하
                if (row + 1 < N) {
                    if (input[row + 1][col] >= cur) isPeak = false;
                }
                // 좌
                if (col - 1 >= 0) {
                    if (input[row][col - 1] >= cur) isPeak = false;
                }
                // 우
                if (col + 1 < N) {
                    if (input[row][col + 1] >= cur) isPeak = false;
                }

                if (isPeak) answer++;
            }
        }
        return answer;
    }

    public int solution2(int n, int[][] arr) {
        // 확인해야하는 4방향을 위한 증감값을 배열로 설정해놓는다.
        // 이걸 초기화 해놓고 for문을 돌리는 방식으로 상하좌우를 확인한다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        // 2차원 배열 순회를 위한 2중 for문 i와 j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true; // 하나의 격자라도 틀리면 false 처리하기 위한 플래그
                for (int k = 0; k < 4; k++) { // 4방향 확인을 위한 for문
                    int nx = i + dx[k]; // row 좌표
                    int ny = j + dy[k]; // col 좌표
                    // if문은 좌표가 터지는 것을 방지함
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        // 상하좌우의 값이 현재 위치 arr[i][j]보다 크면, 현재 위치는 봉우리가 아니다.
                        flag = false; // false 처리
                        break; // 하나라도 false가 나오면 4방향 검사를 하는 for문을 break한다.
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = Integer.parseInt(in.nextLine());
        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input[i] = arr;
        }

        System.out.println(T.solution(N, input));
    }
}
