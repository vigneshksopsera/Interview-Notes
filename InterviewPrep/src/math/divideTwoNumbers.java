package math;

/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
 * 
 * 
 * Tags - math
 * @author vignesh
 *
 */

public class divideTwoNumbers {
	
    public int divide(int dividend, int divisor) {
        
        System.out.println("MAX VALUE: " + Integer.MAX_VALUE);
        System.out.println("MIN VALUE: " + Integer.MIN_VALUE);
        
        int numberOfTimesSubtracted = 0;
        boolean divisorNegative = false;
        boolean dividendNegative = false;
        if(divisor > 0) {
            if(divisor > Integer.MAX_VALUE) divisor = Integer.MAX_VALUE;        
            if(divisor == 1) numberOfTimesSubtracted = dividend; 
        }
        if(divisor < 0) {
            if(divisor < Integer.MIN_VALUE) divisor = Integer.MIN_VALUE;
            divisorNegative = true;
            divisor *= -1;
        }
        if(dividend <= 0) {
            if(dividend == 0) return 0;
            if(dividend < Integer.MIN_VALUE) dividend = Integer.MIN_VALUE;
            dividendNegative = true;
            dividend *= -1;
        }
        if(dividend > Integer.MAX_VALUE) dividend = Integer.MAX_VALUE;
        if(dividend == 1) numberOfTimesSubtracted++;
        if(dividend < divisor) return 0;
        
        while(dividend > 1 && divisor > 1) {
            dividend = dividend - divisor;
            numberOfTimesSubtracted++;
            //System.out.println("New Dividend: " + newDividend + ", divisor: " + divisor);
            if(numberOfTimesSubtracted == Integer.MAX_VALUE) return Integer.MAX_VALUE-1;
        }
        return divisorNegative == dividendNegative ? numberOfTimesSubtracted : (numberOfTimesSubtracted*-1);
    }

}
