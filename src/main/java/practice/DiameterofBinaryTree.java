package practice;

public class DiameterofBinaryTree {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinaryTree(root);
      return max;
    }

    private int heightOfBinaryTree(TreeNode root) {
        if(root!=null){
            int left = heightOfBinaryTree(root.left);
            int right = heightOfBinaryTree(root.right);
            max =Math.max(left+right,max);
            return Math.max(left,right)+1;
        } else{
            return 0;
        }
    }
}
