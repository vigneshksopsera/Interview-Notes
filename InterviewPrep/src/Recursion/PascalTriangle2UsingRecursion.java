package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1660/
 * Similar to pascals triangle
 * 
 * Tags - Recursion, Recurrence relation
 * @author vignesh
 *
 */
public class PascalTriangle2UsingRecursion {
	
	public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = buildPascalsTriangle(rowIndex+1);
        return result.get(rowIndex);
    }
    
    List<List<Integer>> buildPascalsTriangle(int numRows) {
        List<Integer> e = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;
        if(numRows == 1) {
            e.add(1);
            result.add(e);
            return result;
        }
        result = buildPascalsTriangle(--numRows);
        List<Integer> prev = result.get(result.size() - 1);
        e.add(1);
        for(int i = 0; i < prev.size() - 1; i++) {
            e.add(prev.get(i) + prev.get(i+1));
        }
        e.add(1);
        result.add(e);
        return result;
        
    }

}
