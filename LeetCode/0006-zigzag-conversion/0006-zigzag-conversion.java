class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        int idx = 0;
        int direction = 1;

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            sb[idx].append(s.charAt(i));
            idx += direction;

            if (idx == 0) {
                direction = 1;
            }

            if (idx == numRows - 1) {
                direction = -1;
            }
        }

        return String.join("", sb);
    }
}