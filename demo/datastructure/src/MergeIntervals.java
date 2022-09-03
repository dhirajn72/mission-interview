import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		merge(intervals);
		System.out.println(Arrays.deepToString(intervals));
	}
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) {
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}
