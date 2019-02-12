package Array;


/**
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2.
 * 
 * TC - O(N) SC-O(1)
 * 
 * Tags - Array, Two Pointers
 * @author vignesh
 *
 */
public class TwoSumII {

	public int[] twoSum(int[] numbers, int target) {
        
        int[] res = new int[2];
        if(numbers.length <= 1) return null;
        int left = 0, right = numbers.length-1;
        
        if(numbers[left] > target) return res;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                res[0] = ++left;
                res[1] = ++right;
                return res;
            }
            if(sum > target)right--;
            else left++;
        }
        return res;
    }
}
