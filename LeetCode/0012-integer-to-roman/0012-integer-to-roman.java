class Solution {
    public String intToRoman(int num) {
        int iArr[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String sArr[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder ans = new StringBuilder();

        int idx = 0;
        while (num > 0) {
            if (num >= iArr[idx]) {
                ans.append(sArr[idx]);
                num -= iArr[idx];
            } else {
                idx++;
            }
        }

        return ans.toString();
    }
}