package Sorting;

import java.util.Arrays;


/**
 * 
 * Q- https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/
 * 
 * A - https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/discuss/60294/Solution-explained
 * 
 * Tags - Sorting, Array, Easy
 * @author vignesh
 *
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
