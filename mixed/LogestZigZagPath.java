
int res=0;
public int longestZigZag(TreeNode root) {
   if(root==null)   
       return res;
   logestZigZagPath(root.left,0,true);
   logestZigZagPath(root.right,0,false);
   return res;
}

void logestZigZagPath(TreeNode root, int length,boolean isLeft){
   if(root==null)
      res=Math.max(res,length);
  else{
	if(isLeft){
      logestZigZagPath(root.right,length+1,false);
      logestZigZagPath(root.left,0,true);
   }
   else{
      logestZigZagPath(root.left,length+1,true);
      logestZigZagPath(root.right,0,false);
   }  

  }
 }
}
