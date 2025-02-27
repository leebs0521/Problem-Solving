class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        String candidate = "";
        for (int i = 0; i < strs[0].length(); i++) {
            candidate += strs[0].charAt(i);
            boolean possible = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(candidate)) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                ans = candidate;
        }

        return ans;
    }
}