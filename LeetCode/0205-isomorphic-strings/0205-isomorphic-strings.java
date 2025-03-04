class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if (charMap.containsKey(sch)) {
                if (charMap.get(sch) != tch) {
                    return false;
                }
            } else if (charMap.containsValue(tch)) {
                return false;
            }

            charMap.put(sch, tch);
        }

        return true;        
    }
}