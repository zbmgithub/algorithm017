/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

LinkedList<Node> temp=new LinkedList<>();
    public List<Integer> preorder(Node root) {//方法二 迭代法
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> stk = new ArrayDeque<>();
        stk.push(root);
        while(!stk.isEmpty()) {
            Node node = stk.pop();
            res.add(node.val);
            for(int i = node.children.size() - 1 ; i >= 0 ; i--)
                stk.push(node.children.get(i));
        }
        return res;
    }

    public List<Integer> preorder_2_1(Node root) {//方法二 迭代法
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<Node> deque = new ArrayDeque<Node>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children)
                deque.offerLast(child);          
        }
        return res;
    }

    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder_1_2(Node root) {//方法一 递归(不使用辅助函数)
        // List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.add(root.val);
        for (Node node : root.children) {
            // res.addAll(preorder(node));
            preorder(node);
        }
        return res;
    }

    public List<Integer> preorder_1_1(Node root) {//方法一 递归（使用辅助函数）
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            helper(node, res);
        }
    }
}