package bitmasking;
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] arr=new int[nums.length+1];
        int[] res=new int[2];
        for(int e:nums){
            if(arr[e]!=0){
                res[0]=e;
            }
            else{
                arr[e]=e;
            }
        }
        for(int i=1;i<=arr.length;i++){
            if(arr[i]==0){
                res[1]=i;
                break;
            }
        }
        return res;
    }
}
