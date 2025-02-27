class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int idx = 0;
        int direction = 1; 

        for (char c : s.toCharArray()) {
            rows[idx].append(c);

            if (idx == 0) {
                direction = 1; 
            } else if (idx == numRows - 1) {
                direction = -1;
            }

            idx += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
