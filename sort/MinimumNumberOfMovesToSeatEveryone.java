class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        sort(seats,0,seats.length-1);
        sort(students,0,students.length-1);
        int moves=0;
        for(int i=0;i<seats.length;i++){
            moves+=Math.abs(seat[i]-students[i]);
        }
        return moves;
    }
    public static void sort(int[] arr,int low,int high){
        int i=low,j=high;
        int pivot=arr[(low+high)/2];

        while(i<=j){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        if(low<j){
            sort(arr,low,j);
        }
        if(i<high){
            sort(arr,i,high);
        }
    }

}
