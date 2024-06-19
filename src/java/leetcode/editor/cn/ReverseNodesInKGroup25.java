import struct.ListNode;

/**
 * <p>给你链表的头节点 <code>head</code> ，每&nbsp;<code>k</code><em>&nbsp;</em>个节点一组进行翻转，请你返回修改后的链表。</p>
 *
 * <p><code>k</code> 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是&nbsp;<code>k</code><em>&nbsp;</em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>
 *
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 2
 * <strong>输出：</strong>[2,1,4,3,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 3
 * <strong>输出：</strong>[3,2,1,4,5]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <strong>提示：</strong>
 *
 * <ul>
 * <li>链表中的节点数目为 <code>n</code></li>
 * <li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li>
 * <li><code>0 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你可以设计一个只用 <code>O(1)</code> 额外内存空间的算法解决此问题吗？</p>
 *
 * <ul>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2341</li><li>👎 0</li></div>
 */
public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup25().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            /*
            1~2~3~4~5 ， k = 2;
            pre head next
             */
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode kHead = dummy;
            ListNode kTail = dummy;
            while (kTail.next != null) {

                for (int i = 0; i < k && kTail != null; i++) {
                    kTail = kTail.next;
                }
                if (kTail == null) {
                    break;
                }
                //当前k组链表头
                ListNode start = kHead.next;
                //下一个k组开头节点
                ListNode next = kTail.next;

                //断开k组与后面的链接，置空方便反转链表
                kTail.next = null;
                //反转
                kHead.next = reverse(start);
                //连接反转后的 下一个k组
                start.next = next;
                //经过反转后，即为 下一个k组的 prev
                kHead = start;
                kTail = start;
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode pre = null;
            ListNode cur = node;
            while (cur != null) {
                //先保存后面的节点,防止丢失
                ListNode temp = cur.next;
                //反转指向
                cur.next = pre;
                //指针后移
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}