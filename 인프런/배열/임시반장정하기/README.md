```java
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
```
## 오답노트
- 첫 풀이가 틀린 이유는 3중 for문의 순서가 틀렸기 때문이다.
- 그래도 풀이 접근 방식은 맞았다.