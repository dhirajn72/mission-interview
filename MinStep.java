class Solution {
    public int minSteps(String s, String t) {
        int[] arr=new int[123];
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)]= ++arr[t.charAt(i)];
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)]!=0){
                arr[s.charAt(i)]= --arr[s.charAt(i)];
            }
        }

        int count=0;
        for(int i:arr){
            if(i>0){
                count+=i;
            }
        }
        return count;
    }
} 
