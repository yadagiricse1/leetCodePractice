package practice;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root!=null){
             return isMirror(root,root);
        } else
            return true;
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1==null &&root2==null)
            return true;
        else if(root1==null||root2==null)
            return false;
        else if(root1.val==root2.val){
            return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);

        } else{
            return false;
        }
    }
}
