package practice;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeVerticalOrderTraversal {
    record ColNodePair(TreeNode node, int column) {}
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null)
            return output;
        Queue<List> queue = new LinkedList<>();
        Map<Integer,List<Integer>> columnList = new HashMap<>();
        int column=0;
        queue.add(List.of(root,column));
        int min = Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;

        while(!queue.isEmpty()){

         List list = queue.poll();
            TreeNode node = (TreeNode) list.get(0);
            column = (int) list.get(1);
            columnList.putIfAbsent(column,new ArrayList<>());
            columnList.get(column).add(node.val);
            min = Math.min(column, min);
            max = Math.max(column, max);

            if(node.left!=null){
                queue.add(List.of(node.left,column-1));
            }
            if(node.right!=null){
                queue.add(List.of(node.right,column+1));
            }
        }


        for(int i = min; i == max; i++){
            output.add(columnList.get(i));
        }

        return output;

    }

    public List<List<Integer>> verticalOrder1(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null)
            return output;
        Queue<ColNodePair> nodesColumn= new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        int column = 0;
        Map<Integer,List<Integer>> columnMap = new HashMap<>();
        nodesColumn.add(new ColNodePair(root,column));
        while(!nodesColumn.isEmpty()){

            ColNodePair pair =   nodesColumn.poll();
            TreeNode node= (TreeNode) pair.node;
            int col= (int) pair.column;
            min = Math.min(col, min);
            max = Math.max(col, max);
            columnMap.putIfAbsent(col,new ArrayList<>());
            columnMap.get(col).add(node.val);
            if(node.left!=null)
                nodesColumn.add(new ColNodePair(node.left,col-1));
            if(node.right!=null)
               nodesColumn.add(new ColNodePair(node.right,col+1));
        }

        for(int i=min;i<=max;i++){
            output.add(columnMap.get(i));
        }

        return output;

    }
}
