import struct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表
 * 中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目范围在范围 [0, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 2510 👎 0
 */
public class LinkedListCycleIi142 {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi142().new Solution();
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
        //        public ListNode detectCycle(ListNode head) {
//            ListNode fastNode = head;
//            ListNode slowNode = head;
//            /**
//             *  快指针走两步，慢指针走一步，总会相遇，
//             */
//            while (fastNode != null && fastNode.next != null) {
//                slowNode = slowNode.next;
//                fastNode = fastNode.next.next;
//                //有环
//                if (fastNode == slowNode) {
//                    slowNode = head;
//                    while (fastNode != slowNode) {
//                        fastNode = fastNode.next;
//                        slowNode = slowNode.next;
//                    }
//                    return fastNode;
//                }
//            }
//            return null;
//        }
        public ListNode detectCycle(ListNode head) {
            //用哈希表同样可以解决，遍历整个链表，依次放入哈希表，如果表中存在，返回该节点，如果能放完，则无环，返回null;
            Map<ListNode, ListNode> map = new HashMap<>();
            while (head != null) {
                if (map.containsKey(head)) {
                    return head;
                } else {
                    map.put(head, head);
                }
                head = head.next;
            }
            //如果没有提前返回head，则说明无环，返回null
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}