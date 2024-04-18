package 인프런.슬라이드윈도우.최대매출;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    // 입력
    //  - 전체 매출일 N일 
    //  - 연속된 K일
    //  - 날짜별 매출 정보를 가진 배열
    public int solution(int N, int K, int[] sales) {
        // 연속된 K일 동안의 최대 매출액 구하기
        int max = Integer.MIN_VALUE;

        // 전체를 순회
        // 순회하면서 연속된 최대 일수를 다시 순회 하면서 최대값 구하기
        int idx = 0;
        // O(N^2)라서 지금 계속 타임아웃이 난다..흠..
        while (idx < N - K) {
            int sum = 0;
            // 다 더할필요가 있나? 처음만 더한 후에 맨앞을 빼고 맨뒤를 더하면된다!
            for (int i = idx; i < idx + K; i++) {
                sum += sales[i];
            }
            max = Math.max(sum, max);
            idx++;
        }
        return max;
    }

    public int solution2(int N, int K, int[] sales) {
        // 0~K까지 더한 값을 max로 설정하기
        int[] splitSales = Arrays.copyOfRange(sales, 0, K);
        int sum = Arrays.stream(splitSales).sum();
        int max = sum;

        int startIdx = 0;
        int endIdx = K;
        while (endIdx < N - K) {
            // 맨 앞 요소를 빼고,
            // 다음 IDX 요소를 더한다.
            sum += sales[endIdx++] - sales[startIdx++];
            max = Math.max(sum, max);
        }
        return max;
    }

    public int solution3(int n, int k, int[] arr) {
        int answer, sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

//        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        List<Integer> input =
//                Arrays.stream(in.nextLine().split(" "))
//                        .mapToInt(Integer::parseInt).boxed()
//                        .collect(Collectors.toList());
//                        //.toList();
//        System.out.println(T.solution(nums[0], nums[1], input));

        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(T.solution2(nums[0], nums[1], input));
    }
}
