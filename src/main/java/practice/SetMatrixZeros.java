package practice;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    public static void setZeroes(int[][] matrix) {

        int m=matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }
       /* for( int row:rows){
            for(int j=0;j<n;j++){
                matrix[row][j]=0;
            }
        }
        for( int column:columns){
            for(int i=0;i<m;i++){
                matrix[i][column]=0;
            }
        }*/

        /*for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length;j++){
                if(rows.contains(i) || columns.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }*/
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length;j++){
                if(rows[i]==-1 || cols[j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {

        int [][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("before");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        setZeroes(matrix);
        System.out.println("after");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
