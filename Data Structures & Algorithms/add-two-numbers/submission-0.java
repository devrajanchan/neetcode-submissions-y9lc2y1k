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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode h1=l1,h2=l2;
        ListNode a=new ListNode(0);
        ListNode ans=a;
        while(h1!=null || h2!=null || carry!=0)
        {
            int val1 = (h1 != null) ? h1.val : 0;
            int val2 = (h2 != null) ? h2.val : 0;
            int sum=(val1 + val2 + carry);
            carry=sum/10;
            a.next=new ListNode(sum%10);
            a=a.next;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        return ans.next;
    }
}
