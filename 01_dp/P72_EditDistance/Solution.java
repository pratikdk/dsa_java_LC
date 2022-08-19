class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        // bottom row base case
        for (int j = 0; j < word2.length()+1; j++) {
           dp[word1.length()][j] = word2.length()-j; 
        }
        
        // right row base case
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][word2.length()] = word1.length()-i;
        }
        
        // bottom up dp
        for (int i = word1.length()-1; i >= 0; i--) {
            for (int j = word2.length()-1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    int minOps = dp[i+1][j+1];
                    if (minOps > dp[i+1][j]) minOps = dp[i+1][j];
                    if (minOps > dp[i][j+1]) minOps = dp[i][j+1];
                    dp[i][j] = 1 + minOps;
                }
            }
        }
        
        return dp[0][0];
    }
}
