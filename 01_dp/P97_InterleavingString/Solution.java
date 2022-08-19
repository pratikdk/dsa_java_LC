class Solution {
    // Recursive + memoization
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] cache = new boolean[s1.length()+1][s2.length()+1];
        boolean[][] visited = new boolean[s1.length()+1][s2.length()+1];
        
        return dfs(0, 0, s1, s2, s3, cache, visited);
    }
    
    private boolean dfs(int i1, int i2, String s1, String s2, String s3, boolean[][] cache, boolean[][] visited) {
        if (i1 == s1.length() && i2 == s2.length()) return true;
        if (visited[i1][i2]) return cache[i1][i2];
        
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2) && dfs(i1+1, i2, s1, s2, s3, cache, visited))
            return true;
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2) && dfs(i1, i2+1, s1, s2, s3, cache, visited))
            return true;
        
        cache[i1][i2] = false;
        visited[i1][i2] = true;
        return false;
    }
    
    
    // dp // slow beacuse no early exit
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;
        
        for (int i1 = s1.length(); i1 >= 0; i1--) {
            for (int i2 = s2.length(); i2 >= 0; i2--) {
                if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2) && dp[i1+1][i2])
                    dp[i1][i2] = true;
                if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2) && dp[i1][i2+1])
                    dp[i1][i2] = true; 
            }
        }
        return dp[0][0];
    }
}
