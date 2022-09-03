import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReduceArraySize {

		static public int minSetSize(int[] arr) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < arr.length; i++){
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
			int[] values = new int[map.keySet().size()];
			int index = 0;
			for(int key : map.keySet()){
				values[index++] = map.get(key);
			}
			Arrays.sort(values);
			int i = 0, sum = 0;
			for(i = values.length - 1 ; i >= 0; i--){
				sum += values[i];
				if(sum >= arr.length / 2)
					break;
			}
			return values.length - i;
		}

	public static void main(String[] args) {
		int[] arr = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(arr));
	}
}
