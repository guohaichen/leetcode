import struct.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节
 * 点，返回 反转后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * Related Topics 链表 👍 1780 👎 0
 */
public class ReverseLinkedListIi92 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi92().new Solution();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        solution.reverseBetween(head, 2, 4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if ((left >= right)) {
                return head;
            }
            //定义一个辅助节点，如果反转节点是从head开始，更方便操作
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            //下面操作后，prev为需要反转的位置 的 前一个节点
            int index = 0;
            while (prev.next != null && index < left - 1) {
                prev = prev.next;
                index++;
            }
            //start 为第一个需要反转的地方
            ListNode start = prev.next;
            //then是需要头插在start之前的节点
            ListNode then = start.next;
            //反转left到right,采用原地反转，next插入到头部， 依次将 start.next 插入到头部，
            // 1->2->3->4->5   1->3->2->4->5    1->4->3->2->5
            for (int i = 0; i < right - left; i++) {
                //2->4               //第二轮 2->5
                start.next = then.next;
                //3->2               //第二轮 4->3
                then.next = prev.next;
                //1->3               //第二轮 1->4
                prev.next = then;
                //then=4             //第二轮 then=5
                then = start.next;
            }
            return dummy.next;

        }

    }

    class Solution2 {
        /*
        方法二：
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode temp = new ListNode(-1);
            temp.next = head;
            ListNode start = temp;
            //找到需要反转中间部分的前驱节点，当前的start,
            for (int i = 0; i < left - 1; i++) {
                start = start.next;
            }

            //翻转中间部分,算法同反转链表
            ListNode pre = null;
            ListNode cur = start.next;
            for (int i = 0; i < right - left+1; i++) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            //翻转完成后，pre 即翻转后的头，cur即为right.next
            start.next.next = cur;
            start.next = pre;
            return temp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}