```java
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0;
		while(p1<n && p2<m){
			if(a[p1]<b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		return answer;
	}
```
## 배운점
문제를 풀 때, idx 때문에 코드가 매우 길어졌는데, ArrayList를 사용하면 간단하게 add를 사용하면 된다는 것을 알게되었다.

내가 푼 코드는 정답 배열에 남아있는 배열을 넣기 위해서는 현재 정답 배열의 idx가 어디를 가리키는 지 따로 배열로 저장을 해야했지만, ArrayList를 사용하면 그냥 `add`만 해주면 된다!

