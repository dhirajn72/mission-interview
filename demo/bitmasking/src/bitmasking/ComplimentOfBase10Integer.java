package bitmasking;

import java.util.ArrayList;
import java.util.List;

public class ComplimentOfBase10Integer {
	public int bitwiseComplement(int n) {
		List<Integer> list= new ArrayList<>();
		while(n!=0){
			int mod=n%2;
			int val=mod==0?1:0;
			list.add(val);
			n=n/2;
		}
		int pow=0;
		int res=0;
		for(int i=0;i<list.size();i++){
			res += list.get(i)*Math.pow(2,pow++);
		}
		return res;
	}
}
