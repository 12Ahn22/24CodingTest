package 인프런.투포인터.두배열합치기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 오름 차순으로 정렬이 된 두 배열이 주어지면, 두 배열을 오름차순으로 합친
    // 하나의 배열로 출력하는 프로그램을 작성하시오
    public int[] solution(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        int[] answer = new int[arr1Len + arr2Len];

        // answer가 꽉 찰떄 까지 순회해야함
        // 순회하면서 arr1과 arr2 의 현재 idx의 값을 비교
        // - 더 작은 값을 먼저 answer에 넣기
        // - 넣은 쪽의 idx를 증가시킴
        int arr1Idx = 0;
        int arr2Idx = 0;
        int remainIdx = 0;

        for (int i = 0; i < answer.length; i++) {
            if (arr1Idx == arr1Len || arr2Idx == arr2Len) {
                remainIdx = i;
                break;
            }

            if (arr1[arr1Idx] <= arr2[arr2Idx]) {
                answer[i] = arr1[arr1Idx++];
            } else answer[i] = arr2[arr2Idx++];
        }

        // 남아있는 요소를 배열에 넣기
        if (arr1Idx < arr1Len) {
            for (int i = arr1Idx; i < arr1Len; i++) {
                answer[remainIdx++] = arr1[i];
            }
        }

        if (arr2Idx < arr2Len) {
            for (int i = arr2Idx; i < arr2Len; i++) {
                answer[remainIdx++] = arr2[i];
            }
        }

        return answer;
    }

    // while문을 사용한 풀이 방법
    public ArrayList<Integer> solution2(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        // 한쪽 배열이 끝날때 까지 전부 넣어주기
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        // 남은 배열값을 전부 넣어주기
        while (p1 < a.length) answer.add(a[p1++]);
        while (p2 < b.length) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        in.nextLine();
        int[] arr1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        in.nextLine();
        int[] arr2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = T.solution(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
