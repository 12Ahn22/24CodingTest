package 인프런.배열.임시반장정하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 다른 학생과 가장 많이 같은 반이 된 적이 있는 학생이 임시 반장이 된다.
    // row는 학생을 나타낸다.
    // 각 컬럼은 학년을 나타낸다. 1~5학년까지 고정이다.

    // 오답이 나는 이유 
    // 1. 같은 반을 여러번 했다고 여러번 카운팅하면 안됩니다.
    // 2. 비교하는 선택된 값이 안바뀜
    public int solution(int N, int[][] input) {

        int[] studentList = new int[N];
        // 즉, 학생 하나를 선택하고, 비교할 학생을 선택한 후 -> 학년을 전부 비교해서 cnt를 해야한다.
        // 학생 하나를 선택한다는 것 => 배열의 한 줄
        for(int student = 0; student < N; student++){ // 학생 순회
            int same = 0;
            for(int other = 0; other < N; other++){ // 여기가 다른 학생이여야하고
                // 여기가 학년이여야한다.
                for(int grade = 0; grade < 5; grade++){
                    // 현재 student의 모든 학년과 other의 모든 학년을 비교하는데,
                    // 같다면, ++를 해주고 break해준다. 왜냐면 학생이 특정 학생과 같은 반이 된 적이 있다는 것
                    // 한 번만 카운트를 해야하기 때문이다.
                    if(input[student][grade] == input[other][grade]){
                        same ++;
                        break;
                    }
                }
            }
            // 한 학생의 순회가 끝났다면, same 값을 저장
            studentList[student] = same;
        }

        int president = 0;
        int max = 0;
        for(int i = 0 ; i < N; i++){
            if(studentList[i] > max){
                max = studentList[i];
                president = i;
            }
        }

        return president + 1;
    }

    // 해결 방법
    public int sol(int N, int[][] input){
        int answer = 0, max = 0;
        for(int student = 0; student < N; student++){
            int cnt = 0;
            for(int other = 0; other < N; other++){
                // 학년 순회
                for(int grade = 0; grade < 5; grade++){
                    if(input[student][grade] == input[other][grade]){
                        cnt++;
                        break;
                    }
                }
            }
            // 최대값 결정
            if(cnt > max){
                max = cnt;
                answer = student;
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = Integer.parseInt(in.nextLine());
        int[][] input = new int[N][5];
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input[i] = arr;
        }
        System.out.println(T.solution(N, input));
    }
}
