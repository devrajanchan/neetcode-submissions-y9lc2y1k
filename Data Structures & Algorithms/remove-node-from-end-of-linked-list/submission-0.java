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
        ListNode l1 = dummy; 
        int length=-1;
        while(l1!=null)
        {
            l1=l1.next;
            length++;
        }
        System.out.println(length);
        l1=dummy;
        for(int i =0;i<(length-n);i++)
        {
            l1=l1.next;
        }
        if(l1.next!=null) l1.next=l1.next.next;
        else l1.next=null;
        return dummy.next;
    }
}
