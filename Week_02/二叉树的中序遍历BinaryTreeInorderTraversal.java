/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public List<Integer> inorderTraversal_4_2(TreeNode root) {//Morris 中序遍历 O(N) O(1)
     //破坏法
		List<Integer> res = new ArrayList<Integer>();
		TreeNode pre = null;
		while(root!=null) {
			//如果左节点不为空，就将当前节点连带右子树全部挂到
			//左节点的最右子树下面
			if(root.left!=null) {
				pre = root.left;
				while(pre.right!=null) {
					pre = pre.right;
				}
				pre.right = root;
				//将root指向root的left
				TreeNode tmp = root;
				root = root.left;
				tmp.left = null;
			//左子树为空，则打印这个节点，并向右边遍历	
			} else {
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}

    public List<Integer> inorderTraversal_4_1(TreeNode root) {//Morris 中序遍历 O(N) O(1)
    //完整法
    // 莫里斯遍历的优点是没有使用任何辅助空间。缺点是改变了整个树的结构，强行把一棵二叉树改成一段链表结构。
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {//方法三 栈 反序入栈
    //非递归-另一种解法（颜色标记法） 将节点与结点的值一起压入栈，通过判断对象是否为节点类型继续进行操作 
    //思路 中序遍历 左根右 入栈顺序 右根左 O(N) O(N)
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Deque<Object> stk = new ArrayDeque<Object>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Object o = stk.pop();
            //因为中序遍历是左节点--根节点--右节点
            //即出栈顺序为左节点--根节点--右节点，入栈顺序相反
            if( o instanceof TreeNode) {
                TreeNode node = (TreeNode)o;
                if(node.right != null) stk.push(node.right);
                stk.push(node.val);
                if(node.left != null) stk.push(node.left);
            } else {
                res.add((int)o);
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {//方法二 栈
    //思路 手动用栈来模拟 递归方法的程序栈
    //中序遍历 左根右 O(N) O(N)
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new ArrayDeque<TreeNode>();
        while (root != null || !stk.isEmpty() ) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
			//这是模拟递归的调用
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
			//然后转向右边节点，继续上面整个过程
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal_1(TreeNode root) {//方法一 递归解法
    //思路 中序遍历-左根右 时间复杂度 O(n)二叉树的遍历中每个节点会被访问一次且只会被访问一次。
    //空间复杂度 O(n)空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到O(n) 的级别。
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        inorder_1(root, res);
        return res;
    }
    public void inorder_1(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder_1(root.left, res);
        res.add(root.val);
        inorder_1(root.right, res);
    }
}