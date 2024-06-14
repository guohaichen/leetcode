import struct.ListNode;

import java.util.LinkedList;

/**
 * <p>给你一个单链表的头节点 <code>head</code> ，请你判断该链表是否为<span data-keyword="palindrome-sequence">回文链表</span>。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,2,1]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2]
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点数目在范围<code>[1, 10<sup>5</sup>]</code> 内</li>
 * <li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你能否用&nbsp;<code>O(n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度解决此题？</p>
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1912</li><li>👎 0</li></div>
 */
public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList234().new Solution();
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
        /* public boolean isPalindrome(ListNode head) {
        /*
         * on空间复杂度的栈，先将链表元素先入栈，然后在出栈，依次喝原来的链表对比；
            ListNode cur = head, dummy = head;
            LinkedList<ListNode> stack = new LinkedList<>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            //
            while (!stack.isEmpty()) {
                if (stack.pop().val != dummy.val) {
                    return false;
                }
                dummy = dummy.next;
            }
            return true;
        }*/

        /*
        方式二：
        不另外使用栈空间，结合求中间节点，反转链表来对比
                                    fast
                      slow
        1       2     3     2       1

                                     fast
                      slow
        1       2     2         2

         */
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode dummy = head;
            ListNode newHead = null;
            //将求中间节点和反转链表结合在一起
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                //反转链表(前面一半的节点)
                dummy.next = newHead;
                newHead = dummy;
                dummy = slow;
            }
            //如果链表是奇数，那么快指针节点不为空
            if (fast != null) {
                slow = slow.next;
            }
            while (newHead != null) {
                if (slow.val != newHead.val) {
                    return false;
                }
                slow = slow.next;
                newHead = newHead.next;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}