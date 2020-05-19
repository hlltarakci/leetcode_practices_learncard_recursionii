// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/

class Solution {
    /*
        n: arr len
        time: O(n log n)
        space: O(n)
    */
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) return nums;
        
        int middle = nums.length / 2;
        int[] leftSorted = sortArray(Arrays.copyOfRange(nums, 0, middle));
        int[] rightSorted = sortArray(Arrays.copyOfRange(nums, middle, nums.length));
        
        return merge(leftSorted, rightSorted);
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        
        int iM=0, iL=0, iR=0;
        while(iL < left.length || iR < right.length) {
            int valL = iL < left.length ? left[iL] : Integer.MAX_VALUE;
            int valR = iR < right.length ? right[iR] : Integer.MAX_VALUE;
            
            if(valL < valR) {
                merged[iM++] = valL;
                iL++;
            } else {
                merged[iM++] = valR;
                iR++;
            }
        }
        
        return merged;
    }
}
