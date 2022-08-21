class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                int val = stack.pop() + stack.pop();
                stack.push(val);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                int val = a - b;
                stack.push(val);
            } else if (token.equals("*")) {
                int val = stack.pop() * stack.pop();
                stack.push(val);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int val = a / b;
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
