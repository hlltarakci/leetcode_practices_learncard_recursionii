// https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, n, k, 1, new ArrayList<>());
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, int n, int k, int curr, List<Integer> result) {
        if(result.size() == k) {
            results.add(new ArrayList<>(result));
        }
        
        for(int i=curr; i<=n; i++) {
            result.add(i);
            backtrack(results, n, k, i+1, result);
            result.remove(result.size()-1);
        }
    }
}
