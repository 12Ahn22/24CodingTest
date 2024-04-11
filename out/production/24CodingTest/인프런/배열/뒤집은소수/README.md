## 해당 숫자가 소수인지 판별하는 공식
> `O(N)`의 시간이 걸린다.
```java
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
```