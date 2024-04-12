package 인프런.배열.등수구하기;

import java.util.*;

public class Main {

    /**
     * 시간복잡도: O(N^2)
     */
    public int[] solution(int N, int[] input) {
        // 입력된 배열 점수에 맞게 등수를 매기기
        // 같은 점수인 경우 높은 등급으로 동일 처리
        int[] answer = new int[N];
        Arrays.fill(answer, 1);

        // 이중 for문으로 간단하게 푸는 방법
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(input[i] < input[j]){
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    /**
     * 시간복잡도: O(N log N)
     */
    public int[] solution2(int N, Integer[] input) {
        Integer[] sortedInput = input.clone();
        Arrays.sort(sortedInput, Collections.reverseOrder()); // 입력 배열을 정렬 (N log N)

        // 정렬된 순서에 맞게 등수를 설정
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for(int i = 0; i< N; i++){
            // 정렬된 순서대로, 값을 rankMap에 넣기
            if(!rankMap.containsKey(sortedInput[i])){
                rankMap.put(sortedInput[i], rank);
            }
            rank++;
        }

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = rankMap.get(input[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int N = Integer.parseInt(in.nextLine());
        Integer[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        int[] result = T.solution2(N, input);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
