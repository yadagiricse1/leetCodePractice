package practice;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node,Node> originalCopy = new HashMap<>();
        Node originalhead = head;
        Node newHead ;
        while(head!=null){
            originalCopy.put(head,new Node(head.val));
            head =head.next;
        }
        Node node = originalhead;
        newHead = originalCopy.get(originalhead);
        Node temp;
        while(node!=null){
            temp =  originalCopy.get(node);
            if(node.next!=null){
                temp.next = originalCopy.get(node.next);
            }
            if(node.random!=null){
                temp.random = originalCopy.get(node.random);
            }
            node=node.next;
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
