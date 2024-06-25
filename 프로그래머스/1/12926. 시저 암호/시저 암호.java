class Solution {
    public String solution(String s, int n) {

        char[] nChar = s.toCharArray();

        for (int i = 0; i < nChar.length; i++) {

            if (Character.isUpperCase(nChar[i])) {
                int idx = nChar[i] - 'A';
                idx = (idx + n) % 26;
                nChar[i] = (char) ('A' + idx);
            } else if (Character.isLowerCase(nChar[i])){
                int idx = nChar[i] - 'a';
                idx = (idx + n) % 26;
                nChar[i] = (char) ('a' + idx);
            }
        }
        return new String(nChar);
    }
}