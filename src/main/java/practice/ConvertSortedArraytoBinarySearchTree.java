package practice;

public class ConvertSortedArraytoBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode sortedArrayToBST(int[] nums,int begin, int end){
        int mid=begin+(end-begin)/2;
        TreeNode treeNode = new TreeNode(nums[mid]) ;
        if(begin<mid)
            treeNode.left=sortedArrayToBST(nums,begin,mid-1);
        if(mid<end)
            treeNode.right=sortedArrayToBST(nums,mid+1,end);
    return treeNode;
    }
}
