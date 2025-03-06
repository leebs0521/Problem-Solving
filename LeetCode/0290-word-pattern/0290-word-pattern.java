class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] strs = s.split(" ");

        if (pattern.length() != strs.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = strs[i];

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(str))
                    return false;
            } else if (map.containsValue(str)) {
                return false;
            }

            map.put(ch, str);
        }

        return true;
    }
}