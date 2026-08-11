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
        Map<Node, Node> map = new HashMap();
        Node h2 = head;
        Node h3 = head;
        while(h3 != null) {
            Node n = new Node(h3.val);
            map.put(h3, n);
            h3 = h3.next;
        }
        while(h2 != null) {
            Node n = map.get(h2);
            if(h2.next!=null) {
                n.next = map.get(h2.next);
            }
            if(h2.random!=null) {
                n.random = map.get(h2.random);
            }
            map.put(h2, n);
            h2 = h2.next;
        }
        return map.get(head);
    }
}