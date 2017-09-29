import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huajian_messi on 2017/9/26.
 */
public class Solution_449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String s="";
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            Queue<TreeNode> q2=new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode temp=q.poll();
                q2.add(temp);
                if(temp!=null){
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            while(!q2.isEmpty()){
                TreeNode temp=q2.poll();
                if(temp!=null){
                    s+=temp.val;
                }else{
                    s+="#";
                }
            }
            return s;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            TreeNode root=new TreeNode(data.charAt(0)-'0');
            Queue<TreeNode> queue=new LinkedList<>();
            int index=1;
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(temp!=null){
                    char c1=data.charAt(index);
                    char c2=data.charAt(index+1);
                    if(c1!='#'){
                        temp.left=new TreeNode(c1-'0');
                        queue.add(temp.lfet);
                    }else{
                        queue.add(null);
                    }
                    if(c2!='#'){
                        temp.right=new TreeNode(c2-'0');
                        queue.add(temp.right);
                    }else{
                        queue.add(null);
                    }
                    index+=2;
                }
            }
            return root;
        }

    }
}
