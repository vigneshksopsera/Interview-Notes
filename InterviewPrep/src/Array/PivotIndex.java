package Array;

/**
 * 
 * 
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * 
 * 
 * Tags - Array
 * 
 * @author vignesh
 *
 */
public class PivotIndex {
	public int pivotIndex(int[] nums) {
        
        if(nums.length < 2) return -1;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int pivotIdx = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if((sum - nums[i]) % 2 != 0) continue;
            else {
                int left = i-1, right = i+1;
                int leftSum =0, rightSum = 0;
                while(left >= 0) leftSum += nums[left--];
                while(right < nums.length) rightSum += nums[right++];
                if(leftSum == rightSum) {
                    pivotIdx = Math.min(pivotIdx, i);
                }
            }
        }
        return pivotIdx == Integer.MAX_VALUE ? -1 : pivotIdx;
    }
}
