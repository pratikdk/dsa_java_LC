class Solution {
    public List<String> letterCombinations(String digits) {
        String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> res = new ArrayList<>();
        if (digits != null && digits.length() != 0) {
            backtrack(digits, 0, "", res, chars); // dfs
        }
        return res;
    }
    
    private void backtrack(String digits, int i, String currStr, List<String> res, String[] chars) {
        if (currStr.length() == digits.length()) {
            res.add(currStr);
            return;
        }
        
        String charString = chars[digits.charAt(i) - '0'];
        for (char c: charString.toCharArray()) {
            backtrack(digits, i+1, currStr+c, res, chars);
        }
    }
}
