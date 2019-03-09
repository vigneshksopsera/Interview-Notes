package Sorting;

/**
 * 
 * Q https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798
 * Intuition - https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/discuss/26500/Four-different-solutions
 * 
 * 
 * Tags - Array, Sorting, Count Sort
 * @author vignesh
 *
 */
public class DutchNationalFlagProblem {
    public void sortColors(int[] nums) {
        
        if(nums.length == 0) return;
        int[] countArr = new int[3];
        int[] output = new int[nums.length];
        for(int num : nums) {
            countArr[num] += 1; //2,2,2
        }
        // modify count array -> 2,4,6
        for(int i=1; i<countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }
        
        for(int i=0; i<nums.length; i++) {
            output[countArr[nums[i]]-1] = nums[i];
            countArr[nums[i]]--;
        }
        
        System.arraycopy(output, 0, nums, 0, nums.length); 
        return;
    }

}
