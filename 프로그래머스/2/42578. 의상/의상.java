import java.util.*;

class Solution {
  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();

    // 의상 종류별로 의상의 개수를 센다
    for (String[] cloth : clothes) {
      String category = cloth[1]; // 의상의 종류
      map.put(category, map.getOrDefault(category, 0) + 1);
    }

    int result = 1;

    // 각 의상 종류에 대해 (종류의 의상 개수 + 1)을 곱함
    for (int count : map.values()) {
      result *= (count + 1); // 입지 않는 경우도 포함되므로 +1
    }

    return result - 1; // 최소 한 개의 의상은 입어야 하므로 -1
  }
}