class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {

        int total=0;
        for(int e:arr){
            total+=e;
        }
        if(total%3!=0)
            return false;

        if(arr.length%2==0 && total==0)
            return true;

        List<Integer> list=new ArrayList<>();
        int index=0;
        int partition=total/3;
        int sum=0;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        while(index<arr.length){
            list.add(arr[index]);
            sum+=arr[index];
            if(sum==partition){
                result.add(new ArrayList<>(list));
                list.clear();
                count.add(1);
                sum=0;
            }
            index++;
        }
        int num=0;
        for(List<Integer> l:result){
            num+=l.size();
        }
        if(num!=arr.length)
            return false;
        System.out.println(result);

        return count.size()==3 ? true:false;
    }
}
/*

[0,2,1,-6,6,-7,9,1,2,0,1]
[0,2,1,-6,6,7,9,-1,2,0,1]
[3,3,6,5,-2,2,5,1,-9,4]
[0,0,0,0]
[0,0,0]
[1,-1,1,-1]

*/
