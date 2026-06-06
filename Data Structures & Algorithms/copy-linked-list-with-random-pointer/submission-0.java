/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> random = new HashMap<>();
        Node dummy=head;
        while(dummy!=null)
        {
            random.put(dummy, new Node(dummy.val));
            dummy=dummy.next;
        }
        dummy=head;
        while(dummy!=null)
        {
            Node clone= random.get(dummy);
            clone.next=random.get(dummy.next);
            clone.random=random.get(dummy.random);
            dummy=dummy.next;
        }
        return random.get(head);
    }
}
