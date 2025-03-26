package practice;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            int []columHash= new int[10];
            int []rowHash=new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if (++rowHash[board[i][j] - 48] > 1) {
                        return false;
                    }
                }
                if(board[j][i]!='.'){
                    if (++columHash[board[j][i] - 48] > 1) {
                        return false;
                    }
                }

            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                int []hash =new int[10];
                for(int k=0;k<3;k++) {
                    for (int l = 0; l < 3; l++) {
                        if(board[i+k][j+l]!='.'){
                            if (++hash[board[i+k][j+l] - 48] > 1) {
                                return false;
                            }
                        }
                     }
                    }
                }
            }
        return true;
    }
    public static boolean isValidSudoku1(char[][] board) {

        for(int i=0;i<9;i++){
            Set<Character> digits= new HashSet<>();
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(Character.isDigit(ch)){
                    if(digits.contains(ch))
                        return false;
                    else
                        digits.add(ch);
                }
            }
        }
        for(int i=0;i<9;i++){
            Set<Character> digits= new HashSet<>();
            for(int j=0;j<9;j++){
                char ch=board[j][i];
                if(Character.isDigit(ch)){
                    if(digits.contains(ch))
                        return false;
                    else
                        digits.add(ch);
                }
            }
        }

        if (!isSubSquare(board, 0, 3, 0, 3, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 0, 3, 3, 6, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 0, 3, 6, 9, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 3, 6, 0, 3, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 3, 6, 3, 6, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 3, 6, 6, 9, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 6, 9, 0, 3, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 6, 9, 3, 6, new HashSet<>()))
            return false;
        if (!isSubSquare(board, 6, 9, 6, 9, new HashSet<>()))
            return false;


        return true;

    }

    private static boolean isSubSquare(char[][] board, int r, int rows, int c, int columns, Set<Character> digits) {

        for(; r < rows; r++){
            int c1=c;
            for(; c1 < columns; c1++){
                char ch= board[r][c1];
                if(Character.isDigit(ch)){
                    if(digits.contains(ch))
                        return false;
                    else
                        digits.add(ch);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] board = 
{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
      /*  board = new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                             {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                             {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                             {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                             {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                             {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                             {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};*/

        System.out.println(isValidSudoku(board));
    }
}
