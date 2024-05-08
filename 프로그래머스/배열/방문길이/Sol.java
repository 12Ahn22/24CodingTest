package 프로그래머스.배열.방문길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sol {
    // 좌표가 범위를 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        // 배열을 사용하기 위해서 -5 ~ 5까지지만 -> 0 ~ 10까지로 표현한다.
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 이동 좌표를 결정하는 해시맵
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }

    // 아니 근데 나도 이렇게 햇는데..? 무슨 차이일까 ㅠ?
    public static int solution(String dirs) {
        initLocation();
        int x = 5, y = 5; // 5,5는 0,0을 의미한다. 배열 idx로 음수를 쓸 수 없기 때문
        Set<String> answer = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            // 이런 더하고 빼는 값들을 offset이라고 한다.
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // 좌표를 벗어나지않은 경우에만 처리
            if (isValidMove(nx, ny)) {
                // 좌표는 A->B나 B<-A나 같아야하기때문에 한번에 두개씩 추가한다.
                answer.add(x + "" + y + "" + nx + "" + ny);
                answer.add(nx + "" + ny + "" + x + "" + y);

                // 좌표를 이동했기때문에 좌표 이동
                x = nx;
                y = ny;
            }
        }
        return answer.size() / 2;
    }

    public static void main(String[] args) {
//        System.out.println(T.solution("ULURRDLLU"));
//        System.out.println(T.solution("LULLLLLLU"));
        System.out.println(solution("UDLRDURL")); // 4
    }
}
