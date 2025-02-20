import java.util.*;

class Solution {
  public String solution(String[] participant, String[] completion) {
    
    Map<String, Integer> map = new HashMap<>();
    String answer = "";

    for (String part : participant) {
      map.put(part, map.getOrDefault(part, 0) + 1);
    }

    for(String comp : completion) {
      map.put(comp, map.getOrDefault(comp, 0) - 1);
    }

    for(String key : map.keySet()) {
      if(map.get(key) != 0 ) {
        answer = key;
      }
    }

    return answer;
  }
}