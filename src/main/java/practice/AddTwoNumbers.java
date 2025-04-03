package practice;

public class AddTwoNumbers {
    public  ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int x= l1!=null ? l1.val : 0;
            int y= l2!=null ? l2.val : 0;
            int sum=carry+x+y;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }

        return dummyHead.next;
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2 , int carry){

        ListNode node = null;
        if(l1!=null && l2!=null){
            int val =l1.val+l2.val+carry;
            carry =val/10;
            node = new ListNode(val%10);
            node.next=addTwoNumbers(l1.next,l2.next,carry);
        } else if(l1 != null){
            int val =l1.val+carry;
            carry =val/10;
            node = new ListNode(val%10);
            node.next=addTwoNumbers(l1.next,null,carry);
        }  else if(l2 != null){
            int val =l2.val+carry;
            carry =val/10;
            node = new ListNode(val%10);
            node.next=addTwoNumbers(null,l2.next,carry);
        } else if(carry==1){

            node = new ListNode(carry);
        }
        return node;
    }


    public static void main(String[] args) {

    }
}
