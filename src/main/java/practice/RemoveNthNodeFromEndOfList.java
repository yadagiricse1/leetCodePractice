package practice;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count =0;
        while(node!=null){
            node = node.next;
            count++;
        }
        if(count==1 &&n==1){
            return null;
        } else if(count>1 && count==n ){
            return head.next;
        }


        int beginIndex = count-n;
        node = head;
        int i=1;
        while(i<beginIndex){
            node = node.next;
            i++;
        }
        node.next =node.next.next;

        return head;
    }
}
