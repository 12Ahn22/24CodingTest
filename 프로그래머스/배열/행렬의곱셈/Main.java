package 프로그래머스.배열.행렬의곱셈;

public class Main {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1에 arr2를 곱한 결과를 반환하기
        // 행렬 곱은 가로 곱하기 세로
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        // 곱셈 행렬의 크기는 arr1의 행 개수 x arr2의 열 개수
        int [][] answer = new int[r1][c2];

        // [1,4] [3,3] = [15,15]
        // [3,2] [3,3]   [15,15]
        // [4,1]         [15,15]
        // 정답으로 채워야하는 배열을 순회
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                // 두 행렬의 데이터를 곱하기
                for(int k = 0; k < c1; k++){
                    // 덧셈 공식을 보면
                    // arr1은 행값이 고정
                    // arr2는 열값이 고정이고 다른 값은 0~끝까지다.
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 4}, {3, 2}, {4, 1}};
        int[][] b = {{3, 3}, {3, 3}};
    }
}
