package practice;
import java.util.*;

public class AllNodesDistanceKinBinaryTree {
   static  Map<TreeNode,TreeNode> childParent = new HashMap<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addParent(root,null);

        List<Integer> results = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfsDistanceK(target,visited,k,results);

        return results;

    }

    private static  void  addParent(TreeNode root, TreeNode parent) {
        if(root!=null){
            childParent.put(root,parent);
            addParent(root.left,root);
            addParent(root.right,root);
        }
    }

    private static  void dfsDistanceK(TreeNode current,Set<TreeNode> visited,int distance ,List<Integer> results){
        if(current==null||visited.contains(current))
            return;
        visited.add(current);
        if(distance==0){
            results.add(current.val);
            return;
        }
        dfsDistanceK(childParent.get(current),visited,distance-1,results);
        dfsDistanceK(current.left,visited,distance-1,results);
        dfsDistanceK(current.right,visited,distance-1,results);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode rootLeft=new TreeNode(5);
        TreeNode rootRight=new TreeNode(1);
        root.left=rootLeft;
        root.right=rootRight;
        rootRight.left= new TreeNode(0);
        rootRight.right= new TreeNode(8);
        rootLeft.left= new TreeNode(6);
        TreeNode targetRightChild=new TreeNode(2);
        targetRightChild.left=new TreeNode(7);
        targetRightChild.right=new TreeNode(4);
        rootLeft.right=targetRightChild;
        List<Integer> results = distanceK(root, new TreeNode(5),2);
        System.out.println(results);
    }
}
