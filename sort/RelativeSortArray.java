class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int index=0;
        for(int i=0;i<arr2.length;i++){
            if(map.get(arr2[i])==null)
                continue;
            int n=map.get(arr2[i]);
            for(int j=0;j<n;j++){
                arr1[index++]=arr2[i];
            }
            if(n!=0){
                map.remove(arr2[i]);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
            int n=map.get(key);
            for(int i=0;i<n;i++)
                list.add(key);
        }
        Collections.sort(list);
        for(int val:list){
            arr1[index++]=val;
        }
        return arr1;
    }
}
