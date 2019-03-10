package Searching;

/**
 * 
 * Q - https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
 * 
 * 
 * Tags -Binary Search
 * @author vignesh
 *
 */
public class GuessNumberOrHigher {
	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */
	    public int guessNumber(int n) {
	        
	        if(n == 0) return 0;
	        int lo = 1, hi = n;
	        while(lo <= hi) {
	            int mid = lo + (hi-lo)/2;
	            int result = guess(mid);
	            if(result == 0) return mid;
	            else if(result == 1) lo = mid+1;
	            else hi = mid-1;
	        }
	        return 1;
	    }
	    
	    public int guess(int val) {
	    	
	    	// API just for imp purposes
	    	return -1;
	    }
}
