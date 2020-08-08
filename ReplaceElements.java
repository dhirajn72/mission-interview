class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result=new int[arr.length];
        if(arr==null)
            return result;
        
        int max=-1;
        for(int i=arr.length-1;i>=0;i++){
            int newMax=Math.max(max,arr[i]);
            arr[i]=max;
            max=newMax;
        }
        return arr;
    }
}

