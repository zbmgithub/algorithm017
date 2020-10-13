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
//广度优先搜索。我们使用队列来进行广度优先搜索，队列具有先进先出的特性。
//栈应用于深度优先搜索。
class Solution {

    public List<List<Integer>> levelOrder_2(Node root) {//方法二 队列 O(n) O(n)
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();//通过size的大小来确定每次处理一层
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }



    public List<List<Integer>> levelOrder(Node root) {//方法一 递归 另外一种版本(避免全局变量)
        return dfs(root, new ArrayList<>(), 0);
    }
    private List<List<Integer>> dfs(Node node, List<List<Integer>> res, int level) {
        if (node == null) return res;
        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        for (Node child : node.children) dfs(child, res, level + 1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder_1(Node root) {//方法一 递归法 时间O(n) 空间O(logn)最坏时O(n)
        if(root != null) helper(root, 0);
        return res;
    }
    public void helper(Node root, int level) {//递归的辅助函数
        if (res.size() == level)
            res.add(new ArrayList<>());//初始时，res为空，每添加一个list,size大小加一,正好代表第几层
        res.get(level).add(root.val);
        for (Node node : root.children)
            helper(node, level + 1);
    }
}