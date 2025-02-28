class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (set.contains(ch)) {
                while (true) {
                    char cur = s.charAt(left++);
                    set.remove(cur);
                    if (cur == ch)
                        break;
                }
            }
            set.add(ch);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}