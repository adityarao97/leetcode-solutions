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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(stack.pop(), null);
        ListNode temp = res;
        while(stack.size()>0){
            ListNode newNode = new ListNode(stack.pop(), null);
            temp.next = newNode;
            temp = temp.next;
        }
        return res;
    }
}