class Solution {
    public int[] dailyTemperatures(int[] temperatures) { // implement using stack; monotonic decresing stack
        List<int[]> stack = new ArrayList<>(); // [temp, index]
        int[] res = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.get(stack.size()-1)[0] < temperatures[i]) {
                int[] entry = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                res[entry[1]] = (i - entry[1]);
            }
            stack.add(new int[]{temperatures[i], i});
        }
        return res;
    }
}
