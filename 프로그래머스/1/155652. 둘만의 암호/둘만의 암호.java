class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            int cnt = 0;
            char nextCh = s.charAt(i);
            while (cnt != index) {
                nextCh = charShift(nextCh);
                if (skip.indexOf(nextCh) == -1) {
                    cnt++;
                }
            }
            sb.append(nextCh);

        }
        return sb.toString();
    }

    private static char charShift(char ch) {
        int idx = (int)ch - 'a';
        idx = (idx+1) % 26;
        return (char) ('a' + idx);
    }
}