import struct.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表
 * 中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目范围是 [0, 10⁴]
 * -10⁵ <= Node.val <= 10⁵
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 2132 👎 0
 */
public class LinkedListCycle141 {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle141().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class struct.ListNode {
     * int val;
     * struct.ListNode next;
     * struct.ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fastNode = head;
            ListNode slowNode = head;
            boolean flag = false;
            /*快慢指针，龟兔赛跑，龟走1步，兔走2步，如果有环，则一定会相遇；
            fastNode 代表兔子 slowNode 代表乌龟
            注意循环条件，fastNode != null && fastNode.next != null ，兔子走得快，需要判断兔子的next,
             */
            while (fastNode != null && fastNode.next != null) {
                //快慢指针判断是否有环，快指针走两步，慢指针走两步
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
                if (fastNode == slowNode) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}

