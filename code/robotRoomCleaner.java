// https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2794/

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    /*
        n: num of cleanable rooms
        time: O(4^n) -- since 4 directions are visited
        space: O(n)
    */
    // clockwise 0:up, 1:right, 2:down, 3:left
    int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public void cleanRoom(Robot robot) {
        backtrack(robot, new HashSet<>(), 0, 0, 0);
    }
    
    private void backtrack(Robot robot, Set<String> visited, int r, int c, int dir) {
        visited.add(r+"_"+c);
        robot.clean();
        
        for(int i=0; i<4; i++) {
            int newDir = (i+dir)%4;
            int[] direction = directions[newDir];
            int newR = r + direction[0];
            int newC = c + direction[1];
            if(!visited.contains(newR+"_"+newC) && robot.move()) {
                backtrack(robot, visited, newR, newC, newDir);
                comeBack(robot);
            }
            robot.turnRight();
        }
    }
    
    private void comeBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
