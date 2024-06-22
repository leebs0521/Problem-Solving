class Solution {
    public boolean solution(int x) {
        String nStr = Integer.toString(x);
        int sum = 0;
        for (int i=0; i<nStr.length(); i++) {
            sum += Character.getNumericValue(nStr.charAt(i));
        }
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}