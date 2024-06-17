import struct.ListNode;

/**
 * <p>给定一个已排序的链表的头&nbsp;<code>head</code> ，&nbsp;<em>删除原始链表中所有重复数字的节点，只留下不同的数字</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="height: 142px; width: 500px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,3,4,4,5]
 * <strong>输出：</strong>[1,2,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="height: 164px; width: 400px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,1,1,2,3]
 * <strong>输出：</strong>[2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * <li>题目数据保证链表已经按升序 <strong>排列</strong></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1297</li><li>👎 0</li></div>
 */
public class RemoveDuplicatesFromSortedListIi82 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi82().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            /*
            思路：因为头节点可能也是重复得，所以需要定义一个pre节点,指向头节点
            因为是删除所有重复的节点，可以将相同的val保存下来，作为下次判断是否相等
             */
            ListNode pre = new ListNode(200);
            pre.next = head;
            ListNode temp = pre;
            while (temp.next != null && temp.next.next != null) {
                if (temp.next.val == temp.next.next.val) {

                    int x = temp.next.val;
                    while (temp.next!=null && temp.next.val==x){
                        temp.next = temp.next.next;
                    }
                }else {
                    temp = temp.next;
                }
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}