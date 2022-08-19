class Solution {
    // bottom up
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = t.length()-1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
    
    // dfsd // time limit exceeded
    public int numDistinct2(String s, String t) {
        Map<int[], Integer> cache = new HashMap<>();
        return dfs(s, t, 0, 0, cache);
    }
    
    public int dfs(String s, String t, int i, int j, Map<int[], Integer> cache) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        int[] key = {i, j};
        if (cache.containsKey(key)) return cache.get(key);
        
        if (s.charAt(i) == t.charAt(j)) {
            cache.put(key, dfs(s, t, i+1, j+1, cache) + dfs(s, t, i+1, j, cache));
        } else {
            cache.put(key, dfs(s, t, i+1, j, cache));
        }
        
        return cache.get(key);
    }
}
