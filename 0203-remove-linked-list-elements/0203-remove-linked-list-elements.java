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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        while(head.val==val && head.next!=null){
            head = head.next;
        }
        if(head.val==val && head.next==null){
            head = null;
            return head;
        }
        if(head.next!=null){
            ListNode prev = head;
            ListNode cur = head.next;
            while(cur.next!=null){
                if(cur.val==val){
                    prev.next = cur.next;
                    cur = cur.next;
                }
                else{
                    prev=cur;
                    cur=cur.next;
                }
            }
            if(cur.val==val){
                prev.next=null;
            }
        }
        return head;
    }
}