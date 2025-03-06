class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            n = getNextNumber(n);
        }

        return true;
    }

    private int getNextNumber(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n /= 10;
        }

        return sum;
    }
}