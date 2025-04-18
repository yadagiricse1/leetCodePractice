package practice;

public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;

        return sumNumbersRecurse(root,0);
    }

    public int sumNumbersRecurse(TreeNode root, int num) {

        if(root==null)
            return 0;
        int currentCount=num*10+root.val;
        if(root.left==null && root.right==null)
            return currentCount;
        else {
            int left = sumNumbersRecurse(root.left,currentCount);
            int right = sumNumbersRecurse(root.right,currentCount);
            return left+right;

        }
    }

}
