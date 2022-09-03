class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        Set<Integer> keys=new LinkedHashSet<>();

        int index=0;
        for(int e:arr){
            int ones=getOnes(e);
            if(map.get(ones)!=null){
                map.get(ones).add(e);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(e);
                map.put(ones,list);
            }
            keys.add(ones);
        }
        System.out.println(map);
        System.out.println(keys);
        int[] result=new int[arr.length];
        index=0;
        for(int e:keys){
            //Collections.sort(map.get(e));
            for(int i:map.get(e))
                result[index++]=i;
        }
        return result;
    }
    int getOnes(int n){
        int ones=0;
        while(n!=0){
            ones+=n%2;
            n=n/2;
        }
        return ones;
    }
}
