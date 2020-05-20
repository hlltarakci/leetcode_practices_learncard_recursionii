// https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2774/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) -- stack usage/recursion -- worst case O(n), average case O(log n)
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalIter(root);
    }
    
    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(null);
        
        while(true) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if(!stack.isEmpty()) {
                curr = stack.pop();
                if(curr == null) break;
                list.add(curr.val);
                curr = curr.right;
            } 
        }
        
        
        return list;
    }
    
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        list.addAll(inorderTraversalRec(root.left));
        list.add(root.val);
        list.addAll(inorderTraversalRec(root.right));
        
        return list;
    }
}
