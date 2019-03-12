package Backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


/**
 * 
 * Q- https://leetcode.com/problems/letter-case-permutation/
 * Intuition - iterate through chars, put in set to check if visited.
 * if lowercase, change to uppercase and vice versa..
 * 
 * Tags - backtracking, string
 * @author vignesh
 *
 */
public class LetterCasePermutation {
	class Solution {
	    Set<String> seen = new HashSet<>();
	    public List<String> letterCasePermutation(String S) {
	        List<String> result = new ArrayList<>();
	        if(S == "") return result;
	        helper(S, result);
	        return result;
	    }
	    
	    public void helper(String S, List<String> result) {
	        if(seen.contains(S)) return;
	        seen.add(S);
	        result.add(S);
	        
	        for(int i=0; i<S.length(); i++) {
	            char[] cArr = S.toCharArray();;
	            if(!Character.isLetter(cArr[i])) continue;
	            cArr[i] = Character.isLowerCase(cArr[i]) ? Character.toUpperCase(cArr[i]) : Character.toLowerCase(cArr[i]);
	            helper(new String(cArr), result);
	        }
	    }
	}

}
