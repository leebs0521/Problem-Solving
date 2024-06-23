import java.util.Arrays;

class Solution {
        public int solution(int[] nums) {

            boolean[] isPrime =  new boolean[50001];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;

            for (int i=2; i<5001; i++){
                int idx = 2;
                if (isPrime[i]) {
                    while (i * idx <= 5001) {
                        isPrime[i*idx] = false;
                        idx++;
                    }
                }
            }

            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                for (int j=i+1; j<nums.length; j++) {
                    for (int k=j+1; k<nums.length; k++) {
                        int adds = nums[i] + nums[j] + nums[k]; 
                        if (isPrime[adds]) {
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }