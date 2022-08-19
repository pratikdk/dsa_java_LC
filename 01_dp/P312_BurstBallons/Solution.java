class Solution {
    // Recursive
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = nums.length;
        nums[0] = nums[n-1] = 1;
        for (int i = 0; i < iNums.length; i++) nums[i+1] = iNums[i];
        int[][] memo = new int[n][n];
        return recurseLR(nums, memo, 0, n-1);
    }
    
    public int recurseLR(int[] nums, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, nums[left] * nums[i] * nums[right] +
                          recurseLR(nums, memo, left, i) + recurseLR(nums, memo, i, right));
        }
        memo[left][right] = res;
        return res;   
    }
    
    
    // DP
    public int maxCoins2(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = nums.length;
        nums[0] = nums[n-1] = 1;
        for (int i = 0; i < iNums.length; i++) nums[i+1] = iNums[i];
        
        int[][] dp = new int[n][n];
        
        for (int k = 2; k < n; k++) { // k is span, span can be interpreted as k+1, small -> big spans dp
            for (int left = 0; left < n - k; left++) { // left
                int right = left + k; // right
                for (int i = left+1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right]
                                              + dp[left][i] + dp[i][right]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
