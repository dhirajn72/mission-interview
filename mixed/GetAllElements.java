class Solution {
    int[] arr=null;
    Stack<TreeNode> s=new Stack<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        arr=new int[getTreeSize(root1)+getTreeSize(root2)];
        int index=0;
        s.push(root1);
        preOrder(root1);
        s.push(root2);
        preOrder(root2);
        mergeSort(arr,0,arr.length-1);
        List<Integer> result=new ArrayList<>();
        for(int i:arr)
            result.add(i);
        return result;

    }
    void mergeSort(int[] arr,int low,int high){
       if(low<high){
           int mid=(low+high)/2;
           mergeSort(arr,low,mid);
           mergeSort(arr,mid+1,high);
           merge(arr,low,mid,high);
       }
    }
    void merge(int[] arr,int low,int mid, int high){
        int n1=mid-low+1;
        int n2=high-mid;

        int[] leftArray=new int[n1];
        int[] rightArray=new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j]=arr[mid+1+j];
        }

        int i=0,j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(leftArray[i]<rightArray[j]){
                arr[k]=leftArray[i];
                i++;
            }
            else{
                arr[k]=rightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=rightArray[j];
            j++;
            k++;
        }
    }

    void preOrder(TreeNode root){
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                arr[index++]=temp.val;
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
        }
    }

    int getTreeSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getTreeSize(root.left);
        size+=getTreeSize(root.right);
        return size;
    }
}
