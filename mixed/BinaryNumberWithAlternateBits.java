class Solution {
    public boolean hasAlternatingBits(int n) {
        int[] binary=new int[20];
        int index=0;
        while(n>0){
            binary[index++]=n%2;
            n=n/2;
        }
        for(int i=1;i<index;i++){
            if(binary[i-1]==binary[i])
                return false;
        }
        return true;
    }
}
