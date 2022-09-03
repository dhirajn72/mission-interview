import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr={7,8,9,0,1,2,3,6};
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void sort(int[] arr,int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	static void merge(int[] arr,int low,int mid,int high){
		int n1=mid-low+1;
		int n2=high-mid;

		int[] leftArr=new int[n1];
		int[] rightArr=new int[n2];

		for(int i=0;i<n1;i++){
			leftArr[i]=arr[low+i];
		}
		for(int j=0;j<n2;j++){
			rightArr[j]=arr[mid+1+j];
		}
		int i=0,j=0;
		int k=low;
		while (i<n1 && j<n2){
			if(leftArr[i]<rightArr[j]){
				arr[k]=leftArr[i];
				i++;
			}
			else{
				arr[k]=rightArr[j];
				j++;
			}
			k++;
		}
		while (i<n1){
			arr[k]=leftArr[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k]=rightArr[j];
			j++;
			k++;
		}
	}
}
