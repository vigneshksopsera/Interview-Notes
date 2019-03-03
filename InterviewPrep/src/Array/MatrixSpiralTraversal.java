package Array;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Q - https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168
 * Intuition - https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
 * 
 * 
 * Tags - 2D Array, Medium
 * @author vignesh
 *
 */
public class MatrixSpiralTraversal {
	
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        
        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            
            //move right
            for(int j=colBegin; j<=colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            //move down
            for(int j =rowBegin; j<=rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            //move left
            if(rowBegin <= rowEnd) {
                for(int j=colEnd; j>=colBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            //move up
            if(colBegin <= colEnd) {
                for(int j=rowEnd; j>=rowBegin; j--) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        
        return result;
    }

}
