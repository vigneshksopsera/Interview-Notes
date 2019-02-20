package Array;

/**
 * 
 * In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.
 * 
 * @author vignesh
 *
 */

public class LargestNumberAtLeastTwiceOfOthers {
	
	 public int dominantIndex(int[] nums) {
	        
	        if(nums.length == 0) return -1;
	        int maxValue = Integer.MIN_VALUE;
	        int maxIdx = -1;
	        for(int i = 0; i< nums.length; i++) {
	            if(maxValue < nums[i]) {
	                maxValue = nums[i];
	                maxIdx = i;
	            }
	        }
	        for(int i = 0; i< nums.length; i++) {
	            if(i == maxIdx || nums[i] == 0) continue;
	            else if((maxValue/nums[i]) >= 2) continue;
	            else return -1;
	        }
	        return maxIdx;
	    }

}
