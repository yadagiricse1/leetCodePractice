package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer,ListNode1> cache ;
    ListNode1 tail;
    ListNode1 head ;
    int maxCapacity ;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        tail = new ListNode1(0);
        head = new ListNode1(0);
        maxCapacity =capacity;
        tail.next = head;
        head.prev = tail;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            ListNode1 node  = cache.get(key);
            remove(node);
            addNode(node);
            return node.val;
        }
        return -1;

    }

    public void put(int key, int value) {

        if(cache.containsKey(key)){
            ListNode1 node  = cache.get(key);
            remove(node);


        }
        ListNode1 node =  new ListNode1(value);
        cache.put(key,node);
        addNode(node);
        if(cache.size()>=maxCapacity){
                ListNode1 nodeToBeDeleted =head.next;
                remove(nodeToBeDeleted);
        }
    }
    private void remove(ListNode1 node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(ListNode1 node){
        ListNode1 temp = tail.prev;
        temp.next =node ;
        node.prev = temp ;
        node.next = tail;
        tail.prev= node;
    }
}
