class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(root==null)
            return result;
        permute(nums,0);
        return result;
    }

    void permute(int[] arr,int i){
        if(i==arr.length){
            List<Integer> list=new ArrayList<>();
            for(int j:arr)
                list.add(j);
            result.add(list);
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(arr,i,j);
                permute(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
