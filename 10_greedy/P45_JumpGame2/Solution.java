class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        
        while (right < nums.length-1) {
            int farthest = 0;
            for (int i = left; i < right+1; i++) { // left -> right is a breadth search op; bfs; num of breadth until last index == res
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            res += 1;
        }
        return res;
    }
}
