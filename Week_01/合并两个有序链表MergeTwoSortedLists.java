/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//方法二 递归解法 O(m+n) l1l2元素个数
    //通过递归找到最小的值，然后依次返回作为上一个节点的next
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {//方法一 一般解法
        //方法一 构建一个新的节点，一边遍历一边比较，小的插入节点
        //如果有某一条遍历完直接插入尾部不在比较
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        if(l1 == null)
            temp.next = l2;
        if(l2 == null)
            temp.next = l1;
        return head.next;
    }
}