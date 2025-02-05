package practice;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    //Iterative
    public TreeNode invertTree1(TreeNode root){
        if(root==null)
            return null;
        Queue<TreeNode> trees=new LinkedList<TreeNode>();
        trees.add(root);
        while(!trees.isEmpty()){

            TreeNode current = trees.poll();
            TreeNode left =current.left;
            current.left=current.right;
            current.right=left;
            if(current.left!=null)
                trees.add(current.left);
            if(current.right!=null)
                trees.add(current.right);
        }
      return root;
    }

    //Recursive
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){

            TreeNode left = invertTree(root.left);
            root.left= invertTree(root.right);
            root.right=left;
        }
        return root;
    }
}
