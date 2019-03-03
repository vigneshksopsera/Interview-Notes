package Array;

/**
 * Q - https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167
 * Intuition -1 https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/discuss/97711/Java-15-lines-without-using-boolean
 * Intuition - 2 https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/discuss/97712/Concise-Java-Solution
 * 
 * Tags - 2d Array, traversals
 * @author vignesh
 *
 */
public class MatrixDiagonalTraverse {
	
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
                
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = 0;
        int[] arr = new int[m*n];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }  
        }
        return arr;
    }

}
