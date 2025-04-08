package practice;

public class DiameterofBinaryTree {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinaryTree(root);
      return max-1;
    }

    private int heightOfBinaryTree(TreeNode root) {
        if(root!=null){
            int left = heightOfBinaryTree(root.left)+1;
            int right = heightOfBinaryTree(root.right)+1;
            max =Math.max(left+right-1,max);
            return Math.max(left,right);
        } else{
            return 0;
        }
    }
}
