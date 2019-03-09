package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Q - Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Tags - Sorting, Bucket Sort, Easy
 * @author vignesh
 *
 */
public class TopKFrequentElements {
	
	/*
	 * Runtime - 35ms
	 */
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) {
                int val = map.get(num);
                map.put(num, val+1);
            }
            else map.put(num, 1); 
        }
        
        int maxValue = Integer.MIN_VALUE, maxKey = 0;
        while(k > 0) {
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            result.add(maxKey);
            maxValue = Integer.MIN_VALUE;
            map.put(maxKey, maxValue);
            k--;
        }
        return result;
    }
    
    
    /**
     * Solution using bucket sort Runtime - 10ms
     */
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int n: nums){
//            map.put(n, map.getOrDefault(n,0)+1);
//        }
//        
//        // corner case: if there is only one number in nums, we need the bucket has index 1.
//        List<Integer>[] bucket = new List[nums.length+1];
//        for(int n:map.keySet()){
//            int freq = map.get(n);
//            if(bucket[freq]==null)
//                bucket[freq] = new LinkedList<>();
//            bucket[freq].add(n);
//        }
//        
//        List<Integer> res = new LinkedList<>();
//        for(int i=bucket.length-1; i>0 && k>0; --i){
//            if(bucket[i]!=null){
//                List<Integer> list = bucket[i]; 
//                res.addAll(list);
//                k-= list.size();
//            }
//        }
//        
//        return res;
//    }

}
