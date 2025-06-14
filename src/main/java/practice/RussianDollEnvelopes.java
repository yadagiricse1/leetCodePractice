package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        int count=1;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0]==a2[0]){
                    return a2[1]-a1[1];
                } else{
                    return a2[0]-a1[0];
                }
            }
        });
        for(int[] envelop: envelopes){
            System.out.println(envelop[0]+" "+envelop[1]);
        }


       /* PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int[] envelop:envelopes){
            pq.add(new int []{envelop[0]*envelop[1],envelop[0],envelop[1]});
        }
        int [] temp = pq.poll();

        Stack<int[]> tempStack= new Stack<>();
        while(!pq.isEmpty()){
          int[] temp1 = pq.poll();
           int w1 = temp1[1];
           int h1 = temp1[2];
            int w = temp[1];
            int h = temp[2];
            if(w>w1&&h>h1){
                temp = temp1;
                count++;
            }

        }*/
        return count;
    }

    public static void main(String[] args) {

       // int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
//[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]

        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(maxEnvelopes(envelopes));


    }
}
