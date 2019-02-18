package dynamicProgramming;

/**
 * 
 * Problem - You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * 
 * Tags - DP, Recurrence relation..
 * 
 * 
 * 
 * @author vignesh
 *
 */

public class ClimbStairs {
	
	/**
	 * Intuition: one can climb stair at level=3 by coming 1 step from level=2, or 2 steps from level=1 
	 * Recurrence relation: climbStep[i] = climbStep[i-1] + climbStep[i-2];
	 * @param 
	 * @return
	 */
    public int climbStairs(int n) {
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int oneStepBefore = 2, twoStepBefore = 1;
        int numberOfSteps = 0;
        
        for(int i=2; i<n; i++) {
            numberOfSteps = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = numberOfSteps;
        }
        return numberOfSteps;
    }

}
