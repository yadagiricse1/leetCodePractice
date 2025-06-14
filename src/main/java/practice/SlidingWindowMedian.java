package practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {


        return null;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(9);
        System.out.println("Min Heap: " + minHeap); // Output: Min Heap: [1, 1, 4, 3, 5, 9]

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(1);
    //    maxresHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(9);

        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }


    }
}
