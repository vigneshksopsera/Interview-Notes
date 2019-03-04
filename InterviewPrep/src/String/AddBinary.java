package String;

/**
 * Q - https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
 * 
 * TC: O(N)
 * 
 * Tags - String, traversal
 * @author vignesh
 *
 */

public class AddBinary {
	
    // public String addBinary(String a, String b) {
    //     StringBuilder sb = new StringBuilder();
    //     int i = a.length() - 1, j = b.length() -1, carry = 0;
    //     while (i >= 0 || j >= 0) {
    //         int sum = carry;
    //         if (j >= 0) sum += b.charAt(j--) - '0';
    //         if (i >= 0) sum += a.charAt(i--) - '0';
    //         sb.append(sum % 2);
    //         carry = sum / 2;
    //     }
    //     if (carry != 0) sb.append(carry);
    //     return sb.reverse().toString();
    // }
    public String addBinary(String a, String b) {
        
        if(a.length() == 0)return b.length() == 0 ? "" : b;
        if(b.length() == 0)return a.length() == 0 ? "" : a;
        
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        
        StringBuilder result = new StringBuilder("");
        while(i >= 0 && j >= 0) {
            int item1 = a.charAt(i) - '0';
            int item2 = b.charAt(j) - '0';
            int sum = item1 + item2 + carry;
            if(sum >= 2) {
                if(sum == 2) result.append('0');
                if(sum == 3) result.append('1');
                carry = 1;
            }
            else {
                if(sum == 1) result.append('1');
                if(sum == 0) result.append('0');
                carry = 0;
            }
            i--; j--;
        }
        
        while(i >= 0) {
            int item1 = a.charAt(i) - '0';
            int sum = 0;
            if(carry == 1){
                sum = item1 + carry;
                if(sum == 1) {
                    result.append('1');
                    carry = 0;
                }
                if(sum >= 2) {
                    if(sum == 2) result.append('0');
                    if(sum == 3) result.append('1');
                    carry = 1;
                }
            } else {
                result.append(a.charAt(i));
                carry = 0;
            }
            i--;
        }
        
        while(j >= 0) {
            int item2 = b.charAt(j) - '0';
            int sum = 0;
            if(carry == 1){
                sum = item2 + carry;
                if(sum == 1) {
                    result.append('1');
                    carry = 0;
                }
                if(sum >= 2) {
                    if(sum == 2) result.append('0');
                    if(sum == 3) result.append('1');
                    carry = 1;
                }
            } else {
                result.append(b.charAt(j));
                carry = 0;
            }
            j--;
        }
        if(carry == 1) result.append('1');
        result.reverse();
        return result.toString();
    }

}
