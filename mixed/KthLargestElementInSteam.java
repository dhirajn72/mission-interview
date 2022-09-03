class KthLargest {
    Integer[] arr;

    public KthLargest(int k, int[] nums) {
        arr=new Integer[nums.length];
        int index=0;
        for(int e:nums){
            arr[index++]=e;
        }
    }
    
    public int add(int val) {
        int res=arr[val-1];
        Integer[] temp=new Integer[arr.length+1];
        int index=0;
        for(int e:arr){
            temp[index++]=e;
        }
        temp[index]=val;
        arr=temp;
        Arrays.sort(arr,Collections.reverseOrder());
        return res;

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

