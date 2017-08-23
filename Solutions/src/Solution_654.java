/**
 * Created by huajian_messi on 2017/8/23.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length;
        if(n==0)
            return null;
        int max=0;
        int index=-1;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        TreeNode left=helper(0,index-1,nums);
        TreeNode right=helper(index+1,n-1,nums);
        root.left=left;
        root.right=right;
        return root;
    }
    public TreeNode helper(int low,int high,int[] nums){
        int max=0;
        int index=low;
        if(low>high)
            return null;
        for(int i=low;i<=high;i++){
            if(nums[i]>=max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode subroot=new TreeNode(max);
        TreeNode left=helper(low,index-1,nums);
        TreeNode right=helper(index+1,high,nums);
        subroot.left=left;
        subroot.right=right;
        return subroot;
    }
}

