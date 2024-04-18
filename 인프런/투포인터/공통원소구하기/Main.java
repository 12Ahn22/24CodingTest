package 인프런.투포인터.공통원소구하기;

import java.util.*;

public class Main {

    // 두 배열에서 공통 원소를 추출한다.
    // 공통 원소를 오름 차순으로 출력한다.
    public List<Integer> solution(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : a) {
            map.put(i, 1);
        }
        for (int i : b) {
            if (map.containsKey(i)) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            // 둘의 값이 같다면
            if (a[p1] == b[p2]) {
                // 배열에 넣어준다.
                answer.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        in.nextLine();
        int[] arr1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        in.nextLine();
        int[] arr2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> result = T.solution(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
