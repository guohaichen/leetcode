import struct.ListNode;

/**
 * <p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4]
 * <strong>输出：</strong>[2,1,4,3]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1]
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li>
 * <li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2220</li><li>👎 0</li></div>
 */
public class SwapNodesInPairs24 {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs24().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode listNode = solution.swapPairs(head);
        System.out.println(listNode.val);
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
        public ListNode swapPairs(ListNode head) {
            //两两交换， 假设1，2，3 交换1，2，需要先将2-3这个引用链保存下来，才能让2->1,
            // 递归三要素：1.确定返回值，返回head.next;2.递归做什么事情，终止条件；
           /* if (head==null || head.next==null){
                return head;
            }
            //2
            ListNode next = head.next;
            // 1->3
            head.next = swapPairs(next.next);
            //2->1
            next.next = head;

            return next;*/

            //非递归方式，定义一个辅助节点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode temp = dummy;
            while (temp.next != null && temp.next.next != null) {
                //temp  temp.next   temp.next.next
                // -1   1           2                       3
                ListNode first = temp.next;
                ListNode second = temp.next.next;

                //辅助头节点指向
                temp.next = second;

                //1->3
                first.next = second.next;
                //2->1
                second.next = first;
                //指针后移，不能使用temp = temp.next了。temp.next指向已经改变了
                temp = first;

            }
            return dummy.next;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}