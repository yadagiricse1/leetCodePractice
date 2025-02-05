package practice;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
     if(root==null){
            return false;
        } else if(root!=null && root.val==targetSum  && root.left==null &&root.right==null){
            return true;
        }
        else {
            targetSum=targetSum-root.val;
            return hasPathSum(root.left,targetSum)||hasPathSum(root.right, targetSum);
        }
    }
}
