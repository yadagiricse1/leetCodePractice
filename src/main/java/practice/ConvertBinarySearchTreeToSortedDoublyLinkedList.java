package practice;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    TreeNode first = null;
    TreeNode last = null;


    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;

        }

        helper(root);
        last.right=first;
        first.left=last;


        return first;
    }
    public void helper(TreeNode node) {
        if(node!=null){
            helper(node.left);
            if(last!=null){
                last.right=node;
                node.left = last;
            } else {
                first =node;
            }
            last = node;
            helper(node.right);
        }
    }
}
