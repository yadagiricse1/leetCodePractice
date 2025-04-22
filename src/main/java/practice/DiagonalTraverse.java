package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder2(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    public  static int[] findDiagonalOrder(int[][] mat){
        int n =mat.length;
        int m=mat[0].length;
        int total =m*n;
        int [] results = new int[total];
        List<Integer> intermediate = new ArrayList<>();
        int k=0;
        for(int i=0;i<n+m-1;i++){


            intermediate.clear();
            int r=i<m?0:i-m+1;
            int c=i<m?i:m-1;

            while(r<m&&c>-1){
                intermediate.add(mat[r][c]);
                r++;
                c--;
            }

            if(i%2==0){
                Collections.reverse(intermediate);
            }
            for (int j = 0; j < intermediate.size(); j++) {
                results[k++] = intermediate.get(j);
            }

        }

        return results;
    }
    public  static int[] findDiagonalOrder1(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int  size=rows*columns;
        int [] result= new int[size];
        int k=0;
        int i=0;
        int j=0;
        result[k]=mat[i][j];
         j=1;

        while(k<size){

            while(j>=0){
                System.out.println("indexes "+i+" "+j);
                System.out.println(mat[i][j]);
                result[++k]=mat[i][j];
                if(j!=0 && i<rows){
                    i++;
                    j--;
                } else{
                    break;
                }
            }
            i++;
            while(i>=0){
                System.out.println("indexes "+i+" "+j);
                System.out.println(mat[i][j]);
                result[++k]=mat[i][j];
                if(i!=0){
                    i--;
                    j++;
                } else{
                    break;
                }
            }
            i++;
        }

         return result;
    }

    public static void main(String[] args) {

        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

       int[] result = findDiagonalOrder(mat);
       for(int num:result)
           System.out.println(num);


    }
}
