Cases of Backtracking problems

https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

It is a process of building and destroying...


1. Basically we need to iterate the given data structure in the problem in recursive way..(String, array)
2. Each modification of the DS, can lead to a new DS as an argument for the recursive call. Eg. Letter case permutation problem.

or

2. Each iteration idx value, can be recorded as state and captured in next recursive call. Eg. Subsets.