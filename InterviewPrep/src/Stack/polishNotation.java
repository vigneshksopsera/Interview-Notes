package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Q: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 * TC: O(N) SC:O(N)
 * 
 * Tags- Stack, Easy
 * @author vignesh
 *
 */
public class polishNotation {
	
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens) {
            
            char tokenInChar = token.charAt(0);
            if(token.length() > 1) tokenInChar = token.charAt(1);
            
            if(Character.isDigit(tokenInChar)) stack.push(Integer.parseInt(token));
            else if(tokenInChar == '+') {
                int sum = 0, count = 2;
                while(!stack.isEmpty() && count != 0) {
                    sum += stack.pop();
                    count--;
                }
                // System.out.println("sum: " + sum);
                stack.push(sum);
            }
            else if(tokenInChar == '-') {
                int diff = 0, item1 = 0, item2 = 0;
                if(!stack.isEmpty()) item1 = stack.pop();
                if(!stack.isEmpty()) item2 = stack.pop();
                diff = item2-item1;
                // System.out.println("diff: " + diff);
                stack.push(diff);
            } 
            else if(tokenInChar == '*') {
                int product = 1, count = 2;
                while(!stack.isEmpty() && count != 0) {
                    product *= stack.pop();
                    count--;
                }
                // System.out.println("product: " + product);
                stack.push(product);
            } 
            else if(tokenInChar == '/'){
                int quotient = 0, item1 = 0, item2 = 0;
                if(!stack.isEmpty()) item1 = stack.pop();
                if(!stack.isEmpty()) item2 = stack.pop();
                quotient = item2/item1;
                // System.out.println("div: " + quotient);
                stack.push(quotient);
            }
            else {
                // System.out.println("Not valid input...");
            }
        }
        return stack.pop();
    }

}
