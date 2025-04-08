package practice;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;

        ListNode tempHead = new ListNode(Integer.MIN_VALUE);
        tempHead.next = head;

        Stack<Integer> reversingNumber = new Stack<>();
        ListNode node = tempHead;
        int i=0;
        ListNode stackNode = null;
        ListNode prev =  null;


        while(i<(left)){
            prev = node;
            node = node.next;
            i++;
        }
        stackNode = node;

        while(reversingNumber.size()<(right-left+1)){
            reversingNumber.push(stackNode.val);
            stackNode = stackNode.next;
        }
        ListNode nextNode = null;
          if(prev==null){
              nextNode =tempHead;
          } else{
              nextNode = prev;
          }
        while(!reversingNumber.isEmpty()){
            nextNode.next = new ListNode(reversingNumber.pop());
            nextNode=nextNode.next;
        }
        nextNode.next = stackNode;

        return tempHead.next;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for(int i=1;i<arr.length;i++){
            node.next = new ListNode(arr[i]);
            node=node.next;
        }
        head = reverseBetween(head,2,4);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }



    }
}
