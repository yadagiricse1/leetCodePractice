package practice;

public class IntersectionofTwoLinkedLists {

    //This approach is not efficient
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p=headA;
        ListNode q = headB;
        while(p!=q){
            p=p==null?headA:p.next;
            q=q==null?headB:q.next;
        }
        return p;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        int a=0;
        int b=0;
        while(l1!=null){
            l1=l1.next;
            a++;
        }

        while(l2!=null){
            l2=l2.next;
            b++;
        }

        if(a>b){
            l1=headA;
            l2=headB;
            a=a-b;
        } else{
            l1=headB;
            l2=headA;
            a=b-a;
        }
        while(a>0){
            l1=l1.next;
            a--;
        }

        while(l1!=l2){
            l1=l1.next;
            l2=l2.next;

        }
        return l1;



    }
}
