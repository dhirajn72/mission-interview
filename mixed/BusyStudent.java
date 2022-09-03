class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if(startTime==null||endTime==null)
            return 0;
        if(startTime.length!=endTime.length)
            return 0;
        int result=0;    
        for(int i=0;i<startTime.length;i++){
            int j=startTime[i];
            int k=endTime[i];
            for(int l=j;l<k;l++){
                if(l==queryTime)
                    result++;
            }
        }
        return result;
    }
}
