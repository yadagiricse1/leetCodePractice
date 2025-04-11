package practice;

import java.util.*;

public class BinaryTreeRightSideView {
    Map<Integer,List<Integer>> levelList = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        addLevelElements(root,0);
        List<Integer> results = new ArrayList<>();
        int size = levelList.size();
        for(int i=0;i<size;i++){
          int levelSize = levelList.get(i).size();
            results.add(levelList.get(i).get(levelSize-1));
        }
        return results;
    }
    public void addLevelElements(TreeNode root, int level){
        if(root!=null){
            if(!levelList.containsKey(level)){
                levelList.put(level,new ArrayList<>()) ;
            }
            levelList.get(level).add(root.val);
            if(root.left!=null){
                addLevelElements(root.left,level+1);
            }
            if(root.right!=null){
                addLevelElements(root.right,level+1);
            }
        }
    }
}
