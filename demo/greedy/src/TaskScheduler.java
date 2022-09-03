import java.util.Arrays;

public class TaskScheduler {
		static public int leastInterval(char[] tasks, int n) {
            int[] char_map = new int[26];
            for(char c : tasks){
                char_map[c-'A']++;
            }
            Arrays.sort(char_map);
            int max_val = char_map[25]-1;
            int idle_slot =  max_val * n;
            for(int i = 24; i >= 0; i--){
                idle_slot -= Math.min(char_map[i],max_val);


            }
            return idle_slot > 0 ? idle_slot + tasks.length : tasks.length;
		}

	public static void main(String[] args) {
		char[] tasks={'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks,n));

	}

	/*
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
	 */
}

