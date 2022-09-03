class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Map<Integer,List<Integer>> numsCount=new TreeMap<>();
        for(int key:map.keySet()){
            int val=map.get(key);
            if(numsCount.get(val)!=null){
                List<Integer> list=numsCount.get(val);
                list.add(key);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(key);
                numsCount.put(val,list);
            }
        }

        //Heap heap=new Heap(nums.length);
        int[] result=new int[nums.length];
        int index=0;
        for(int key:numsCount.keySet()){
            List<Integer> list=numsCount.get(key);
            Collections.sort(list);
            System.out.println(list);
            for(int i=list.size()-1;i>=0;i--){
                result[index++]=list.get(i);
            }
        }
       return result;
    }
}
