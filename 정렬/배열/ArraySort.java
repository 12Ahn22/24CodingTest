package 정렬.배열;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 4, 9, 1, 3};
        
        // Arrays 클래스에서 제공하는 sort 메서드 사용
        Arrays.sort(arr); // 오름차순 정렬
        System.out.println(Arrays.toString(arr));

        // 역순으로 정렬하기
        // Comparator를 쓸면 arr이는 기본형 타입이면 안된다. 따라서 Integer로 변경
        Arrays.sort(arr, Comparator.reverseOrder());

        // Comparator을 직접 구현하기
        // 1. 클래스로 만들기 - 반드시 Comparator를 구현해야한다.
        class ReverseComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 역순 정렬을 위해 o2.compareTo(o1)을 반환합니다.
                return o2.compareTo(o1);
            }
        }
        Arrays.sort(arr, new ReverseComparator());

        // 2. 익명 클래스로 만들어 사용하기 - Comparator를 구현
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // 3. 람다식을 사용하기
        Arrays.sort(arr,(a, b) -> Integer.compare(b, a));
    }
}


