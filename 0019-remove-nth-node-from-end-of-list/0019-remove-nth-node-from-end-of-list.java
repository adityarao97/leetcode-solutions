/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //left pointer is at a dummy node
        ListNode left = dummy;
        //right pointer is at head
        ListNode right = head;
        //we make right pointer to be at 0 + nth position in the list, this way the distance between left and right is = n
        while(n>0){
            right = right.next;
            n--;
        }
        //we now make our right pointer reach the end of the list and keep shifting left, at this point left is pointing to n - 1th node, as the distance between them is n + 1
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        //the next pointer to left is the nth node which we want to remove
        left.next = left.next.next;
        return dummy.next;
    }
}