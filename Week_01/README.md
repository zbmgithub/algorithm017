学习笔记 学习使我快乐
本周总结9/27

1.五遍刷题法：
	第一遍：5分钟：读题加思考；直接看解法；背诵、默写好的解法；
	第二遍：马上自己写；多种解法比较、优化；
	第三遍：过了一天后，重复做题；不同解法熟练程度；
	第四遍：一周后：反复练习；
	第五遍：面试前一周恢复性训练；
2.学会使用谷歌搜索java源代码、文档
3.学会升维的思想空间换时间
4.双指针法，把问题拆解成最近的子问题



[TOC]

#数据结构 

• 一维:
 • 基础:数组 array (string), 链表 linked list
 • 高级:栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc 

• 二维:
 • 基础:树 tree, 图 graph
 • 高级:二叉搜索树 binary search tree (red-black tree, AVL), 堆 heap, 并查集 disjoint set, 字典树 Trie, etc 

• 特殊:
 • 位运算 Bitwise, 布隆过滤器 BloomFilter • LRU Cache 

#算法 

- If-else, switch —> branch 
- for, while loop —> Iteration 
- 递归 Recursion (Divide & Conquer, Backtrace) 
- 搜索 Search: 深度优先搜索 Depth first search, 广度优先搜索 Breadth first search, A*, etc 
- 动态规划 Dynamic Programming 
- 二分查找 Binary Search 
- 贪心 Greedy 
- 数学 Math , 几何 Geometry 

#Big O notation 

* O(1): Constant Complexity 常数复杂度
* O(log n): Logarithmic Complexity 对数复杂度 
* O(n): Linear Complexity 线性时间复杂度 
* O(n^2): N square Complexity 平方
* O(n^3): N cubic Complexity 立方
* O(2^n): Exponential Growth 指数
* O(n!): Factorial 阶乘 

# 空间复杂度

* 数组的长度
* 递归的深度

# 数组

* 数组（Array）是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据。
* 下标查询的时间复杂度为O(1), 增加和删除的时间复杂度为O(n)

# 链表

* 通过“指针”将一组零散的内存块串联起来使用
* 查询时间复杂度O(n)，增加和删除的时间复杂度为O(1)
* 将某个变量赋值给指针，实际上就是将这个变量的地址赋值给指针，或者反过来说，指针中存储了这个变量的内存地址，指向了这个变量，通过指针就能找到这个变量。

~~~
单链表插入：插入x节点，当前指针指向p
注意顺序，防止内存泄漏
1. x->next = p->next;  // 将x的结点的next指针指向b结点；
2. p->next = x;  // 将p的next指针指向x结点；
当向一个空链表中插入第一个结点，需进行下面这样的特殊处理，其中 head 表示链表的头结点。所以，对于单链表的插入操作，第一个结点和其他结点的插入逻辑是不一样的。
if (head == null) {  head = new_node;}
~~~

~~~
单链表结点删除操作,如果要删除结点 p 的后继结点:
p->next = p->next->next;
如果要删除链表中的最后一个结点，需要特殊处理。
if (head->next == null) {   head = null;}
~~~

# 跳表

* 给链表升维，在链表上加入多级索引的结构
* 第 k 级索引的结点个数是第 k-1 级索引的结点个数的 1/2，那第 k级索引结点的个数就是 n/(2k)
* 跳表中查询任意数据的时间复杂度就是 O(logn)，插入和删除也是O(logn)

# 栈

* 当某个数据集合只涉及在一端插入和删除数据，并且满足后进先出、先进后出的特性，就应该首选“栈”这种数据结构。
* 栈主要包含两个操作，入栈和出栈，也就是在栈顶插入一个数据和从栈顶删除一个数据。
* 栈既可以用数组来实现，也可以用链表来实现。用数组实现的栈，我们叫作顺序栈，用链表实现的栈，我们叫作链式栈。
* 时间复杂度和空间复杂度都为O(1)

# 队列

* 先进者先出，这就是典型的“队列”
* 最基本的操作也是两个：入队 enqueue()，放一个数据到队列尾部；出队 dequeue()，从队列头部取一个元素。
* 跟栈一样，队列可以用数组来实现，也可以用链表来实现。用数组实现的栈叫作顺序栈，用链表实现的栈叫作链式栈。同样，用数组实现的队列叫作顺序队列，用链表实现的队列叫作链式队列。

