package 프로그래머스.배열.방문길이;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    // 캐릭터를 4가지 방향으로 명령어(UDRL)로 움직인다.
    // 시작 위치는 0,0, 최대 (-5,-5) (5,5)

    // 입력 - dirs(문자열, ULURRDLLU)
    // 출력 - 캐릭터가 처음 걸어본 길의 길이
    // 예외 - 범위를 벗어나는 이동 명령은 무시
    public int solution(String dirs) {
        // Map은 어떻게 미리 설정해놓을까?
        // {"U":(0,1)} 이런식으로..?
        // 자바 9버전부터 가능한 Map.of를 이용한 초기화 -> of란..?
        Map<String, Integer[]> hashMap = Map.of(
                "U", new Integer[]{0, 1},
                "D", new Integer[]{0, -1},
                "R", new Integer[]{1, 0},
                "L", new Integer[]{-1, 0}
        );

        // 이동 거리를 기록하는 set
        Set<String> moveRecord = new HashSet<>();

        int[] current = {0, 0}; // 현재 위치

        for (String dir : dirs.split("")) {
            int[] moveCoordinate = new int[4];
            Integer[] move = hashMap.get(dir);
            int moveX = move[0];
            int moveY = move[1];
            // 예외 - 이동 거리가 보드판을 초과하는 경우
            if (current[0] + moveX <= 5 && current[0] + moveX >= -5 && current[1] + moveY <= 5 && current[1] + moveY >= -5){
                current[0] = current[0] + moveX;
                current[1] = current[1] + moveY;
            }
        }
        System.out.println("SET =>" + moveRecord.toString());
        return moveRecord.size();
    }

    public static void main(String[] args) {
        Main T = new Main();
//        System.out.println(T.solution("ULURRDLLU"));
//        System.out.println(T.solution("LULLLLLLU"));
        System.out.println(T.solution("UDLRDURL")); // 4
    }
}
