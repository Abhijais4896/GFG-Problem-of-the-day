// Clone a linked list with next and random pointer

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        if (head == null)
            return null;
        Node copyHead = new Node(head.data), curCopy = copyHead, i = head;
        while (i != null) {
            curCopy.next = i.next;
            i.next = curCopy;
            i = curCopy.next;
            curCopy = i == null ? null : new Node(i.data);

        }
        curCopy = copyHead;
        i = head;
        while (i != null) {
            if (i.random != null)
                curCopy.random = i.random.next;
            i = curCopy.next;
            if (curCopy.next != null)
                curCopy = curCopy.next.next;
        }
        i = head;
        curCopy = copyHead;
        while (i != null) {
            i.next = curCopy.next;
            if (curCopy.next != null)
                curCopy.next = curCopy.next.next;
            i = i.next;
            curCopy = curCopy.next;
        }
        return copyHead;
    }
}
