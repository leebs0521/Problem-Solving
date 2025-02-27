class Solution {
    public int lengthOfLastWord(String s) {
        String[] sArr = s.split(" ");
        int len = sArr.length;
        return sArr[len - 1].length();
    }
}