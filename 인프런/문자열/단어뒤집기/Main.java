package 인프런.문자열.단어뒤집기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void solution(List<String> words) {
        for(String word : words){
            for(int i = word.length() - 1; i >= 0; i--){
                System.out.print(word.charAt(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = Integer.parseInt(in.next());
        // 입력 자체를 계속 받아야하나?
        // 리스트와 배열의 차이..? 그리고 성능?
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.next());
        }
        T.solution(list);
    }

    // StringBuilder에는 reverse가 있구나...!
    public ArrayList<String> solution2(int n, String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            String tmp= new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static void main2(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        String[] str=new String[n];
        for(int i=0; i<n; i++){
            str[i]=kb.next();
        }
        for(String x : T.solution2(n, str)){
            System.out.println(x);
        }
    }

    public ArrayList<String> solution3(int n, String[] str){
        ArrayList<String> answer=new ArrayList<>();
        // 자리를 바꾸는 방식
        for(String x : str){
            char[] s=x.toCharArray();
            int lt=0, rt=x.length()-1;
            while(lt<rt){
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
            String tmp=String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main3(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String[] str=new String[n];
        for(int i=0; i<n; i++){
            str[i]=kb.next();
        }
        for(String x : T.solution3(n, str)){
            System.out.println(x);
        }
    }
}
