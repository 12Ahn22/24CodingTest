package 인프런.해시.K번째큰수;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 출력 값 - 3장을 뽑아서 합친 수 들 중에서 K 번째로 큰 수
    // N장을 3장뽑는다 - 연속된 값이 아니다.
    // 트린 이유 - 로직은 맞았는데, 중복된 경우때문이였다..
    public Integer solution(int n, int k, int[] input) {
        Set<Integer> set = new HashSet<>();
        if (k > n) return -1;
        for (int i = 0; i < n; i++) {
            int sum = input[i];
            for (int j = i + 1; j < n; j++) {
                sum += input[j];
                for (int s = j + 1; s < n; s++) {
                    sum += input[s];
                    set.add(sum);
                    sum -= input[s];
                }
                sum -= input[j];
            }
        }
        List<Integer> answer = new ArrayList<>(set.stream().collect(Collectors.toList()));
        answer.sort(Comparator.reverseOrder());
        return answer.get(k - 1);
    }

    public int solution2(int[] arr, int n, int k) {
        int answer = -1;
        // Set인데 정렬이 되어있어야한다. -> TreeSet이라는 게 있다.
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        //Tset.remove(143);
        //System.out.println(Tset.size());
        //System.out.println("first : "+ Tset.first());
        //System.out.println("last : "+ Tset.last());

        for (int x : Tset) {
            //System.out.println(x);
            cnt++;
            if (cnt == k) return x;
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

        System.out.println(T.solution(N, K, input));
    }
}
