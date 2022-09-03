import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizeToTheHalf{
    class Solution {
        int result = Integer.MAX_VALUE;

        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int val : arr) {
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }
            int[] values = new int[map.size()];
            int index = 0;
            for (int key : map.keySet()) {
                values[index++] = map.get(key);
            }
            quickSort(values, 0, values.length - 1);
            int i = 0, sum = 0;
            for (i = values.length - 1; i >= 0; i--) {
                sum += values[i];
                if (sum >= arr.length / 2) {
                    break;
                }
            }
            return values.length - i;
            //backtrack(values,new ArrayList<>(),0,0,arr.length/2);
            //return result==Integer.MAX_VALUE ? 0 : result;
        }

        void backtrack(int[] nums, List<Integer> list, int start, int sum, int target) {
            if (sum >= target) {
                result = Math.min(result, list.size());
            } else {
                for (int i = start; i < nums.length; i++) {
                    list.add(nums[i]);
                    backtrack(nums, list, i + 1, sum + nums[i], target);
                    list.remove(list.size() - 1);
                }
            }
        }

        void quickSort(int[] nums, int low, int high) {
            int i = low, j = high;
            int pivot = nums[(low + high) / 2];
            while (i <= j) {
                while (nums[i] < pivot)
                    i++;
                while (nums[j] > pivot)
                    j--;
                if (i <= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }
            if (low < j)
                quickSort(nums, low, j);
            if (i < high)
                quickSort(nums, i, high);
        }
    }
}
