import java.util.*;

class Solution {
  public boolean solution(String[] phone_book) {
    // 전화번호를 담을 HashSet
    HashSet<String> set = new HashSet<>();

    Arrays.sort(phone_book);    // 각 전화번호를 하나씩 확인

    // 각 전화번호를 하나씩 확인
    for (String phoneNumber : phone_book) {
      // 현재 번호의 모든 접두어가 이미 set에 존재하는지 확인
      for (int i = 1; i <= phoneNumber.length(); i++) {
        if (set.contains(phoneNumber.substring(0, i))) {
          return false;
        }
      }
      // 현재 번호를 set에 추가
      set.add(phoneNumber);
    }

    return true;
  }
}
