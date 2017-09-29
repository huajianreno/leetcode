/**
 * Created by huajian_messi on 2017/9/29.
 * 注意：此题有两点需要注意：1、树上的数可能是负数，所以在某个节点和为0，不能直接返回，还要继续向下递归；
 *                         2、对象引用问题，如本题中，"r.add(new LinkedList(temp))"就和"r.add(temp)"就很不同，需要深究
 */
public class Solution_113 {
    List<List<Integer>> r=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return r;
        }
        List<Integer> t=new LinkedList<>();

        helper(root,sum,t);

        return r;
    }

    public void helper(TreeNode root,int sum,List<Integer> temp){
        int remain=sum-root.val;
        if(remain==0){
            if(root.left==null&&root.right==null){
                temp.add(root.val);
                r.add(new LinkedList(temp));
                int size=temp.size();
                temp.remove(size-1);
                return;
            }
        }
        if(root.left==null&&root.right==null){
            return;
        }else{
            if(root.left!=null){
                temp.add(root.val);
                int size=temp.size();
                helper(root.left,remain,temp);
                temp.remove(size-1);
            }
            if(root.right!=null){
                temp.add(root.val);
                int size=temp.size();
                helper(root.right,remain,temp);

                temp.remove(size-1);
            }
        }

    }
}
