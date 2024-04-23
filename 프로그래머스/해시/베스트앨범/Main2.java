package 프로그래머스.해시.베스트앨범;

import java.util.*;

public class Main2 {
//  좀 더 예쁘게 개선해보기
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별로, 곡을 정렬하기
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            List<Song> list = new ArrayList<>();
            Song song = new Song(i, play, genre);

            // 현재 map에 장르가 없다면 추가
            if (!songMap.containsKey(genre)) {
                list.add(song);
                songMap.put(genre, list);
            } else {
                list = songMap.get(genre);
                list.add(song);
            }

            Collections.sort(list); // Comparable을 구현했기 때문에, sort 가능
        }

        // 가장 인기가 있는 장르를 찾기 위해서, 장르 별로 plays 횟수를 더한다.
        // 그리고 정렬을 통해 가장 인기있는 장르 순서대로 list를 만든다.
        List<Genre> highPlayGenres = new ArrayList<>(); // 가장 먼저 앨범에 넣어야하는 장르 리스트

        for (var genre : songMap.entrySet()) {
            String key = genre.getKey();
            List<Song> list = genre.getValue();

            Genre curGenre = new Genre(key,list.stream().mapToInt(v -> v.play).sum() );
            highPlayGenres.add(curGenre);
        }
        Collections.sort(highPlayGenres);

        // 이제 해당 장르 순서대로 2개씩 뽑는다. 2개가 없다면 1개만 뽑는다
        List<Song> answer = new ArrayList<>();

        for (var highPlayGenre : highPlayGenres) {
            String genre = highPlayGenre.genre;
            List<Song> genreSongs = songMap.get(genre);

            if(genreSongs.size() == 1){
                answer.addAll(genreSongs);
            } else answer.addAll(genreSongs.subList(0, 2));
        }
        return answer.stream().mapToInt(v->v.id).toArray();
    }

    class Song implements Comparable<Song> {
        public int id;
        public int play;
        public String genre;

        public Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
        @Override
        public int compareTo(Song song) {
            // isBiggerThan 보다 비교를 위한 메서드를 implements 통해 구현하기
            if (play == song.play) return 0;
            // 내림차순 정렬
            return song.play - play;
        }
    }

    class Genre implements Comparable<Genre>{
        public String genre;
        public int plays;

        @Override
        public int compareTo(Genre other) {
            return Integer.compare(other.plays, plays);
        }

        public Genre(String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main2 T = new Main2();
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
