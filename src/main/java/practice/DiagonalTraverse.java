package practice;

public class DiagonalTraverse {
    public  static int[] findDiagonalOrder(int[][] mat) {
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
