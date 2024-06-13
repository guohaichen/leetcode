import struct.ListNode;

import java.util.HashMap;


public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists160().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class struct.ListNode {
     * int val;
     * struct.ListNode next;
     * struct.ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            /*哈希表实现，key存访ListNode,value 存访 val，遍历一个给定的headA,存放进去，随后遍历headB，使用hashMap.get，如果不为空 则说明有相交点
            HashMap<ListNode, Integer> hashMap = new HashMap<>();
            ListNode sentinel = headA;
            while (sentinel != null) {
                hashMap.put(sentinel, sentinel.val);
                sentinel = sentinel.next;
            }
            sentinel = headB;
            while (sentinel != null) {
                if (hashMap.get(sentinel) != null) {
                    return sentinel;
                }
                sentinel = sentinel.next;
            }
            return null;
            */

            /*
            如果两个链表相交，那么他们的尾部是一致的。
            和找出链表的环节点有点类似，
                  */
            ListNode p1 = headA, p2 = headB;
            while (true) {
                if (p1 == p2) {
                    return p1;
                }
                if (p1 == null) p1 = headB;
                else p1 = p1.next;
                if (p2 == null) p2 = headA;
                else p2 = p2.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}