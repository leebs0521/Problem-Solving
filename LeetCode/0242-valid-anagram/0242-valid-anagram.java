class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            map.put(sch, map.getOrDefault(sch, 0) + 1);
            map.put(tch, map.getOrDefault(tch, 0) - 1);
        }

        for (int cnt : map.values()) {
            if (cnt != 0)
                return false;
        }

        return true;
    }
}