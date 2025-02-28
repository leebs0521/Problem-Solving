class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIdx = 0;
        int curGas = 0;
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < cost.length; i++) {
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                startIdx = i + 1;
                curGas = 0;
            }

            totalGas += gas[i];
            totalCost += cost[i];
        }

        return (totalGas >= totalCost) ? startIdx : -1;
    }
}