class Solution {
    public void reverseString(char[] s) {
        reverse(s,0);
    }
    void reverse(char[] arr,int index){
        if(index<arr.length){
            char temp=arr[index];
            reverse(arr,index+1);
            arr[arr.length-index]=temp;
        }
    }
}
