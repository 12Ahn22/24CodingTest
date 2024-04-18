package 정렬.배열;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 4, 9, 1, 3));
        
        // Collections.sort() 사용하기
        Collections.sort(list);

        // 내림 차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list, (a, b) -> Integer.compare(b, a));

        // List.sort() - 자바 버전 8이후
        list.sort(Comparator.naturalOrder()); // 오름차순
        list.sort(Comparator.reverseOrder()); // 내림차순
    }
}
