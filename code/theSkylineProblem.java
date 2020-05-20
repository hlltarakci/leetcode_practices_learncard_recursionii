// https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/3006/

class Solution {
    /*
        https://leetcode.com/problems/the-skyline-problem/discuss/611016/Java-Clean-Code-with-details-algorithm-explanation
        ?
    */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        construct(map, buildings);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[2], a[2]));
        List<List<Integer>> result = new ArrayList<>();
        
        for(int x: map.keySet()) {
            for(int[] building: map.get(x)) {
                if(building[0] == x) maxHeap.add(building);
                else maxHeap.remove(building);
            }
            
            if(maxHeap.isEmpty()) result.add(new ArrayList<>(Arrays.asList(x, 0)));
            else {
                int maxHeight = maxHeap.peek()[2];
                
                if (result.isEmpty() || result.get(result.size() - 1).get(1) != maxHeight) 
				    result.add(new ArrayList<>(Arrays.asList(x, maxHeight)));
            }
        }
        
        return result;
    }
    
    private void construct(TreeMap<Integer, List<int[]>> map, int[][] buildings) {
        for(int[] building: buildings) {
            map.putIfAbsent(building[0], new ArrayList<>());
            map.putIfAbsent(building[1], new ArrayList<>());
            
            map.get(building[0]).add(building);
            map.get(building[1]).add(building);
        }
    }
}
