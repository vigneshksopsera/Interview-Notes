package String;

/**
 * 
 * Q - https://leetcode.com/problems/palindromic-substrings/
 * A - 
 * 
 * @author vignesh
 *
 */
public class PalindromicSubstring {
//  public int countSubstrings(String s) {
//  List<String> validPalindromes = new ArrayList<>(); 
//  helper(s, "", 0, validPalindromes);
//  return validPalindromes.size();
//}

//public void helper(String word, String palindromeSubstring, int pos, List<String> validPalindromes){
 
//  System.out.println(palindromeSubstring);
//  if(isPalindrome(palindromeSubstring)) {
//      //System.out.println("passed:" + palindromeSubstring);
//     validPalindromes.add(palindromeSubstring);  
//  }
//  if(pos >= word.length()) return;
 
//  for(int i=pos; i<word.length(); i++) {
//      StringBuilder sb = new StringBuilder(palindromeSubstring);
//      sb.append(word.charAt(i));
//      helper(word, sb.toString(), i+1, validPalindromes);
//      int n = sb.toString().length();
//      sb.deleteCharAt(n-1);
//  }
//  return;
//}

//boolean isPalindrome(String word) {
//  if(word == "") return false;
//  char[] wordInChar = word.toCharArray();
//  int n = wordInChar.length;
//  for(int i=0; i<n/2; i++) {
//      if(wordInChar[i] != wordInChar[n-1-i]) return false;
//  }
//  return true;
//}

int count = 0;
public int countSubstrings(String s) {
 if (s == null || s.length() == 0) return 0;
 
 for (int i = 0; i < s.length(); i++) { // i is the mid point
     extendPalindrome(s, i, i); // odd length;
     extendPalindrome(s, i, i + 1); // even length
 }
 
 return count;
}

private void extendPalindrome(String s, int left, int right) {
 while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
     count++; left--; right++;
 }
}

}
