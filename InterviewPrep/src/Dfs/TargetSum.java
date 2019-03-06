package Dfs;

public class TargetSum {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0 || nums==null) return count;
        dfs(0, 0, nums, S);
        return count;
    }
    
    void dfs(int i, int sum, int[] nums, int S) {
        if(i == nums.length) {
            if(sum == S) count++;
            return;
        }
        dfs(i+1, sum + nums[i], nums, S);
        dfs(i+1, sum - nums[i], nums, S);
        return;
    }
}
