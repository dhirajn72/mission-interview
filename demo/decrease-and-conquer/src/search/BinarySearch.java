package search;
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(arr,1));
		System.out.println(binarySearch(arr,2));
		System.out.println(binarySearch(arr,3));
		System.out.println(binarySearch(arr,4));
		System.out.println(binarySearch(arr,5));
		System.out.println(binarySearch(arr,6));
		System.out.println(binarySearch(arr,7));
		System.out.println(binarySearch(arr,8));
		System.out.println(binarySearch(arr,9));
		System.out.println(binarySearch(arr,10));
		System.out.println("-----------------");
		System.out.println(binarySearchIterative(arr,0,arr.length-1,1));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,2));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,3));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,4));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,5));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,6));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,7));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,8));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,9));
		System.out.println(binarySearchIterative(arr,0,arr.length-1,10));
	}

	static int binarySearch(int[] arr,int key){
		return search(arr,key,0,arr.length-1);
	}

	private static int search(int[] arr, int key, int low, int high) {
		if(low<=high){
			int mid=(low+high)/2;
			if(arr[mid]==key)
				return mid;
			if(key<arr[mid])
				return search(arr,key,low,mid-1);
			return search(arr,key,mid+1,high);
		}
		return -1;
	}
	static int binarySearchIterative(int[] arr,int low,int high,int key){
		while(low<=high){
			int mid=(low+high)/2;
			if(arr[mid]==key)
				return mid;
			if(key<arr[mid])
				return binarySearchIterative(arr,low,mid-1,key);
			else
				return binarySearchIterative(arr,mid+1,high,key);
		}
		return -1;
	}
}