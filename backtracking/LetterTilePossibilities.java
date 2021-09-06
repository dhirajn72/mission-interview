class Solution {
    int result=0;
    public int numTilePossibilities(String tiles) {
        char[] arr=tiles.toCharArray();
        permutation(arr,0);
        return result;
    }
    void permutation(char[] arr,int i){
        if(i==arr.length){
            result++;
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(arr,i,j);
                permutation(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
