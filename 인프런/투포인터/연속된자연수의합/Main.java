package 인프런.투포인터.연속된자연수의합;

import java.util.Scanner;

public class Main {
    public int solution(int N) {
        // N이 입력되면, 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가지수를 구하시오.
        // 1 2 3 4 5 6 7 8 9 10 - N을 2로 나눈 수와 그 다음 수를 더하면 자신을 초과함
        // 그러니까 최대 N/2 + 1 까지만 구하면 됨
        int sum = 1, lt = 1, answer = 0; // 2개 이상이여야한다.
        for (int rt = 2; rt <= N / 2 + 1; rt++) { // 그래서 rt를 2부터 시작
            sum += rt;
            while (sum > N && lt < rt) {
                sum -= lt;
                lt++;
            }
            if (sum == N) answer++;
        }
        return answer;
    }

    // 수학을 사용하는 코드
    // 솔직히 아예 처음부터 생각하라면 못할 것 같다..
    // 15가 있을 때,
    // 여기서 2개 1 , 2를 꺼낸다. 그러면 3이 꺼내지니까 15 -> 12가된다.
    // 12를 2로 나눈다. => 몫이 6.
    // 1, 2에 각각 6을 준다. = 7 8 => 따라서 7+8 = 15 참

    // 이제 3개를 꺼낸다. 1 2 3 / 15 - (1+2+3) = 9
    // 9/3 = 3 -> (1+3) (2+3) (3+3) => 4 5 6 = 15 참

    // ... 이렇게 반복하면 개수를 구할 수 있다.
    public int solution2(int n) {
        int answer = 0, cnt = 1;
        n--; // 1개 이상을 해야해서 cnt에 1은 미리 뽑은 상태! 그래서 --해준거다.
        while (n > 0) { // n > 0라는 건 다 뽑았다는 의미
            cnt++; // cnt++의 의미는 뽑았다는 의미
            n = n - cnt; // 뽑은 수를 빼야함
            if (n % cnt == 0) answer++; // 나누어 떨어져야한다. 그래야 분배를 해주니까..
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = in.nextInt();

        System.out.println(T.solution(N));
    }
}
