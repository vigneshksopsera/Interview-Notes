package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
 * 
 * Tags- BFS, DP
 * 
 * @author vignesh
 *
 */
public class perfectSquares {
    public int numSquares(int n) {
        
        if(n < 0) return 0;
        if(n == 1) return 1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int level = 0;
        queue.offer(n);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int number = queue.poll();
                for(int i=1; ; i++) {
                    int val = (int)Math.pow(i,2);
                    if(val < number) {
                        if(!seen.contains(number-val)) queue.offer(number - val);
                    }
                    else if(val == number) return level+1;
                    else break;
                }
                size--;
            }
            level++;
        }
        return 0;
    }
}
