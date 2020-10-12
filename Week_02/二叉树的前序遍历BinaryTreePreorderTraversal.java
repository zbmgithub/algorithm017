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
    public List<Integer> postorderTraversal(TreeNode root) {//二叉树的后序遍历 迭代 中序遍历的变形
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                ans.add(0, root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        
        return ans;
    }
    
    public List<Integer> preorderTraversal_3(TreeNode root) {//方法四 Morris解法 最后会还原树的结构
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    // System.out.print(cur1.value + " ");
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;//断开连接（伪边）
                }
            } else {
                // System.out.print(cur1.value + " ");
                res.add(cur1.val);
            }
            cur1 = cur1.right;
        }
        return res;
    }
    public List<Integer> preorderTraversal_2_2(TreeNode root) {//方法三 迭代 中序遍历修改版
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root) {//方法二 栈
    //思路 手动用栈模拟递归中程序栈
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> stk = new ArrayDeque<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right != null) stk.push(node.right);
            if(node.left != null) stk.push(node.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal_1(TreeNode root) {//方法一 递归
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}