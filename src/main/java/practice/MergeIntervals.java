package practice;

import java.util.*;

public class MergeIntervals {

    public  static int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        for(int[] interval : intervals){
            if(mergedIntervals.isEmpty()||mergedIntervals.getLast()[1]<interval[0]){
                mergedIntervals.add(interval);
            }else{
                mergedIntervals.getLast()[1] =Math.max(mergedIntervals.getLast()[1],interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
    public  static int[][] merge1(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //Arrays.sort(intervals, (arg0, arg1) -> arg0[0]-arg1[0]);
        int [] interval = intervals[0];
        for(int i=1;i<intervals.length;i++){

            int []  interval1=  intervals[i];
            if(interval[0]>interval1[0]){
                int [] temp=interval;
                interval=interval1;
                interval1 =temp;
            }

            if(interval[1]>=interval1[0]){
                if(interval[1]<=interval1[1]){
                    interval[1]=interval1[1];
                }
            } else {
                  mergedIntervals.add(interval);
                interval=interval1;
            }
            if(intervals.length-1==i){
                mergedIntervals.add(interval);
            }
        }

        int[][] results = new int[mergedIntervals.size()][2];
        int i=0;
        for(int [] mergedInterval:mergedIntervals){
            results[i]=mergedInterval;
            i++;
        }
        return results;
    }


    public static void main(String[] args) {

       // int [][] intervals ={{1,3},{2,6},{8,10},{15,18}};
        int [][] intervals = {{1,4},{4,5}};
       // int [][] intervals = {{4,5},{1,4},{0,1}};

        int [][] results = merge(intervals);
        for(int []interval:results){
            System.out.println("[ "+interval[0]+" , "+interval[1]+"]");
        }


    }
}
