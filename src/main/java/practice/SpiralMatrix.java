package practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix){

        List<Integer> results = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up=0;
        int left =0;
        int right=columns-1;
        int down=rows-1;
        while(results.size()<(columns*rows)){
            for(int col=left;col<=right;col++){
                results.add(matrix[up][col]);
            }
            for(int row=up+1;row<=down;row++){
                results.add(matrix[row][right]);
            }
            if(up!=down){
                for(int col=right-1;col>=left;col--){
                    results.add(matrix[down][col]);
                }

            }
            if(left!=right){
                for(int row=down-1;row>up;row--){
                    results.add(matrix[row][left]);
                }
            }


            up++;
            left++;
            right--;
            down--;

        }

        return results;
    }

    public static void main(String[] args) {
        int [][]matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
