package practice;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {
    static int min;
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Map<Integer,List<Integer>>>  verticalListMap = new HashMap<>();
        if(root!=null){
            min=0;
            verticalTraversal(root,verticalListMap, 0,0);

        }

        for(int count=0;count<verticalListMap.size();count++){
            List<Integer> values=new ArrayList<>();
            Map<Integer,List<Integer>> nums =  verticalListMap.get(min);
            nums.keySet();
            Set<Integer> sortedSet = new TreeSet<>(nums.keySet());
            for(int i:sortedSet){
                if(nums.get(i).size()>1)
                  Collections.sort(nums.get(i));
                values.addAll(nums.get(i));
            }
            results.add(values);
            min++;
        }
        return results;
    }

    private  static void verticalTraversal(TreeNode root, Map<Integer, Map<Integer,List<Integer>>>  verticalListMap, int x, int y){
        if(root!=null){
            if(!verticalListMap.containsKey(y)){
                Map<Integer,List<Integer>>sameLevelElements = new HashMap<>();
                sameLevelElements.put(x,new ArrayList<>());
                verticalListMap.put(y,sameLevelElements);
                if(y<min){
                    min=y;
                }

            } else {
                if(!verticalListMap.get(y).containsKey(x)){
                    verticalListMap.get(y).put(x, new ArrayList<>());
                }
            }

            verticalListMap.get(y).get(x).add(root.val);
            verticalTraversal(root.left,verticalListMap, x+1,y-1);
            verticalTraversal(root.right,verticalListMap, x+1,y+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root=  new TreeNode(3);
        root.left=new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.right =rootRight;
        rootRight.left = new TreeNode(15);
        rootRight.right = new TreeNode(7);
        System.out.println(verticalTraversal(root));


    }
}
