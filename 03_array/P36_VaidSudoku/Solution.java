class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        
        // initalize maps with empty sets
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares.put(i + "," + j, new HashSet<>());
            }
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                
                String squaresKey = i/3 + "," + j/3;
                if (rows.get(i).contains(board[i][j]) ||
                    cols.get(j).contains(board[i][j]) ||
                    squares.get(squaresKey).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(squaresKey).add(board[i][j]);
            }
        }
        return true;
    }
    
    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
