class Solution {
    public String solution(String s) {
        char[] sChar = s.toCharArray();
        
        int idx = 1;
        for (int i=0; i<sChar.length; i++){
            if (sChar[i] == ' ') {
                idx = 1;
                continue;
            }
            
            if (idx % 2 == 0) {
                sChar[i] = Character.toLowerCase(sChar[i]);
            } else {
                sChar[i] = Character.toUpperCase(sChar[i]);
            }
            idx++;
        }
        return new String(sChar);
    }
}