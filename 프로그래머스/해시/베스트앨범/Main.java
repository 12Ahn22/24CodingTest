package 프로그래머스.해시.베스트앨범;

import java.util.*;

public class Main {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별로 가장 많이 재생된 노래를 2개씩 모아 앨범 출시
        // 2개씩 모아서 뽑는거. 2개만 뽑는게 아니다.
        // 그리고 2개는 장르가 같은걸 뽑는거임. 장르별로 두개만 뽑음.
        // 1. 장르 중 가장 많이 수록된 걸 뽑음
        // 입력 - 노래 장르 배열 genres, 노래별 재생 횟수 배열 palys,
        // 그러니까 배열의 i가 해당 노래의 고유번호

        Map<String, List<Song>> map = new HashMap<>();

        // map에 장르 별로 가장 큰 두개의 값만 저장하기
        for (int i = 0; i < genres.length; i++) {
            // 2개만 뽑으면 되니까
            // 장르가 같다면, 큰 걸 넣기
            String genre = genres[i];
            int play = plays[i];

            List<Song> list = new ArrayList<>();
            Song song = new Song(i, play, genre);

            // 현재 map에 장르가 없다면 추가
            if (!map.containsKey(genre)) {
                list.add(song);
                map.put(genre, list);
            } else {
                list = map.get(genre);
                list.add(song);
            }
            // list 정렬
            list.sort((a, b) -> {
                if (a.play == b.play) return 0;
                if (a.isBiggerThan(b)) return -1;
                return 1;
            });
        }

        // 장르별로 play 값을 전부 더한다. 그리고 그게 가장 큰 장르 순서대로 정렬한다.
        List<Map<String, Object>> highPlayGenres = new ArrayList<>(); // 가장 먼저 앨범에 넣어야하는 장르 리스트
        for (var genre : map.entrySet()) {
            Map<String, Object> highPlayGenre = new HashMap<>();
            String key = genre.getKey();
            List<Song> list = genre.getValue();
            highPlayGenre.put("plays", list.stream().mapToInt(v -> v.play).sum());
            highPlayGenre.put("genre", key);
            highPlayGenres.add(highPlayGenre);
        }

        highPlayGenres.sort((a, b) -> {
            Integer aPlays = (Integer) a.get("plays");
            Integer bPlays = (Integer) b.get("plays");
            return Integer.compare(bPlays, aPlays);
        });

        // 이제 해당 장르 순서대로 2개씩 뽑는다. 2개가 없다면 1개만 뽑는다
        List<Song> answer = new ArrayList<>();
        for (var highPlayGenre : highPlayGenres) {
            String genre = (String)highPlayGenre.get("genre");
            List<Song> genreSongs = map.get(genre);
            if(genreSongs.size() == 1){
                answer.addAll(genreSongs);
            } else answer.addAll(genreSongs.subList(0, 2));
        }
        return answer.stream().mapToInt(v->v.id).toArray();
    }

    class Song {
        public int id;
        public int play;

        public String genre;

        public Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        public boolean isBiggerThan(Song song) {
            return this.play > song.play;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "id=" + id +
                    ", play=" + play +
                    ", genre=" + genre +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
//        String[] gen = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};

//        String[] gen = {"pop", "pop", "pop", "rap", "rap"};
//        int[] plays = {45, 50, 40, 60, 70};

//        ["pop", "pop", "pop"], [1,1,1]

//        String[] gen = {"pop", "pop", "pop"};
//        int[] plays = {1,1,1};

//      ["classic", "classic", "classic", "classic", "classic"], [500, 600, 150, 800, 2500]
//      기댓값 〉 [4, 3]
//        String[] gen = {"classic", "classic", "classic", "classic", "classic"};
//        int[] plays = {500, 600, 150, 800, 2500};

        String[] gen = {"classic", "pop", "pop"};
        int[] plays = {500, 600, 150};

        int[] answer = T.solution(gen, plays);
        for(var test:answer) System.out.println(test);
    }
}
