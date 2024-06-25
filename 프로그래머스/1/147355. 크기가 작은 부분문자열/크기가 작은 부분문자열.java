class Solution {
    public int solution(String t, String p) {
        long compareNum = Long.parseLong(p);
        int answer = 0;

        for (int i = 0; i < t.length(); i++) {
            int endIdx = i + p.length();
            if (endIdx >= t.length() + 1)
                break;

            long temp = Long.parseLong(t.substring(i, endIdx));
            
            if (temp <= compareNum)
                answer++;
        }

        return answer;
    }
}