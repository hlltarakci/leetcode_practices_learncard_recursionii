// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/

class Solution {
    /*
        r,c: matrix rows, cols
        time:O(r+c)
        space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length-1, c=0;
        
        while(r >=0  && c < matrix[0].length) {
            int val = matrix[r][c];
            if(val == target) return true;
            if(val < target) c++;
            else r--;
        }
        
        return false;
    }
}
