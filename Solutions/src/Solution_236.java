/**
 * Created by huajian_messi on 2017/6/27.
 * 用了Map，Queue，Set，ArrayList，= =，这是一个非递归方法，递归方法在下方
 * 注意：发现了一种找到树的节点的祖先的方式，遍历，节点作为key，父节点作为val，就可以存在Map中并一步一步向上溯源
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
public class Solution_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> qt=new LinkedList<>();
        qt.add(root);
        map.put(root,root);

        //将所有节点的父节点保存起来，放在map中
        while(!qt.isEmpty()){
            TreeNode temp=qt.poll();
            if(temp.left!=null){
                qt.add(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null){
                qt.add(temp.right);
                map.put(temp.right,temp);
            }
        }

        //由于要找两个节点最低一层的祖先，所以一个从低到高寻找，另一个放Set中就好
        Set<TreeNode> set_q=new HashSet<>();
        ArrayList<TreeNode> list_p=new ArrayList<>();
        TreeNode key=p;
        list_p.add(p);
        while(key!=map.get(key)){
            key=map.get(key);
            list_p.add(key);
        }
        key=q;
        set_q.add(q);
        while(key!=map.get(key)){
            key=map.get(key);
            set_q.add(key);
        }
        TreeNode result=root;
        for (TreeNode temp:list_p){
            if(set_q.contains(temp)){
                result=temp;
                break;
            }
        }
        return result;
    }
}


