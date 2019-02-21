package Array;

import java.util.Arrays;


/**
 * 
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * @author vignesh
 *
 */
public class ArrayPartitionI {

	
    public int arrayPairSum(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 0, left = 0, right = left+1;
        while(left < nums.length || right < nums.length) {
            sum += Math.min(nums[left], nums[right]);
            left = right+1;
            right = right+2;
        }
        return sum;
    }
}
