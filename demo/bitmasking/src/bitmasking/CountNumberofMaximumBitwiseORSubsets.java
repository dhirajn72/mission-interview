package bitmasking;

import java.util.*;

public class CountNumberofMaximumBitwiseORSubsets {
    List<List<Integer>> lists=new ArrayList<>();
    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums,new ArrayList<>(),0);
        Map<Integer,Integer> map=new TreeMap<>();
        int max=0;
        for(List<Integer> list:lists){
            int val=0;
            for(int e:list){
                val=val|e;
            }
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);    
            }
            else{
                map.put(val,1);
            }
            
            max=Math.max(max,val);
        }
        return map.get(max);
    }
    void backtrack(int[] nums,List<Integer> list,int start){
        lists.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}

