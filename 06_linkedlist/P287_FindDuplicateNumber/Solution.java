class Solution {
    public int findDuplicate(int[] nums) { // floyds algorithm
        int slow = nums[0];
        int fast = nums[0];
        while (true) { // find first point of intersection
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        
        slow = nums[0];
        while (slow != fast) { // again find point of intersection 
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
