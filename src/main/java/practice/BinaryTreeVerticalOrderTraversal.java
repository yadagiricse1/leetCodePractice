package practice;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> nodesColumn= new ArrayDeque<>();
        int column = 0;
        Map<Integer,List<Integer>> columnMap = new HashMap<>();
        nodesColumn.add(new Pair<>(root,column));
        while(!nodesColumn.isEmpty()){

         Pair pair =   nodesColumn.poll();
           TreeNode node= (TreeNode) pair.first;
           int col= (int) pair.second;
            columnMap.putIfAbsent(col,new ArrayList<>());
            columnMap.get(col).add(node.val);

            nodesColumn.add(new Pair<>(node.left,col-1));
            nodesColumn.add(new Pair<>(node.left,col+1));
        }
        List<Integer> columns=  new ArrayList<>(columnMap.keySet()) ;
        Collections.sort(columns);
        for(int col:columns){
            output.add(columnMap.get(col));
        }

        return output;

    }
}
