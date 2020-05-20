// https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/

class Solution {
    /*
        n: arr len
        time: O(n)
        stack: O(n)
    */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<heights.length; i++) {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) 
                max = Math.max(max, heights[stack.pop()] * (i-stack.peek()-1));
                
            stack.push(i);
        }
        
        while(stack.peek() != -1) 
            max = Math.max(max, heights[stack.pop()] * (heights.length-stack.peek()-1));
        
        return max;
    }
}
