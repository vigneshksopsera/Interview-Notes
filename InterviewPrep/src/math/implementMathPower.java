package math;

public class implementMathPower {
	
	/*
	 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
	 * 
	 */
	
//  public double myPow(double x, int n) {
//  double number = (double) x, result = 0;
//  if(n >= Integer.MAX_VALUE) return number * 1;
//  else if(n <= Integer.MIN_VALUE) return number * 0;
//  else if(n < 0) {
//      number = (double) (1/x);
//      n *= -1;
//  }
//  else if(n == 0) return 1;
//  else if(n == 1) return x;
 
//  result = n >= 2 ? number*number : number; 
//  for(int i=3; i<=n; i++) {
//      result *= number;
//      // System.out.println("Result: " + result);
//  }
//  return result;
//}

	public double myPow(double x, int n) {
		 System.out.println(x + ", " + n);
		 if(n == 0)
		     return 1;
		 if(n == Integer.MIN_VALUE){
		     return myPow(x*x, n/2);
		 }
		 if(n < 0){
		     x = 1/x;
		     n = -n;
		 }
		 if(n%2 == 1) {
		     return myPow(x*x, n/2)*x;
		 }
		 else
		     return myPow(x*x, n/2);
	}
	
}
