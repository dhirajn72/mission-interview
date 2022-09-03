class Solution {
    public int nthUglyNumber(int n) {
      if (n==0||n<0)
            return 0;
        int i2=0,i3=0,i5=0,ni2=2,ni3=3,ni5=5;
        int[] arr=new int[n];
        arr[0]=1;
        for (int i = 1; i < n; i++) {
            int next=Math.min(ni2,Math.min(ni3,ni5));
            arr[i]=next;
            if (next==ni2){
                i2++;
                ni2=arr[i2]*2;
            }
            if (next==ni3){
                i3++;
                ni3=arr[i3]*3;
            }
            if (next==ni5){
                i5++;
                ni5=arr[i5]*5;
            }
        }
        return arr[n-1];
    }
}
