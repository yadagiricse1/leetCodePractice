package practice;

import java.util.*;

public class AverageofLevelsinBinaryTree {
    //breadth first approach
    public static List<Double> averageOfLevels(TreeNode root){
        List<Double> results= new ArrayList<>();
        if(root==null)
            return results;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            long sum=0;
            int count=0;
            Queue<TreeNode> temp= new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node =  queue.remove();
                sum+=node.val;
                count++;
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            results.add(sum*1.0/count);
            queue=temp;
        }
        return results;
    }
    public static List<Double> averageOfLevels1(TreeNode root) {
        List<Double> results= new ArrayList<>();
        if(root==null)
            return results;
        Map<Integer, List<Integer>> levelNodes=new HashMap<>();
        levelAddNodes(root,1,levelNodes);

        for(Map.Entry<Integer, List<Integer>> entry:levelNodes.entrySet()){
            double sum=0.0;
           // entry.getValue().stream()
            for(int i:entry.getValue()){
                sum+=i;
            }
            results.add(sum/entry.getValue().size());
        }
        return results;
    }
    public static void levelAddNodes(TreeNode root,int level,Map<Integer, List<Integer>> levelNodes){

        if(root!=null){
            List<Integer> nodes = levelNodes.getOrDefault(level,new ArrayList<Integer>());
            nodes.add(root.val);
            levelNodes.put(level,nodes);
            if(root.left!=null){
                levelAddNodes(root.left,level+1,levelNodes);
            }
            if(root.right!=null){
                levelAddNodes(root.right,level+1,levelNodes);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(averageOfLevels(root));

        TreeNode root1= new TreeNode(3);
        root1.left=new TreeNode(9);
        root1.right=new TreeNode(20);
        root1.left.left=new TreeNode(15);
        root1.left.right=new TreeNode(7);
        System.out.println(averageOfLevels(root1));


    }
}
