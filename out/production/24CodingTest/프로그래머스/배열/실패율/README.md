> 풀이는 맞았음!
> 
> 다만, 강의 코드를 보면 총 해당 스테이지에 도달한 사람 수를 구하는 방법이
> 내가 한 방법보다 더 효율적이였다.

## 각 스테이지에 도달한 총 사람의 수를 구하는 방법
- 나는 다시 stages를 for문을 돌면서 Map을 사용해 계산했다. = O(N)
```java
Map<Integer, Integer> allChallenger = new HashMap<>();
for (int i : stages) { // Stages 입력값 만큼 O(N)
    for (int j = 1; j <= i; j++) {
        // 스테이지 i값까지 + 1 해줘야한다.
        allChallenger //
                .put(j, allChallenger.getOrDefault(j, 0) + 1);
    }
}
```


- 그러나, stage의 개수 만큼만 반복을 해서도 해당 값을 구할 수 있다.
```java
double total = stages.length;

// 각 스테이지를 순회하며 실패율 계산
for(int i = 1; i <= N; i++){
    if(challenger[i] == 0){
        // 도전자가 없는 경우 = 실패율은 0
        fails.put(i, 0.);
    }else{
        // ex.
        // 1 스테이지에 도달한 사용자 = 총 스테이지 도달자 개수
        // 2 스테이지에 도달한 사용자 = 총 스테이지 도달자 개수 - 1스테이지 도달자
        // 3 스테이지에 도달한 사용자 = 총 스테이지 도달자 - 1,2번째 스테이지에 있는 사용자
        // ...
        fails.put(i, challenger[i] / total); // 실패율을 구한 후에
        total -= challenger[i]; // 1 스테이지 도달자를 빼면 -> total은 2스테이지 도달자 명수가 된다.
    }
}
```
스테이지 2에 있는 사람은 반드시 스테이지 1을 클리어한 사람이다.

따라서 2 스테이지에 있는 도달자의 총 명수는 전체 인원 - 1 스테이지 도달자이다.

![image](https://github.com/12Ahn22/24CodingTest/assets/44540726/f971da7b-128f-4d43-96a6-270511a9bdbb)

## 실수의 비교
실수의 같다 비교는 `==`로 할 수 없다. -> 앱실론

따라서 자바에서 제공하는 API를 활용하자.
```java
Double.compare(a, b);
Float.compare(a, b);
```