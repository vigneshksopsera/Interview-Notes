package Stack;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 * 
 * Tags- Stack, easy
 * 
 * @author vignesh
 *
 */
public class validParanthesis {
	
	public boolean isValid(String s) {
        
        if(s.equals("")) return true;
        Deque<Character> bracketStack = new ArrayDeque<>();
        char[] sInChars = s.toCharArray();
        
        for(Character bracket: sInChars) {
            if(bracket == '(' || bracket == '{' || bracket == '[') bracketStack.push(bracket);
            else {
                if(bracketStack.isEmpty()) return false;
                Character topOpeningBracketFromStack = bracketStack.pop();
                if(bracket == ')' && topOpeningBracketFromStack != '(') return false;
                else if(bracket == '}' && topOpeningBracketFromStack != '{') return false; 
                else if(bracket == ']' && topOpeningBracketFromStack!= '[') return false; 
            }
        }
        if(!bracketStack.isEmpty()) return false;
        return true;
    }

}
