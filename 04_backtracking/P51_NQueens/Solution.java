class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiagSet = new HashSet<>(); // r + c
        Set<Integer> negDiagSet = new HashSet<>(); // r - c
        
        List<List<String>> res = new ArrayList<>();
        
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");                
            }
            board.add(row);
        }
        
        backtrack(0, res, board, colSet, posDiagSet, negDiagSet, n); // dfs
        
        return res;
    }
    
    private void backtrack(int row, List<List<String>> res, List<List<String>> board,
                           Set<Integer> colSet, Set<Integer> posDiagSet, Set<Integer> negDiagSet, int n) {
        if (row == n) {
            List<String> strBoard = new ArrayList<>();
            for (List<String> rowList: board) {
                StringBuilder sb = new StringBuilder();
                for (String s: rowList) {
                    sb.append(s);
                }
                strBoard.add(sb.toString());
            }
            res.add(strBoard);
        }
        
        for (int i = 0; i < n; i++) {
            if (colSet.contains(i) || posDiagSet.contains(row + i) || negDiagSet.contains(row - i)) {
                continue;
            }
            
            // backtrack; because its a valid cell
            colSet.add(i);
            posDiagSet.add(row+i);
            negDiagSet.add(row-i);
            board.get(row).set(i, "Q");
            
            backtrack(row + 1, res, board, colSet, posDiagSet, negDiagSet, n);
            
            colSet.remove(i);
            posDiagSet.remove(row+i);
            negDiagSet.remove(row-i);
            board.get(row).set(i, ".");
        }
    }

}
