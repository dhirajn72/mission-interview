
class Solution {
    public int[] countBits(int num) {
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<=num;i++){
            list.add(getOnes(i));
        }
        int[] result=new int[list.size()];
        int index=0;
        for(int i:list){
            result[index++]=i;
        }
        return result;


    }
    
    int getOnes(int i){
        int ones=0;
        while(i>0){
            ones=ones+ i%2;
            i=i/2;
        }
        return ones;
    }

}

