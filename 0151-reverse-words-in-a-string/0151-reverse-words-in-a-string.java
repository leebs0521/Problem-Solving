class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        int len = strs.length;

        StringBuilder ans = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            ans.append(strs[i] + " ");
        }

        return ans.toString().strip();
    }
}