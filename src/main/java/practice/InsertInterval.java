package practice;

import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval){
        int n=intervals.length;
        if(intervals.length==0)
            return new int[][]{newInterval};
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i<n&&intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0] =Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] =Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
    public static int[][] insert3(int[][] intervals, int[] newInterval){
        if(intervals.length==0)
            return new int[][]{newInterval};
        boolean newIntervalAdded =false;
        List<int[]> result = new ArrayList<>();
        for(int [] interval:intervals){
            if(!newIntervalAdded){
                if(interval[0]<newInterval[0]){
                    result.add(interval);
                } else{
                    result.add(newInterval);
                    result.add(interval);
                    newIntervalAdded =true;
                }
            } else {
                result.add(interval);
            }
        }
        if(!newIntervalAdded)
            result.add(newInterval);

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval : result){
            if(mergedIntervals.isEmpty()||mergedIntervals.getLast()[1]<interval[0]){
                mergedIntervals.add(interval);
            }else{
                mergedIntervals.getLast()[1] =Math.max(mergedIntervals.getLast()[1],interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval){
        if(intervals.length==0)
            return new int[][]{newInterval};
        List<int[]> result = new ArrayList<>();
       for(int [] interval:intervals){
           if(newInterval[1]<interval[0]){
               result.add(newInterval);
               newInterval = interval;
           } else if(interval[1]<newInterval[0]){
               result.add(interval);
           } else{
               newInterval[0] =Math.min(newInterval[0],interval[0]);
               newInterval[1] =Math.max(newInterval[1],interval[1]);

           }
       }
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }


    //Not a better solution used code from MergeIntervals problem
    public static int[][] insert1(int[][] intervals, int[] newInterval) {

       int [][] newIntervals = new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[newIntervals.length-1]=newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval : newIntervals){
            if(mergedIntervals.isEmpty()||mergedIntervals.getLast()[1]<interval[0]){
                mergedIntervals.add(interval);
            }else{
                mergedIntervals.getLast()[1] =Math.max(mergedIntervals.getLast()[1],interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {

        /*int[][] intervals = {{1,3},{6,9}};
        int[] newInterval ={2,5};*/

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        /*int[][] intervals ={};*/
        int[] newInterval ={4,8};


        int [][] results = insert(intervals,newInterval);
        for(int []interval:results){
            System.out.println("[ "+interval[0]+" , "+interval[1]+"]");
        }

    }
}
