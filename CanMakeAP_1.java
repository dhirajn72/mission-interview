class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr==null||arr.length==0)
            return false;
        if(arr.length==1)
            return false;
        if(arr.length==2)
            return true;
        Arrays.sort(arr);
        for(int i=2;i<arr.length;i++){
            if(! (arr[i]-arr[i-1]==arr[i-1]-arr[i-2])){
                return false;
            }
        }
        return true;
    }
}
