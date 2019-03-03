package Stack;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Q- https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 * 
 * Tags - Stack, easy
 * @author vignesh
 *
 */
public class dailyTemperatures {
	
    public int[] dailyTemperature(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ret = new int[T.length];
        for(int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

}
