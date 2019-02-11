package Array;



/**
 * Problem;
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system 
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

 * 
 * TC- O(N)
 * Explanation: either choose 1st item in array or choose the last item and find the sum of each series
 * We can extend the solution of House Robber I and do it, which includes DP.
 * Commented section of code is easy to understand solution...
 * 
 * Tags - Array, DP, Circular Array
 * @author vignesh
 *
 */

public class HouseRobberII {

	//Easy to understand solution
//	public int rob(int[] nums) {
//        
//        if (nums.length == 1)
//            return nums[0];
//
//        int a = 0, b = 0;
//        
//        for (int i=0; i<nums.length-1; i++) {
//            if (i % 2 == 0) {
//                a = Math.max(b, a + nums[i]);
//            } else {
//                b = Math.max(a, b + nums[i]);
//            }
//        }
//        
//        int max = Math.max(a, b);
//        a=0; b=0;
//        
//        for (int i=1; i<nums.length; i++) {
//             if (i % 2 == 0) {
//                a = Math.max(b, a + nums[i]);
//            } else {
//                b = Math.max(a, b + nums[i]);
//            }
//        }
//        
//        max = Math.max(max, Math.max(a,b));
//        
//        return max;
//    }

	public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;        
        int exclude_1st = rob_helper(nums, 1, nums.length-1);
        int include_1st = nums[0] + rob_helper(nums, 2, nums.length-2);
        return Math.max(include_1st, exclude_1st);        
    }

    public int rob_helper(int[] nums, int start, int end) {     
        int pre_i_2 = 0;
        int pre_i_1 = 0;
        for(int i=start; i<=end; i++)
        {
            int cur = Math.max(nums[i] + pre_i_2, pre_i_1);
            int temp = pre_i_1;
            pre_i_1 = cur;
            pre_i_2 = temp;
        }        
        return pre_i_1;
    }
}
