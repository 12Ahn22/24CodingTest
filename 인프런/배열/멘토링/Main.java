package 인프런.배열.멘토링;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    // 멘토-멘티가 될 수 있는 짝의 개수를 출력하는 문제
    // 멘토는 모든 시험에서 멘티보다 등수가 앞에 있어야한다.
    public int ERROR(int testCount, int student, int[][] test) {
        int answer = 0;

        // 각 학생의 최고 등수를 구하면 되지않을까?..
        // 최고 등수끼리 비교해서 크다면 answer ++ 하면 되지않을까?

        // 인덱스가 학생이다. 값이 그 학생이 가진 최고 등수
        int[] studentHighRank = new int[student];
        Arrays.fill(studentHighRank, student + 1);

        int[] studentRowRank = new int[student];
        Arrays.fill(studentRowRank, 0);

        // 배열을 순회하면서 최저 등수를 구한다
        for (int i = 0; i < testCount; i++) { // 시험 횟수
            for (int rank = 0; rank < student; rank++) { // 학생 등수
                // rank 등수이고 test[i][rank]가 학생이다.
                int curStudent = test[i][rank] - 1; // 0부터 라서
                studentHighRank[curStudent] = Math.min(studentHighRank[curStudent], rank);
                studentRowRank[curStudent] = Math.max(studentRowRank[curStudent], rank);
            }
        }

        // 쌍 구하기
        Set<String> set = new HashSet<>();
        for (int i = 0; i < student; i++) {
            // 현재 학생의 최저 랭크가 학생의 최고 랭크보다 커야한다.
            int cur = studentRowRank[i];
            // 현재 학생은 i 최저 등수는 cur
            for (int j = 0; j < student; j++) {
                // 현재 비교중인 학생은 j 최고 등수는 studentHighRank[j]
                if (cur <= studentHighRank[j]) {
                    // 현재 학생의 최저 등수가 비교학생의 최고 등수보다 작다(상위)
                    set.add(i + "," + j);
                }
            }
        }

        return set.size();
    }

    // n - 학생 수, m - 시험 수
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        // 학생으로 2중포문을 도는 이유
        // 총 학생이 4명일 때, - 학생 1은 학생 (1),2,3,4에 대해서 전부 비교해야한다.
        for (int i = 1; i <= n; i++) { // 비교할 학생 i
            for (int j = 1; j <= n; j++) { // 비교할 학생 j
                int cnt = 0;

                // 그리고 해당 학생들의 시험 점수를 전부 비교해야한다.
                for (int k = 0; k < m; k++) { // 시험 수
                    int pi = 0, pj = 0;

                    // 한 시험에 대한 등수를 기록
                    for (int s = 0; s < n; s++) { // 등수
                        if (arr[k][s] == i) pi = s; // i 학생의 등수를 기록한다.
                        if (arr[k][s] == j) pj = s; // j 학생의 등수를 기록한다.
                    }
                    // i 가 더 높은 등수라면
                    if (pi < pj) cnt++; // ++
                }

                // 모든 시험에서 비교했을 때, cnt의 값이 m과 같다면,
                // i의 랭크가 j의 랭크보다 항상 큰 것이기 때문에
                // i는 j의 멘토가 될 수 있다.
                if (cnt == m) {
                    answer++;
                    //System.out.println(i+" "+j);
                }
            }
        }
        return answer;
    }

    // 3중 for문으로 푸는 방법
    private static int solutionFor3(int n, int m, int[][] intArrArr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < m; k++) {
                    if (intArrArr[i][k] >= intArrArr[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
//
//        // 테스트 수
//        int TEST_COUNT = 3;
//        // 학생 수
//        int N = 4;
//        // 시험 결과
//        int[][] TEST = {
//                {3,4,1,2},
//                {4,3,2,1},
//                {3,1,4,2}
//        };

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.print(T.solution(n, m, arr));
    }
}
