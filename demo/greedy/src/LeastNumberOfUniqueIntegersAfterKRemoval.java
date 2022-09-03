import java.util.HashSet;
import java.util.Set;

public class LeastNumberOfUniqueIntegersAfterKRemoval {
	class Solution {
		public int findLeastNumOfUniqueInts(int[] arr, int k) {
			Heap heap=new Heap(arr.length);
			for(int e:arr)
				heap.insert(e);
			while(k-->0) {
				heap.remove();
			}
			return heap.size();
		}
		class Heap {
			Node[] arr;
			int max;
			int curr;
			Set<Integer> set;
			Heap(int max) {
				this.max=max;
				arr=new Node[max];
				set=new HashSet<>();
			}
			int size() {
				return curr;
			}
			void insert(int val) {
				if(curr==max)
					return;
				if(!set.contains(val)) {
					Node node = new Node(val);
					arr[curr] = node;
					trickleUp(curr++);
				}
			}
			void trickleUp(int index) {
				int parent=(index-1)/2;
				Node bottom=arr[index];
				while(index>0 && arr[parent].val < bottom.val){
					arr[index]=arr[parent];
					index=parent;
					parent=(parent-1)/2;
				}
				arr[index]=bottom;
			}
			int remove(){
				if(curr==0)
					return -1;
				Node top=arr[0];
				arr[0]=arr[--curr];
				arr[curr]=null;
				trickleDown(0);
				return top.val;
			}
			void trickleDown(int index) {
				int largeIndex=0;
				Node top=arr[index];
				while(index<curr/2){
					int leftIndex=2*index+1;
					int rightIndex=2*index+2;
					if(rightIndex<curr && arr[leftIndex].val< arr[rightIndex].val)
						largeIndex=rightIndex;
					else
						largeIndex=leftIndex;
					if(top.val>=arr[largeIndex].val) break;
					arr[index]=arr[largeIndex];
					index=largeIndex;
				}
				arr[index]=top;
			}
			class Node{
				int val;
				Node(int val){
					this.val=val;
				}
			}
		}
	}
}
