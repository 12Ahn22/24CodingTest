package 인프런.투포인터.최대길이연속부분수열;

import java.util.*;

public class Main {
    public int solution(int k, int[] input) {
        // 최대 k 번, 0을 1로 변경 가능하다.
        // 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

        // 0을 발견한 idx를 저장하는 큐
        Queue<Integer> queue = new LinkedList<>();
        // 나는 lt를 queue로 사용했지만 수업 코드는 lt로 사용한 것

        int answer = 0, cnt = 0;

        // 전체 수열을 순회
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) cnt++;
            else {
                // k가 남아있을 때,
                if (k != 0) {
                    k--;
                    cnt++;
                } else {
                    int idx = queue.remove();
                    // 정답과 지금까지 세던 값중 큰 값을 저장
                    answer = Math.max(answer, cnt);
                    // 세던 값을 0이 나온 부분부터 ~ 지금 idx까지의 길이로 바꿔야한다.
                    cnt = i - idx;
                }
                queue.add(i);
            }
        }
        return answer;
    }

    // 투포인터로 푸는 방법
    public int solution2(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0; // cnt는 k의 개수

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++; // 0을 만나면 ++
            
            // 만약 k로 대체할 0의 개수를 초과해버렸다면,
            while (cnt > k) {
                // lt가 0이라면 cnt--; 왜냐면 빌려준 1을 돌려받았으니까.
                if (arr[lt] == 0) cnt--;
                // 왼쪽을 앞으로 이동
                lt++;
            }

            // 큰 값을 저장
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = in.nextInt();
        int K = in.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextInt();
        }
        System.out.println(T.solution(K, input));
    }
}
