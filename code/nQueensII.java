// https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/

class Solution {
    /*
        time: O(n!)
        space: O(n)
    */
    public int totalNQueens(int n) {
        return backtrack(0, new int[n]);
    }
    
    private int backtrack(int row, int[] queens) {
        if(row == queens.length) return 1;
        
        int count = 0;
        for(int i=0; i<queens.length; i++) {
            if( isSafe(row, i, queens)) {
                queens[row] = i;
                count += backtrack(row+1, queens);
            }
        }
    
        return count;
    }

    private boolean isSafe(int row, int col, int[] queens) {
        // no queens on sane row for sure
        // check for no queens on same col        
        // check hill diagonal 
        // check dale diagonal
        int hillCol = col+1, daleCol = col-1;
        for(int i=row-1; i>=0; i--) {
            if(queens[i] == col || queens[i] == hillCol++ || queens[i] == daleCol--) 
                return false;
        }
        
        return true;
    }
}
