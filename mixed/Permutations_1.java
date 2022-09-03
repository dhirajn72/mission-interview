class Solution {
    static List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
       if(nums==null)
           return result;
        permute(nums,0);
        return result;
    }
    static void permute(int[] arr, int i){
        if(arr.length==i){
            List<Integer> list=new ArrayList<>();
            for(int k:arr){
                list.add(k);
            }
            result.add(list);
            System.out.println(Arrays.toString(arr));
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(i,j,arr);
                permute(arr,i+1);
                swap(i,j,arr);
            }
        }

    }

    static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
