class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()){
            return false;
        }
        char[] arr=s.toCharArray();
        char[] goalArr=goal.toCharArray();

        int n=arr.length;
        while(n-->0){
            char c=arr[0];
            for(int i=1;i<arr.length;i++){
                arr[i-1]=arr[i];
            }
            arr[arr.length-1]=c;
            if(new String(arr).equals(goal))
                return true;
        }
        return false;
    }
}
