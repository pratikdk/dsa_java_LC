class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        Deque<Integer> queue = new LinkedList<>();
        
        while (right < nums.length) {
            // push new
            while (!queue.isEmpty() && (nums[queue.peekLast()] < nums[right])) {
                queue.pollLast();
            }
            queue.addLast(right);
            
            // remove old
            if (left > queue.peekFirst()) {
                queue.pollFirst();
            }
            
            // get and store max
            if ((right + 1) >= k) {
                res.add(nums[queue.peekFirst()]);
                left += 1;
            }
            right += 1;
        }
        
        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++) output[i] = res.get(i);
        return output;
    }  
}
