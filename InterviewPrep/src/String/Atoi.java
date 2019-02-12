package String;

/**
 * Implement atoi which converts a string to an integer.
 * 
 * 
 * Tags - String
 * @author vignesh
 *
 */
public class Atoi {

	public int myAtoi(String str) {
        
        str = str.trim();
        if(str.length() == 0) return 0;
        char[] ch = str.toCharArray();
        int sign =1; int idx = 0;
        
        if(!Character.isDigit(ch[0])) {
            if(ch[0] == '-' || ch[0] == '+') {
                if(ch[0]=='-')sign =-1;
                idx++;
            }
           else return 0;
        }
        long num = 0; 
        while(idx < str.length()) {
            if(!Character.isDigit(ch[idx])) break;
            if(ch[idx] == ' ') break;
            int digit = Character.getNumericValue(ch[idx]);
            num = (num * 10 + digit);
            if((num*sign) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if((num*sign) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            idx++;
        }
        return (int) num * sign;
    }
}
