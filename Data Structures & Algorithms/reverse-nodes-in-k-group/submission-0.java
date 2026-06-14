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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode tail=dummy;
        ListNode kth=getkth(tail,k);
        while(kth!=null)
        {
            ListNode nextGrp=kth.next;
            ListNode newGroupTail = tail.next;
            ListNode prev=nextGrp;
            ListNode curr=tail.next;
            
            while(curr!=nextGrp)
            {
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;        
            }
            tail.next=kth;
            tail=newGroupTail;
            kth=getkth(tail,k);
        }
        return dummy.next;
    }
    public ListNode getkth(ListNode curr, int k)
    {
        while(curr!=null && k>0)
        {
            curr=curr.next;
            k--;
        }
        return curr;
    }
}
