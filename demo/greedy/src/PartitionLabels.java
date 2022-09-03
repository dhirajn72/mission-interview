import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	static public List<Integer> partitionLabels(String s) {
		if(s == null || s.length() == 0){
			return null;
		}

		int[] indices = new int[26];
		for(int i = 0; i < s.length(); i++){
			indices[s.charAt(i) - 'a'] = i;
		}
		List<Integer> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		for(int i = 0; i < s.length(); i++){
			end = Math.max(end, indices[s.charAt(i) - 'a']);
			if(i == end){
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "ababcbacadefegdeahijhklij";
		System.out.println(partitionLabels(str));
	}
}
