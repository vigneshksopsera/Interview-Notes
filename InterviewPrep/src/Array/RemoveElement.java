package Array;


/**
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author vignesh
 *
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        
        if(nums.length == 0) return 0;
        int left = -1, right = 0;
        while(right < nums.length) {
            if(nums[right] == val && left == -1) {
                left = right++;
            }
            else if(nums[right] != val && left != -1) {
                int temp = nums[right];
                nums[right++] = nums[left];
                nums[left++] = temp;
            }
            else right++;
        }
        return left == -1 ? nums.length : left;
    }
}
