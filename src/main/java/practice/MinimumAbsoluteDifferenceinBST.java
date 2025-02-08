package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumAbsoluteDifferenceinBST {
     static int min=Integer.MAX_VALUE;
     static int prev=-1;

    public static int getMinimumDifference(TreeNode root){

        return min;

    }
    public static void traversal(TreeNode root){
        if(root==null)
            return;
        traversal(root.left);
        if(prev>=0)
            min=Math.min(min,root.val-prev);
        else{
            if(root.left!=null)
                min=Math.min(min,Math.abs(root.val-root.left.val));
            if(root.right!=null)
                min=Math.min(min,Math.abs(root.right.val-root.val));
        }
        prev=root.val;
        traversal(root.right);

    }
    //Inorder traversal
    public static int getMinimumDifference2(TreeNode root){

        List<Integer> values=new ArrayList<Integer>();
        traversal2(root,values);
        int minDifference = Integer.MAX_VALUE;
        for(int i =1;i<values.size();i++){
            minDifference=Math.min(minDifference,values.get(i)-values.get(i-1));
        }

        return minDifference;
    }
    public static void traversal2(TreeNode root,List<Integer> values){
        if(root.left!=null)
            traversal2(root.left,values);
        values.add(root.val);
        if(root.right!=null)
            traversal2(root.right,values);
    }
    public static int getMinimumDifference1(TreeNode root) {
        List<Integer> values=new ArrayList<Integer>();
        addAllValuesToList(root,values);
        values =values.stream().sorted().collect(Collectors.toList());

      /*  for(int i =1;i<values.size();i++){
            diffs.add(Math.abs(values.get(i-1)-values.get(i)));
        }
        diffs= diffs.stream().sorted().collect(Collectors.toList());*/
        int minDifference = Integer.MAX_VALUE;
        for(int i =1;i<values.size();i++){
            minDifference=Math.min(minDifference,values.get(i)-values.get(i-1));
        }

        return minDifference;

    }
    public static void addAllValuesToList(TreeNode root,List<Integer> values){
        if( root!=null){
            values.add(root.val);
            addAllValuesToList(root.left,values);
            addAllValuesToList(root.right,values);
        }
    }
}
