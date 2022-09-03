class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr=new int[123];
        for(int i=97;i<=122;i++){
            arr[i]=1;
        }
        for(int i=0;i<sentence.length();i++){
            arr[sentence.charAt(i)]--;
        }
        for(int i=0;i<=122;i++)
            if(arr[i]==1)
                return false;

        return true;
        
    }
}
