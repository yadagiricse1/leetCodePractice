package practice;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int length=s.length();

        double temp = 2.0 * (numRows - 1);
        int temp1= (int)Math.ceil(length/temp);
        int columns=temp1*(numRows-1);

/*
        while(length>0){
            total+=numRows*(numRows-1);
            length=length-2*(numRows-1);
        }
        int columns=total/numRows;*/

        System.out.println("rows "+numRows+ "columns "+columns);
        char[][] charArray= new char[numRows][columns];
        int row=0;
        int col=0;
        int j=0;
        boolean increasingOrder=true;
        while(j<s.length()){
            charArray[row][col]=s.charAt(j);
            j++;
            if(increasingOrder&&row<numRows-1){
                row++;
            } else{
                increasingOrder=false;
            }
            if(!increasingOrder){
                if(row==0){
                    row++;
                    increasingOrder=true;
                } else {
                    col++;
                    row--;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
         for(int i=0;i<numRows;i++){
             for(int k=0;k<columns;k++){
                 if(Character.isAlphabetic(charArray[i][k])||charArray[i][k]=='.'||charArray[i][k]==','){
                     sb.append(charArray[i][k]);
                 }

             }

         }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s="ANUSHAALAMPALLY";
        System.out.println(convert(s,5));
        System.out.println("AANLMUAPYSAALHL");


    }
}
