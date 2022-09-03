import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling{
    static int result=0;
    /*static public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n];
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
        	jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b)->(a[1] - b[1]));
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(jobs[i][2], dp[i - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i][2]);
                    break;
                }
            }
        }
        int max = 0;
        for (int val : dp) {
            max = Math.max(val, max);
        }
        return max;
    }

    static class Job {
        int start, end, profit;

        public Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    } */
    static public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }

        int dp[] = new int[jobs.length];
        Arrays.sort(jobs, (a,b)->(a.end - b.end));

        dp[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++){
            dp[i] = Math.max(jobs[i].profit, dp[i-1]);
            for(int j = i-1; j >= 0; j--){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int val : dp) {
            max = Math.max(val, max);
        }
        return max;
    }

    static class Job {
        int start, end, profit;

        public Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }
    public static void main(String[] args){
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        System.out.println(jobScheduling(startTime,endTime,profit));
        new TreeMap<>();
    }
}
