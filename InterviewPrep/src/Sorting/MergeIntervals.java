package Sorting;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * Q - https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803
 * 
 * 
 * Tags - Sorting, Medium
 * @author vignesh
 *
 */
public class MergeIntervals {
	
	 // Definition for an interval.
	 public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	 }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
	    
	    // public List<Interval> merge(List<Interval> intervals) {
	    //     if(intervals == null || intervals.size() == 0) return Collections.emptyList();
	    //     Collections.sort(intervals,new Comparator<Interval>(){
	    //         public int compare (Interval i1, Interval i2){
	    //             return i1.start - i2.start;
	    //         }
	    //     });
	    //     List<Interval> list = new LinkedList<>();
	    //     Interval pre = new Interval(intervals.get(0).start,intervals.get(0).end);
	    //     for(Interval curr: intervals){
	    //         if(pre.end < curr.start) {
	    //             list.add(pre);
	    //             pre = curr;
	    //         }else {
	    //             pre.start = Math.min(pre.start, curr.start);
	    //             pre.end = Math.max(pre.end, curr.end);
	    //         }
	    //     }
	    //     list.add(pre);
	    //     return list;
	    // }
	}
