package 인프런.문자열.특정문자뒤집기;

import java.util.Scanner;

public class Main {
    public String solution(String str) {
        // 문자열 순회
        char[] charArr = str.toCharArray();
        // 위치를 가리키는 포인터 2개
        int front = 0, end = str.length() - 1;
        char temp;
        // 문자열이면 이동 -> 자리 바꾸기
        while (front < end){
            // 앞에가 문자열이면,
            if(Character.isAlphabetic(charArr[front])){
                // 뒤에 위치 검사
                if(Character.isAlphabetic(charArr[end])){
                    // 둘이 자리 바꾸기
                    temp = charArr[front];
                    charArr[front] = charArr[end];
                    charArr[end] = temp;
                    front++;
                }
                end--;
            }else front++;
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        String str = in.next(); // 문자열 받기
        System.out.println(T.solution(str));
    }

    public String solution2(String str){
        String answer;
        char[] s=str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
        }
        answer=String.valueOf(s);
        return answer;
    }

    public static void main2(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.println(T.solution2(str));
    }
}
