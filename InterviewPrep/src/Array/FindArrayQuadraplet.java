package Array;
import java.util.*;

class FindArrayQuadraplet {
  
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // your code goes here
    
    Arrays.sort(arr);
    Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    for(int i=0; i<arr.length-3; i++) {
      int left = i+1;
      int right = arr.length-1;
      
      while(left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if(sum < s) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(arr[i]);
          list.add(arr[left]);
          list.add(arr[right]);
          map.put(s-sum, list);
          left++;
        } else right--;
      }
    }
    
    List<Integer> result = null;
    for(int j=0; j<arr.length; j++) {
      if(map.containsKey(arr[j])) {
    	System.out.println("Key found: " +arr[j] );
        result = map.get(arr[j]);
        result.add(arr[j]);
        break;
      }
    }
    
    int[] res = new int[result.size()];
    for(int i=0; i< res.length;i++) {
      res[i] = result.get(i);
    }
    
    Arrays.sort(res);
    
    return res;
  }
  
  public static void main(String[] args) {

    int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
    int number = 20;
    
    int[] result = findArrayQuadruplet(arr, number);
    
    for(int i: result){
      System.out.print(i + ">>>");
    }
  }

}