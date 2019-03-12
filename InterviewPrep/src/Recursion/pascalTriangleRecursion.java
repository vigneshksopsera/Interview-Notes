package Recursion;

/**
 * 
 * Q - https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1659/
 * 
 * Tags - Recursion, Recurrence Relation
 */
import java.util.ArrayList;
import java.util.List;

public class pascalTriangleRecursion {
	public List<List<Integer>> generate(int numRows) {
        List<Integer> e = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;
        if(numRows == 1) {
            e.add(1);
            result.add(e);
            return result;
        }
        result = generate(--numRows);
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
