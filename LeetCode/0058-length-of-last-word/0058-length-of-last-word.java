class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.trim().split(" ");

        return strs[strs.length - 1].length();
    }
}