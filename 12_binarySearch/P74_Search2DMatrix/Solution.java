class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first do binary search on m
        // next do binary search on seached n;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = m-1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[mid][n-1]) {
                top = mid+1;
            } else if (target < matrix[mid][0]) {
                bottom = mid-1;
            } else {
                break;
            }
        }
        
        if (top > bottom) { // row not in matrix
            return false;
        }
        
        int left = 0, right = n-1;
        int rowIndex = (top + bottom) / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > matrix[rowIndex][mid]) {
                left = mid + 1;
            } else if (target < matrix[rowIndex][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
