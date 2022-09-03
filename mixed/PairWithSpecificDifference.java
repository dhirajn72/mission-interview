import java.util.*;
class PairWithSpecificDifference {
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        // your code goes here
        List<int[]> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(int e:arr)
            list.add(e);
        findPairs(list,new ArrayList<>(),k,result);
        int[][] finalResult=new int[result.size()][2];
        int index=0;
        for(int[] rows:result){
            finalResult[index++]=rows;
           // System.out.println(Arrays.toString(rows));
        }
        return finalResult;
    }
    static void findPairs(List<Integer> list,List<Integer> partial,int k,List<int[]> result){
        if(partial.size()==2){
            //System.out.println(partial);
            if(partial.get(0)-partial.get(1)==k){
                result.add(new int[] {partial.get(0),partial.get(1)});
            }
            else
                return;
        }
        else if(partial.size()>2)
            return ;
        else{
            for(int i=0;i<list.size();i++){
                ArrayList<Integer> remaining=new ArrayList<>();
                int n=list.get(i);
                for(int j=0;j<list.size();j++ ){
                    remaining.add(list.get(j));
                }
                ArrayList<Integer> partial_res=new ArrayList<>(partial);
                partial_res.add(n);
                findPairs(remaining,partial_res,k,result);
            }
        }

    }

    public static void main(String[] args){
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{0, -1, -2, 2, 1},1)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{1,5,11,7},4)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{4,1},3)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{1,5,11,7},6)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{1,5,11,7},10)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{0,-1,-2,2,1},1)));
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{1,7,5,3,32,17,12}, 17)));

    }
}
