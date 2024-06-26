import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> playerList = new ArrayList<>(Arrays.asList(players));

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String call : callings) {
            int idx = map.get(call);

            String frontPlayer = players[idx - 1];

            map.replace(frontPlayer, idx);
            players[idx] = frontPlayer;
            
            map.replace(call, idx-1);
            players[idx-1] = call;
        }

        return players;
    }
}