class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        int maxLIP = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLIP = Math.max(maxLIP, dfs(i, j, matrix, dp, -1));
            }
        }
        return maxLIP;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] dp, int prevVal) {
        if (i < 0 || i == matrix.length ||
            j < 0 || j == matrix[0].length ||
            matrix[i][j] <= prevVal) {
            return 0;
        }
        if (dp[i][j] > 0) return dp[i][j];
        
        int res = 1; // i,j
        res = Math.max(res, 1 + dfs(i, j+1, matrix, dp, matrix[i][j]));
        res = Math.max(res, 1 + dfs(i+1, j, matrix, dp, matrix[i][j]));
        res = Math.max(res, 1 + dfs(i, j-1, matrix, dp, matrix[i][j]));
        res = Math.max(res, 1 + dfs(i-1, j, matrix, dp, matrix[i][j]));
        
        return dp[i][j] = res;
    }
}
