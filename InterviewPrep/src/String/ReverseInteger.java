package String;


/**
 * Problem - Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
 * For the purpose of this problem,  assume that your function returns 0 when the reversed integer overflows.
 * 
 * TC- O(N)
 * @author vignesh
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
        
        String num = String.valueOf(x);
        long result = 0;
        char[] ch = num.toCharArray();
        int leftIdx = 0, rightIdx = ch.length-1;
        if(ch[0] == '-' || ch[0] == '+') {
            leftIdx++;
        }
        while(leftIdx < rightIdx) {
            char temp = ch[leftIdx];
            ch[leftIdx] = ch[rightIdx];
            ch[rightIdx] = temp;
            leftIdx++; rightIdx--;
        }
        result = Long.parseLong(new String(ch));
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int)result;
    }
}
