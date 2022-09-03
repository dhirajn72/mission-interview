class Solution {
    int max=Integer.MIN_VALUE;
    public int maximumSum(int[] arr) {
        if(arr==null||arr.length==0)
            return max;
        int n=arr.length;
        for(int i=0;i<n;i++)
            max=Math.max(max,arr[i]);

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                List<Integer> list=new ArrayList<>();
                for(int k=i;k<=j;k++){
                    list.add(arr[k]);
                }
                int sum=0;
                for(int l=0;l<list.size();l++){
                    for(int m=0;m<list.size();m++){
                        if(m==l)
                            continue;
                        sum+=list.get(m);
                    }

                }
                max=Math.max(max,sum);
                System.out.println(list);
            }
        }
        return max;
    }
}
