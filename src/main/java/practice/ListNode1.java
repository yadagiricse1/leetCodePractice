package practice;

public class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1 prev;

    public ListNode1() {}

    public ListNode1(int val) {
        this.val = val;
    }

    public ListNode1(int val, ListNode1 next, ListNode1 prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
