class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        backtrack(0, 0, res, stack, n);
        return res;
    }
    
    private void backtrack(int openN, int closeN, List<String> res, List<String> stack, int n) {
        if (openN == n && closeN == n) {
            StringBuilder sb = new StringBuilder();
            for (String c: stack) sb.append(c);
            res.add(sb.toString());
            return;
        }
        
        if (openN < n) {
            stack.add("(");
            backtrack(openN+1, closeN, res, stack, n);
            stack.remove(stack.size()-1);
        }
        
        if (closeN < openN) {
            stack.add(")");
            backtrack(openN, closeN+1, res, stack, n);
            stack.remove(stack.size()-1);
        }
    }
}
