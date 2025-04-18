package practice;

import java.util.HashSet;
import java.util.Set;

public class InsertIntoASortedCircularLinkedList {
    public Node insert1(Node head, int insertVal){
        if (head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            return temp;
        }
        boolean toInsert = false;
        Node prev = head;
        Node current =head.next;
        do{
            if(prev.val<=insertVal&&insertVal<=current.val)
                toInsert= true;
            else if(prev.val>current.val){
                if(insertVal>=prev.val||insertVal<=current.val)
                    toInsert= true;

            }
            if(toInsert){
                Node inserting =new Node(insertVal);
                prev.next= inserting;
                inserting.next=current;
                return head;

            }
            prev=current;
            current=current.next;


        } while(prev!=head);

        Node inserting =new Node(insertVal);
        prev.next= inserting;
        inserting.next=current;

        return head;
    }
    public Node insert(Node head, int insertVal) {
        Node node = head;
        if (head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            return temp;
        } else if (node.next == node) {
            Node inserting = new Node(insertVal);
            node.next = inserting;
            inserting.next = node;
        } else {
            boolean toInsert = false;
            Node prev = head;
            Node current =head.next;
            do{
                if(prev.val<=insertVal&&insertVal<=current.val)
                    toInsert= true;
                else if(prev.val>current.val){
                    if(insertVal>=prev.val||insertVal<=current.val)
                        toInsert= true;

                }
                if(toInsert){
                    Node inserting =new Node(insertVal);
                    prev.next= inserting;
                    inserting.next=current;
                    return head;

                }
                prev=current;
                current=current.next;


            } while(prev!=head);

            Node inserting =new Node(insertVal);
            prev.next= inserting;
            inserting.next=current;
            return head;

        }


        return head;
    }

}
