package bitmasking;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetsXORTotals {
	static List<List<Integer>> res=new ArrayList<>();
	public static int subsetXORSum(int[] nums) {
		backtrack(nums,new ArrayList<>(),0);
        int result=0;
        System.out.println(res);
        for(List<Integer> list:res){
            int localRes=0;
            for(int val:list){
                localRes=localRes^val;
            }
            result+=localRes;
        }
		return result;
	}
	static void backtrack(int[] nums,List<Integer> list,int start){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
        }
	}
	public static void main(String[] args){
		int[] nums={1,2,3};
		System.out.println(subsetXORSum(nums));
	}
}
