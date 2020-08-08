class Solution {
    public int maximum69Number (int num) {
        if(num==0)
            return 0;
        Strint s=String.valueOf(num);
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='6'){
                arr[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
