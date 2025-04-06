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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        //add all head of list to the min heap
        for(ListNode list: lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        //until min heap is empty keep extracting the minimum value node and append it to the list
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            temp.next = node;
            temp = temp.next;
            node = node.next;
            if(node!=null){
                minHeap.offer(node);
            }
        }
        return head.next;
    }
}