class Bar {
    int index;
    int height;
    Bar(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Bar> stack = new Stack<>(); // monotonic increasing stack
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int start = i; // updated(to index) as we pop from stack
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Bar bar = stack.pop();
                maxArea = Math.max(maxArea, bar.height * (i - bar.index));
                start = bar.index;
            }
            stack.push(new Bar(start, heights[i]));
        }
        
        while (!stack.isEmpty()) {
            Bar bar = stack.pop();
            maxArea = Math.max(maxArea, bar.height * (heights.length - bar.index));
        }
        
        return maxArea;
    }
}
