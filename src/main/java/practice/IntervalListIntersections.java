package practice;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {


    public  static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstLength = firstList.length;
        int secondLength = secondList.length;
        int i=0;
        int j=0;
        List<int[]> results = new ArrayList<>();
        while(i<firstLength&&j<secondLength){
         int a1=   firstList[i][0];
         int b1=   firstList[i][1];
         int a2=   secondList[j][0];
         int b2=   secondList[j][1];
        int a3= Math.max(a1,a2);
        int b3 =Math.min(b1,b2);
        if(a3<=b3)
          results.add(new int[]{a3, b3});

          if(b1==b3)
              i++;
          if(b2==b3)
              j++;

        }
        int[][] resultArray = new int[results.size()][2];
        for(int k=0;k< results.size();k++){
            resultArray[k]=results.get(k);
        }

     return resultArray;
    }

    public static void main(String[] args) {
        int[][] firstList={{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList ={{1,5},{8,12},{15,24},{25,26}};

        int[][] intersect =   intervalIntersection(firstList,secondList);
        for(int []inter:intersect){
            System.out.println(inter[0]+" "+inter[1]);
        }


    }
}
