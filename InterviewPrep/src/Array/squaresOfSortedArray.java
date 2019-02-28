package Array;


/**
 * 
 * Q: https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * TC: O(N)  SC: O(N)
 * 
 * Tags - Array, Easy, 2ptr approahc
 * @author vignesh
 *
 */

public class squaresOfSortedArray {
	
	public int[] sortedSquares(int[] A) {
        
        if(A.length == 0) return A;
        int left = 0, right = A.length-1, k = A.length-1;
        int[] result = new int[A.length];
        
        while(left < right) {
            
            int leftSqr = (int)Math.pow(A[left], 2);
            int rightSqr = (int)Math.pow(A[right], 2);
            
            if(leftSqr > rightSqr) {
                result[k--] = leftSqr;
                left++;
            } else {
                result[k--] = rightSqr;
                right--;
            }
        }
        result[k] = (int)Math.pow(A[left], 2);
        return result;
    }

}
