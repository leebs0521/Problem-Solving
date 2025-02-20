import java.util.*;

class Solution {
  public int solution(int[] nums) {

    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i] + 1, 1));
    }
    
    if(map.size() < nums.length / 2) {
      answer = map.size();
    } else {
      answer = nums.length / 2;
    }
     
      return answer;
  }
}