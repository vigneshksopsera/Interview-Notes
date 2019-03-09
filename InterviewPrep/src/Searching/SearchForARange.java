package Searching;


/**
 * 
 * Q - https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/
 * 
 * Tags - Binary Search
 * @author vignesh
 *
 */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        
        int N = nums.length;
        int[] result = {-1,-1};
        if(N == 0) return result;
        int left = 0, right = N-1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                int leftTargetPos = mid;
                int rightTargetPos = mid;
                while(leftTargetPos - 1 >= left ) {
                    if(nums[leftTargetPos-1] != target) {
                        break;
                    }
                    else leftTargetPos--; 
                }
                while(rightTargetPos + 1 <= right) {
                    if(nums[rightTargetPos+1] != target) {
                        break;
                    }
                    else rightTargetPos++; 
                }
                result[0] = leftTargetPos;
                result[1] = rightTargetPos;
                return result;
            }
            else if(nums[mid] < target) {
                left = mid+1;
            } 
            else right = mid-1;
        }
        return result;
    }
}
