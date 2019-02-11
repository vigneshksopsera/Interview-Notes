package Array;

public class MaximumSumSubArray {

	/*
	 * Can be solved by recursion too..
	 * TC: O(N) SC: O(N)
	 * Tags - Array, DP, Easy
	 */
	public int maxSubArray(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        int maxSubArray = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxSubArray = Math.max(dp[i], maxSubArray);
        }
        return maxSubArray;
    }
}
