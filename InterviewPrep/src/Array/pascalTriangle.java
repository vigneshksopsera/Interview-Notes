package Array;

import java.util.ArrayList;
import java.util.List;


/**
 * Q: https://leetcode.com/problems/pascals-triangle/
 * 
 * TC: O(N) SC: O(N)
 * 
 * Tags - Array, easy-medium
 * @author vignesh
 *
 */

public class pascalTriangle {
	
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> prevList;
        prevList = new ArrayList<>();
        prevList.add(1);
        result.add(prevList);
        if(numRows > 1) {
            prevList = new ArrayList<>();
            prevList.add(1);
            prevList.add(1);
            result.add(prevList);
        }
        
        for(int i=3; i<=numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int j = 1; j<prevList.size(); j++) {
                int val = prevList.get(j) + prevList.get(j-1);
                newList.add(j, val);
            }
            newList.add(1);
            result.add(newList);
            prevList = new ArrayList<>(newList);
        }
        
        return result;
    }

}
