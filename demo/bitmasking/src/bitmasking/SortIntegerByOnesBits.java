package bitmasking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortIntegerByOnesBits {
	public int[] sortByBits(int[] arr) {
		Map<Integer,List<Integer>> map=new TreeMap<>();
		for(int val:arr){
			int key=getOnesBit(val);
			if(map.containsKey(key)){
				map.get(key).add(val);
			}
			else{
				List<Integer> list=new ArrayList<>();
				list.add(val);
				map.put(key,list);
			}
		}
		int index=0;
		for(int key:map.keySet()){
			List<Integer> list=map.get(key);
			Collections.sort(list);
			for(int val:list) {
				arr[index++] = val;
			}
		}
		return arr;
	}
	int getOnesBit(int n){
		int res=0;
		while(n!=0){
			int remainder=n%2;
			if(remainder==1)
				res++;
			n=n/2;
		}
		return res;
	}
}
