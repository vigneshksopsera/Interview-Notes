package String;

/**
 * 
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Tags -  String 
 * @author vignesh
 *
 */

public class strStr {
	
	//Efficient solution from LC peers
	
//	public int subString(String haystack, String needle) {
//        int l1 = haystack.length(), l2 = needle.length();
//        if (l1 < l2) {
//            return -1;
//        } else if (l2 == 0) {
//            return 0;
//        }
//        int threshold = l1 - l2;
//        for (int i = 0; i <= threshold; ++i) {
//            if (haystack.substring(i,i+l2).equals(needle)) {
//                return i;
//            }
//        }
//        return -1;
//    }
	
	public int subString(String haystack, String needle) {
        
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        for(int i=0; i<haystack.length(); i++) {
            
            if(haystack.charAt(i) == needle.charAt(0)) {
                int right = 1;
                int count = needle.length()-1;
                while(count > 0 && (i+right) < haystack.length()) {
                    if(haystack.charAt(i+right) == needle.charAt(right)) {
                        right++;
                        count--;
                    }
                    else break;
                }
                if(count == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

}
