class Solution {
    public String truncateSentence(String s, int k) {

        String[] arr=s.split(" ");
        if(arr.length<=k)
            return s;

        StringBuilder sb=new StringBuilder();
        int index=0;
        while(k-->0){
            sb.append(arr[index++]).append(" ");
        }
        return sb.toString().trim();
    }
}
