class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            ans.append(strs[i] + " ");
        }

        return ans.toString().trim();
    }
}