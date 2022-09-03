public class BinarySearch{
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr,12));
    }
    static int search(int[] arr,int key){
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key)
                return arr[mid];
            else if(arr[mid]<key)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;

    }

}
