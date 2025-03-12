package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem20006 {
    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player other) {
            return this.nickname.compareTo(other.nickname);
        }
    }

    static class Room {
        int hostLevel;
        List<Player> players;
        int capacity;

        public Room(Player host, int capacity) {
            this.hostLevel = host.level;
            this.players = new ArrayList<>();
            this.players.add(host);
            this.capacity = capacity;
        }

        public boolean canJoin(Player player) {
            return players.size() < capacity && Math.abs(hostLevel - player.level) <= 10;
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public boolean isFull() {
            return players.size() == capacity;
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Player player = new Player(level, nickname);
            boolean joined = false;

            for (Room room : rooms) {
                if (room.canJoin(player)) {
                    room.addPlayer(player);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                rooms.add(new Room(player, m));
            }
        }

        for (Room room : rooms) {
            if (room.isFull()) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            Collections.sort(room.players);
            
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }
}
