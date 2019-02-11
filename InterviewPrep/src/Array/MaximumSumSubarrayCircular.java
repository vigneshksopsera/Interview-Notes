package Array;

public class MaximumSumSubarrayCircular {
	
	 // Brute force solution
//  public int maxSubarraySumCircular(int[] A) {
     
//      int maxSum = Integer.MIN_VALUE;
//      for(int i=0; i<A.length; i++) {
//          int sum = 0;
//          for(int j=0; j<A.length; j++) {
//              sum+= A[(i+j)%A.length];
//              maxSum = Math.max(sum, maxSum);
             
//          }
//      }
     
//      return maxSum;
//  }
 
 /*
  * Explanation: https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
  * TC: O(N)
  * Tags- Array, Medium
  */
 public int maxSubarraySumCircular(int[] A) {
     
     int currMax = 0, maxSum = Integer.MIN_VALUE, currMin = 0, minSum = Integer.MAX_VALUE, total = 0;
     
     for(int num: A) {
         total += num;
         currMax = Math.max(currMax + num, num);
         maxSum = Math.max(maxSum, currMax);
         currMin = Math.min(currMin + num, num);
         minSum = Math.min(minSum, currMin);
     }
     
     return maxSum > 0 ? Math.max(maxSum, total-minSum) : maxSum;
 }

}
