# Interview Prep


Categories of questions:

Array
    Two ptr/sliding window, 2d matrix, backtracking, DP, circular array, divide & conquer
String
    reverse, palindrome, sliding window, backtracking
Lists
    median, reverse, merge
Tree
    traversals, searching
Stack
Queue
Graph
    traversals(BFS, DFS) shortest path
Math problems

Mistakes and lessons learnt from previous interviews:

Scheduling:
1. Pay more attention to scheduling and always keep 2-3 days open before the on-site interview of company. Unless very critical dont schedule anything immediately.
2. Its okay to reach out to HR and reschedule. If suddenly after scheduling, if the 2-3 days before onsite looks very congested (ex. Lifion 2 days before onsite, i was fully swamped with office work) try to reschedule.
3. Avoid C style companies. startups whose products are not good and unsuitable position(FE, DevOps) companies.
4. Clarify upfront type of interviews and avoid them if not good.

Preparation during interviews:

1. Days before onsite or phone interview, I tend to waste a lot and cramp everything on the last day.
It increases anxiety, pressure and decreases my performance.
2. Reason: 
    a) No checklists or clear direction of what to cover.
    b) Negative attitude.
    c) Distraction mainly due to negative attitude.
    d) Lack of motivation.

3. Checklist for onsite:
    1. Leave 3 days before onsite open.
    2. Revise all the data structures, algorithms, time complexities, tricks, SD, OOD and solved PS problems if possible.
    3. 2nd day solve more problems. 80%PS, 20%SD and OOD problems.
    4. Before onsite till evening solve problems in same ratio.
    5. Prepare for behavorial till night.
    6. Have good sleep of 8 hours.
    
Strategy for problem solving: #TBD
1. Make sure the problem is well understood. Clarify input, output and constraints. 
2. Try to come with brute force and if the time goes beyond 15-20mins, code the brute force solution.
3. Try to identify if it falls within some structure. For ex (array->backtracking, tree->iterative, string->sliding window).
4. Try the #TBD CTC Algorithm Strategies and getting unstuck tips from Interview Cake.
5. Write optimized code no more than 100 lines.
6. Check edge cases and corner cases before 'Submitting the solution'.

Sliding Window Template for multiple problems.
``https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.``

Dynamic programming

7 steps to solve DP problem:

1. How to recognize a DP problem
2. Identify problem variables
3. Clearly express the recurrence relation
4. Identify the base cases
5. Decide if you want to implement it iteratively or recursively
6. Add memoization
7. Determine time complexity

Most of the DP problems can be approached using the following sequence:

1.Find recursive relation
2. Recursive (top-down)
3. Recursive + memo (top-down)
4. Iterative + memo (bottom-up)
5. Iterative + N variables (bottom-up)

Step 1. Figure out recursive relation.
A robber has 2 options: a) rob current house i; b) don't rob current house.
If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
So it boils down to calculating what is more profitable:

robbery of current house + loot from houses before the previous
loot from the previous house robbery and any loot captured before that
rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

Step 2. Recursive (top-down)
Converting the recurrent relation from Step 1 shound't be very hard.

``public int rob(int[] nums) {
    return rob(nums, nums.length - 1);
}
private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
}``
This algorithm will process the same i multiple times and it needs improvement. Time complexity: [to fill]

Step 3. Recursive + memo (top-down).

``int[] memo;
public int rob(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return rob(nums, nums.length - 1);
}

private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    if (memo[i] >= 0) {
        return memo[i];
    }
    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    memo[i] = result;
    return result;
}``
Much better, this should run in O(n) time. Space complexity is O(n) as well, because of the recursion stack, let's try to get rid of it.

Step 4. Iterative + memo (bottom-up)

``public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        memo[i+1] = Math.max(memo[i], memo[i-1] + val);
    }
    return memo[nums.length];
}``
Step 5. Iterative + 2 variables (bottom-up)
We can notice that in the previous step we use only memo[i] and memo[i-1], so going just 2 steps back. We can hold them in 2 variables instead. This optimization is met in Fibonacci sequence creation and some other problems [to paste links].

/* the order is: prev2, prev1, num  */
``public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}``
