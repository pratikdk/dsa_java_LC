class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, 0, target);
    }
    
    private int backtrack(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }
        
        int res = 0;
        res += backtrack(nums, i+1, sum+nums[i], target);
        res += backtrack(nums, i+1, sum-nums[i], target);
        
        return res;
    }
    
// // Exceeds time limit    
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<int[], Integer> dp = new HashMap<>();
//         return backtrack(nums, 0, 0, target, dp);
//     }
    
//     private int backtrack(int[] nums, int i, int sum, int target, Map<int[], Integer> dp) {
//         if (i == nums.length) {
//             if (sum == target) return 1;
//             else return 0;
//         }
//         int[] key = {i, sum};
//         if (dp.containsKey(key)) return dp.get(key);
        
//         int res = 0;
//         res += backtrack(nums, i+1, sum+nums[i], target, dp);
//         res += backtrack(nums, i+1, sum-nums[i], target, dp);
        
//         dp.put(key, res);
//         return res;
//     }
}
