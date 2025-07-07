import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();

        for(String cmd : record){
            String[] token = cmd.split(" ");
            if(!token[0].equals("Leave")) {
                nameMap.put(token[1], token[2]);
            }
        }

        List<String> answer = new ArrayList<>();

        for(String cmd : record) {
            String[] token = cmd.split(" ");
            if(token[0].equals("Enter")) {
                answer.add(nameMap.get(token[1]) + "님이 들어왔습니다.");
            } else if(token[0].equals("Leave")) {
                answer.add(nameMap.get(token[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}