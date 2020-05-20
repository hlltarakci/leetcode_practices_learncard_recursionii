// https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtrack(results, n, 0, 0, new StringBuilder());
        return results;
    }
    
    private void backtrack(List<String> results, int n, int opens, int closes, StringBuilder sb) {
        if(opens == n && closes == n) {
            results.add(sb.toString());
        }   
        
        if(closes < opens) {
            sb.append(")");
            backtrack(results, n, opens, closes+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
         
        if(opens < n) {
            sb.append("(");
            backtrack(results, n, opens+1, closes, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
