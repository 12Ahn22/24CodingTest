package 프로그래머스.해시.베스트앨범;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    /**
     * 다른 사람이 푼 코드 - stream을 사용한 게 인상 깊어서 읽어보기로함
     */
    public class Music implements Comparable<Music>{

        private int played;
        private int id;
        private String genre;

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() {return genre;}
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. IntStream을 만든다. 범위는 0 부터 genres.length까지. 왜냐면 idx가 노래의 id라서
        // 2. i 값을 사용해 Music 객체를 가진 스트림을 만든다.
        // 3. 최종 처리 메서드 collect를 사용해서 새로운 컬렉션을 만든다. Map<String,List<Music>>
        // 4. 만들어진 Map의 entrySet으로 다시 stream을 진행한다.
        // 5. 모든 plays를 합한 값으로 오름차순으로 정렬한다.
        // 6. 각 Map에 있는 값들을 정렬하고, 거기서 2개만 뽑아낸다. 그걸 flatMap처리함
        // 7. Music 요소에서 id값만 뽑아내 배열로만듬
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                // collect는 최종 처리 메서드(새로운 컬렉션을 만든다)
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x->x.getValue().stream().sorted().limit(2))
                .mapToInt(x->x.id).toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer+=music.played;
        }
        return answer;
    }
}