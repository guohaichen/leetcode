import struct.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * <p>
 * 请将其重新排列后变为：
 * <p>
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 5 * 10⁴]
 * 1 <= node.val <= 1000
 * <p>
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 1465 👎 0
 */
public class ReorderList143 {
    public static void main(String[] args) {
        Solution solution = new ReorderList143().new Solution();
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
    class Solution {
        public void reorderList(ListNode head) {
            //利用快慢指针，找到中间节点（快指针走到尾时，满指针走到1半，如果是奇数，则中间节点，如果是偶数，），将链表分成左右两个链表，反转后面的链表，
            ListNode fastNode = head;
            ListNode slowNode = head;
            ListNode temp = head;
            while (fastNode != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
                temp = temp.next;
            }
            reverseNode(slowNode.next);

        }

        //反转链表
        private void reverseNode(ListNode node) {
            ListNode cur = node;

            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = cur;
                cur = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}