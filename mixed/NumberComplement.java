class Solution {
    public int findComplement(int num) {
        int binary=getBinary(num);
        return binary;
    }

    int getBinary(int n){
        int[] binary=new int[40];
        int index=0;
        while(n>0){
            binary[index++]=n%2;
            n=n/2;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=index-1;i>=0;i--)
            sb.append(binary[i]==0?1:0);
        //This piece of shit works for small input.
        /*int result=0;
          while(val>0){
          int temp=val%10;
          result+=temp*Math.pow(2,n++);
          val=val/10;
          }
          return result;    
         */
        index=0;
        int result=0;
        for(int i=sb.length()-1;i>=0;i--){
            result+= Integer.valueOf(sb.charAt(i)+"")*Math.pow(2,index++);
        }
        return result;
    }
}
