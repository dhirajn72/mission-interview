class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=arr[i];
        }
        Arrays.sort(result);
        Map<Integer,Integer> map=new HashMap<>();
        int index=1;
        for(int val:result){
            if(!map.containsKey(val))
                map.put(val,index++);
        }
        for(int i=0;i<arr.length;i++){
            result[i]=map.get(arr[i]);
        }
        return result;
    }
}
