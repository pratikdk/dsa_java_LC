class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length-2), robRange(nums, 1, nums.length-1));
    }
    
    public int robRange(int[] nums, int start, int end) {
        int i2 = 0, i1 = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int curr = Math.max(i1, i2 + nums[i]);
            i2 = i1;
            i1 = curr;
        }
        return i1;
    }
}
