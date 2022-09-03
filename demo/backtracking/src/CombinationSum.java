import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},  7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> integers=new ArrayList<>();
        for (int i:candidates)
            integers.add(i);

        List<List<Integer>> resList=new ArrayList<>();
        _combination(integers,target,resList,new ArrayList<>());
        return resList;
    }

    private static void _combination(List<Integer> integers, int target, List<List<Integer>> resList, ArrayList<Integer> partial) {
        int sum=0;
        for (int i:partial)
            sum+=i;
        if (sum==target){
            resList.add(new ArrayList<>(partial));
            return;
        }
        if (sum>target)
            return;
        for (int i = 0; i < integers.size(); i++) {
            ArrayList<Integer> remaining=new ArrayList<>();
            int first=integers.get(i);
            for (int j = i; j < integers.size(); j++) {
                remaining.add(integers.get(j));
            }
            ArrayList<Integer> partial_res=new ArrayList<>(partial);
            partial_res.add(first);
            _combination(remaining,target,resList,partial_res);
        }
    }
}
