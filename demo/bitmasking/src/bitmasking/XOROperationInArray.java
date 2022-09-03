package bitmasking;

public class XOROperationInArray {
	public int xorOperation(int n, int start) {
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=start+2*i;
		}
		int res=0;
		for(int val:nums){
			res=res^val;
		}
		return res;
	}
	public static void main(String[] args){
		int swich = 1;
		for(int i = 0; i < 5 ; i++){
			System.out.println( swich = swich ^ 1);
		}
	}
}
