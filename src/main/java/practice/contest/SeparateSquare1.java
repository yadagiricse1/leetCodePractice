package practice.contest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SeparateSquare1 {

    //https://leetcode.com/problems/separate-squares-i/description/
    // not properly solved
    public static double separateSquares(int[][] squares) {

        double totalSquareArea= 0.0;
        double lowY=0;
        double highY=Double.MIN_VALUE;
        for(int [] square:squares){
            totalSquareArea += square[2]*square[2];
            lowY=Math.min(square[1],lowY);
            highY=Math.max(square[1]+square[2],highY);
        }
        double targetArea=totalSquareArea/2.0;
        double mid=(lowY+highY)/2.0;
      while(lowY<highY &&Math.abs(highY-lowY)>0.00001){
          mid=(lowY+highY)/2.0;
          double tempBottomSquaresAreaSum= 0.0;
          for(int [] square:squares){
              if(square[1]<mid&& square[1]+square[2]<mid){
                  tempBottomSquaresAreaSum += square[2]*square[2];
              } else  if(square[1]<mid&& square[1]+square[2]>mid){
                  double topY=(square[1]+square[2]-mid)/(1.0*square[2]);
                  tempBottomSquaresAreaSum +=  ((1-topY)*square[2]*square[2]);
              }
          }
          if(tempBottomSquaresAreaSum<targetArea){
              lowY=mid;
          } else {
              highY=mid;
          }

      }
        BigDecimal bd = new BigDecimal(highY);
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        highY = bd.doubleValue();

      return highY;
    }

    public static void main(String[] args) {
       // int [][] squares={{0,0,2},{1,1,1}};
        int [][] squares={{0,0,1},{2,2,1}};
      //  System.out.println(separateSquares(squares));
      //  squares= new int[][]{{0, 0, 2}, {1, 1, 1}};
        squares=new int[][]{{3,26,3},{4,30,1},{13,27,5}};
        System.out.println(separateSquares(squares));

    }
}
