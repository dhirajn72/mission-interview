class Solution {
    public int numOfSubarrays(int[] arr) {
        if(arr==null||arr.length==0)
            return 0;

        int count=0;
        for(int e:arr){
            if(e%2!=0)
                count++;
        }
        if(count==0)
            return 0;

        List<List<Integer>> list=new ArrayList<>();
        int n=arr.length;      
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                List<Integer> sub=new ArrayList<>();
                for(int k=i;k<=j;k++)
                    sub.add(arr[k]);
                list.add(sub);
            }
        }
        int result=0;
        List<Integer> res=new ArrayList<>();
        for(List<Integer> subList:list){
            int sum=0;
            for(int e:subList){
                sum+=e;
            }
            if(sum%2!=0)
                result++;
        }
        return result;
        
    }
}
