package practice;

public class LowestCommonAncestorofABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    /*    if(p==q){
            return p;
        }
        else if(p.left==q||p.right==q)
            return p;
        else if(q.left==p||q.right==p)
            return q;
        else {

        }*/
        if(root==null)
            return null;
        if(root.val==p.val||root.val==q.val)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
       /* if(left!=null &&right!=null)
            return root;

        return left==null?right:left;*/

        if(right==null){
            return left;
        }
        if(left==null){
            return right;
        }
        return root;
    }
}
