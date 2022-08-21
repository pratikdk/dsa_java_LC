class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0, visited)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word, int cIdx, boolean[][] visited) {
        if (cIdx == word.length()) return true;
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] != word.charAt(cIdx) ||
            visited[i][j] == true) {
            return false;
        }
        
        visited[i][j] = true;
        boolean res = (dfs(i, j+1, board, word, cIdx+1, visited) ||
                       dfs(i+1, j, board, word, cIdx+1, visited) ||
                       dfs(i, j-1, board, word, cIdx+1, visited) ||
                       dfs(i-1, j, board, word, cIdx+1, visited));
        visited[i][j] = false;
        
        return res;
    }
}
