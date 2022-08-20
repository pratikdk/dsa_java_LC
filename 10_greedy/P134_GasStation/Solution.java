class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int v: gas) gasSum += v;
        for (int v: cost) costSum += v;
        if (gasSum < costSum) return -1;
        
        int total = 0;
        int resIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            
            if (total < 0) {
                resIndex = i + 1;
                total = 0;
            }
        }
        
        return resIndex;
    }
}
