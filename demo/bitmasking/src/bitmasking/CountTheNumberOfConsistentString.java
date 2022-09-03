package bitmasking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountTheNumberOfConsistentString {
	public int countConsistentStrings(String allowed, String[] words) {
		Set<Character> charSet=new HashSet<>();
		for(char c:allowed.toCharArray()){
			charSet.add(c);
		}
		int res=0;
		for(String str:words){
			boolean flag=true;
			for(char c:str.toCharArray()){
				if(!charSet.contains(c)) {
					flag = false;
					break;
				}
			}
			if(flag)
				res++;
		}
		return res;
	}
}
