import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    // your code goes here
    int len = arr.length;
    Map<Integer, Integer> m = new HashMap<>();
    Map<Integer, int[]> map = new TreeMap<>();
    if(len<2)
      return new int[0][0];
    
    for(int i=0;i<len;i++){
      if(m.containsKey(arr[i]-k)){
        map.put(m.get(arr[i]-k), new int[]{arr[i], arr[m.get(arr[i]-k)]});
      }
      if(m.containsKey(arr[i]+k)){
        map.put(i, new int[]{arr[m.get(arr[i]+k)], arr[i]});
      }
        m.put(arr[i],i);
    }
    
    int[][] result = new int[map.size()][2];
    int i=0;
    for(Map.Entry<Integer, int[]> e : map.entrySet()){
      result[i++]=e.getValue();
    }
    
    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[]{0, -1, -2, 2, 1};
    System.out.println(Arrays.deepToString(findPairsWithGivenDifference(a,1)));
  }

}




/*
https://www.linkedin.com/in/amit-kumar-4ba20845/
[0, -1, -2, 2, 1]


[[1, 0], [0, -1], [-1, -2], [2, 1]]

[0, -1 ,2, 2 ,1]
0,

[1,1] = 0

[1, 0], x-y
[0, -1]


[[1, 0], [0, -1], [-1, -2], [2, 1]]

[1,   0], 
[0,  -1], 
[-1, -2], 
[2,   1]


*/
