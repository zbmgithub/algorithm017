2020/10/11	学习笔记

哈希的概念

	*hash算法的概念 Hash: 一般翻译做“散列”，也有直接音译为“哈希”的，就是把任意长度的输入（又叫做预映射， pre-image），通过散列算法，变换成固定长度的输出，该输出就是散列值。简单的说就是一种将任意长度的消息压缩到某一固定长度的消息摘要的函数。
	
树的一些相关概念

	*链表是特殊的树，树是特殊的图（无环）
	*前序：根-左-右
	*中序：左-根-右
	*后序：左-右-根
	*二叉搜索树-中序遍历：升序排列
树的面试题解法一般都是递归，为什么？

	1. 该问题可以被分解成若干个重复的子问题；
	2. 该问题与它分解出的子问题可以使用相同的算法来解决；
	3. 有明确的终止条件 树这种数据结构的特点和上述三个特点高度一致，一棵树的每个非叶子节点的子节点也都是一棵树，都是树自然可以使用相同的算法来处理，因为没有环所以天然具有终止条件。
	4. 另外一方面，树本身是一种非线性的数据结构，循环遍历不易。当然循环遍历也是可以做，树是一种特殊的图，我们完全可以使用图的广度优先遍历算法一层一层的循环遍历整棵树。
	*综上，我们一般还是选择递归的方式来解决树的问题。
--------------------------------------------------------------------------------------------------------------------------------------------
学习到的一些新的函数方法或者关键字

	instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，用法为：boolean result = obj instanceof Class

	Arrays.sort(char[] ch);//将ch字符数组按照字母顺序排序 

	Arrays.equals(char[] ch1, char[] ch2);//比较两个字符数组是否相等

	Integer.MAX_VALUE代表int的最大值，当常数使用

	Integer.MIN_VALUE代表int的最小值

	Integer类型对象 比较值用"equals", 比较 引用 用"=="

	System.arraycopy(nums1, 0, nums_copy, 0, m);//nums1从0开始拷贝到nums_copy从0开始长度为m

	构建最小堆
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//默认最小堆

	构建最大堆
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

	HashMap getOrDeFault()	方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
	语法为 hashmap.getOrDeFault(Object key, V defaultValue);

	
