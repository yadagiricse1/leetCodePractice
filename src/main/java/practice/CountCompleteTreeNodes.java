package practice;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}
