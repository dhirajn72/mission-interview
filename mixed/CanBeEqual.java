class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target==null||arr==null)
            return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        int i=0;
        while(i<target.length && i<arr.length && target[i]==arr[i]){
           i++;
        }
        return i>=arr.length;
    }
}
