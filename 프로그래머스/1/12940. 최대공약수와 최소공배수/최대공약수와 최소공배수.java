class Solution {
    public int[] solution(int n, int m) {

        int gcd = gcd(Math.max(n, m), Math.min(n, m));
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}