package Programmers.Hash;

public class 42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            
            ArrayList<int[]> songs = genreSongs.getOrDefault(genres[i], new ArrayList<>());
            songs.add(new int[]{i, plays[i]});
            genreSongs.put(genres[i], songs);
        }
        
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        Collections.sort(sortedGenres, (a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            ArrayList<int[]> songs = genreSongs.get(genre);
            
            Collections.sort(songs, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            answer.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                answer.add(songs.get(1)[0]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
