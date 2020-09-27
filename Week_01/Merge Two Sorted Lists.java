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
 //方法遍历依次比较大小插入，直到有一条遍历完

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode p1 = l1, p2 = l2;
        ListNode cur = l;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        if(p1 == null) {
            cur.next = p2;
        }
        if(p2 == null) {
            cur.next = p1;
        }
        return l.next;
    }
}