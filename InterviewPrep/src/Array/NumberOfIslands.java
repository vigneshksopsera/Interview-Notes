package Array;


/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1



TAgs - DFS, 2d Array
 * 
 * @author vignesh
 *
 */

public class NumberOfIslands {
	
	class Node {
        int i;
        int j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0) return 0;
        boolean[][] visitedNodes = new boolean[grid.length][grid[0].length];
        int numOfIslands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(!visitedNodes[i][j])
                    if(helper(grid, i, j, visitedNodes) == 1) numOfIslands++;
            }
        }
        return numOfIslands;
    }
    
    public int helper(char[][] grid, int i, int j, boolean[][] visitedNodes) {
        
        //System.out.println("Coordinates visiting, i: " + i + " j: " + j);
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0) return 0;
        if(visitedNodes[i][j]) return 0;
        visitedNodes[i][j] = true;
        if(grid[i][j] == '0') return 0;
        
        helper(grid, i, j+1, visitedNodes);
        helper(grid, i+1, j, visitedNodes);
        helper(grid, i, j-1, visitedNodes);
        helper(grid, i-1, j, visitedNodes);
        
        return 1;
    }

}
