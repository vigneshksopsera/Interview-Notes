package Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Explanation: The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
 * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
 * 
 * TC- O(N^2) SC-O(1)
 * @author vignesh
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i< nums.length-2; i++) {
            if(i==0 || i > 0 && nums[i-1] != nums[i]) {
               int target = nums[i] * -1;
                int left = i+1, right = nums.length-1;
                while(left < right) {
                    if(nums[left] + nums[right] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[left]); 
                        temp.add(target*-1);                                                                 temp.add(nums[right]);
                        result.add(temp);
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    }
                    else if(nums[left] + nums[right] > target) right--;
                    else left++;
                } 
            }
        }
        return result;
    }
}
