package 인프런.배열.에라토스테네스체;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// N log N
public class getPrimes {
    public static List<Integer> getPrimes(int n){
        boolean [] prime = new boolean[n + 1]; // 계산의 편리함을 위해 + 1
        Arrays.fill(prime, true); // 전부 참으로 초기화

        // 소수는 2부터 시작
        // 자신의 제곱근 전 까지 숫자로만 계산하면 된다. 그 뒤로는 짝이 맞아서 할 필요가 없다.
        for(int p = 2; p <= Math.sqrt(n); p++){ // O(log N)
            if(prime[p]){ // 소수인지 판별하기
                // i가 p*p부터 시작하는 이유
                // - 이미 이전 반복문 때 계산이 되었기 때문에, 중복 계산과 최적화를 위해서
                // - 자기 자신은 제외하기 위해서
                for(int i = p * p; i <= n; i = i + p){ // O(N)
                    prime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(prime[i]) primes.add(i);
        }

        return primes;
    }
    public static void main(String[] args) {
        List<Integer> list = getPrimes(100);
        for (Integer i : list){
            System.out.print(i +" ");
        }
    }
}
