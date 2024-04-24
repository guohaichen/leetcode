import struct.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 3487 👎 0
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists21().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class struct.ListNode {
     * int val;
     * struct.ListNode next;
     * struct.ListNode() {}
     * struct.ListNode(int val) { this.val = val; }
     * struct.ListNode(int val, struct.ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //[1,2,4]
    //[1,3,4]
        /*
        merge([1,2,4],[1,3,4])
            1.next=merge([2,4],[1,3,4])
                1.next=merge([2,4],[3,4])
                    2.next=merge([4],[3,4])
                        3.next=merge([4],[4])
                            4.next=merge(null,[4])
                            return 4
                        return 4
                    return 3
                return 2
            return 1
        return 1
         */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            /* 方式一：
            //哨兵节点
            struct.ListNode sentinel = new struct.ListNode(-1);
            struct.ListNode head = sentinel;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    sentinel.next = list1;
                    list1 = list1.next;
                } else {
                    sentinel.next = list2;
                    list2 = list2.next;
                }
                sentinel = sentinel.next;
            }
            if (list1 != null) {
                sentinel.next = list1;
            }
            if (list2 != null) {
                sentinel.next = list2;
            }
            return head.next;*/
            // 方式2 递归
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}