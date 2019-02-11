package Array;

import java.util.Arrays;


/*
 * Time Complexity - O(N), SC - O(N)
 * Explanation 
 * Approach 1: 
 * a)Find min element and construct new array and replace the order.
 * b)
 * 
 * Tags - Array, Easy
 */

public class CheckArrayIsSortedAndRotated {
	
	public boolean checkArrayIsSortedAndRotated(int[] A) {
		
		int[] newArr = new int[2*A.length];
		
		//copy value of A into new arr.
		newArr = Arrays.copyOf(A, newArr.length);
		int Aidx = 0;
		for(int i = A.length; i<newArr.length;i++) {
			newArr[i] = A[Aidx++];
		}
		//find min element & idx
		int minValue = A[0]; int minIdx = 0;
		for(int i=0; i<A.length;i++) {
			if(minValue > A[i]) {
				minIdx = i;
				minValue = A[i];
			}
		}
		//check if array sorted from min to min value
		for(int j=minIdx; j< minIdx+A.length-1; j++) {
			if(newArr[j] > newArr[j+1]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] A = {1,1,1,1,1};
		CheckArrayIsSortedAndRotated solution = new CheckArrayIsSortedAndRotated();
		System.out.println("Array is sorted and rotated: " 
		+ solution.checkArrayIsSortedAndRotated(A));
	}

}
