package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//There is one of the best apporach with Constant time complexity  O(1) listed in Leetcode
public class DesignTicTacToe {
    int []rows;
    int []columns;
    int diagonal;
    int antiDiagonal;
    int n;

    public DesignTicTacToe(int n) {
        this.rows = new int[n];
        this.columns = new int[n];
        this.n=n;
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player==1)?1:-1;
        rows[row]=currentPlayer;
        columns[col]=currentPlayer;
        if(row==col){
            diagonal+=currentPlayer;
        }

        if(row==(n-1-col)){
            antiDiagonal+=currentPlayer;
        }
        if (Math.abs(rows[row]) == n ||
                Math.abs(columns[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;
    }

/*
    // //Approach 2
    int [][] ticToc;
    int n;

    //Latest move desides wheather the person won or not. That means we have to check latest updated row only, Similarly latest update column, diagnoal , antidiagnoal
    public DesignTicTacToe(int n) {
        this.ticToc = new int[n][n];
        this.n=n;
    }

    public int move(int row, int col, int player) {
        ticToc[row][col] = player;

        if((checkRow(row, player)) ||
                (checkColumn(col, player)) ||
                (row == col && checkDiagonal(player)) ||
                (col == n - row - 1 && checkAntiDiagonal(player)))
            return player;


        return 0;
    }

    private boolean checkRow(int row , int player){
        for (int col = 0; col < n; col++) {
            if (ticToc[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int column, int player){
        for (int row = 0; row < n; row++) {
            if (ticToc[row][column] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player){
        for (int row = 0; row < n; row++) {
            if (ticToc[row][row] != player) {
                return false;
            }
        }
        return true;
    }
    private boolean checkAntiDiagonal(int player){
        for (int row = 0; row < n; row++) {
            if (ticToc[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }*/
/*


// below strategy is like brute force approach
    int [][] ticToc;
    Map<Integer, Map<Integer, Set<Integer>>> playerRowMap;
    Map<Integer, Map<Integer, Set<Integer>>> playerColumnMap;
    Map<Integer,Set<Integer>> playerDiagnolMap;
    Map<Integer,Set<Integer>> playerDiagnolMap2;
    int size;

    public DesignTicTacToe(int n) {
        ticToc = new int[n][n];
        size = n;
        playerRowMap = new HashMap<>();
        playerColumnMap = new HashMap<>();
        playerRowMap.put(1,new HashMap<>());
        playerRowMap.put(2,new HashMap<>());
        playerColumnMap.put(1,new HashMap<>());
        playerColumnMap.put(2,new HashMap<>());

        for(int i=0;i<size;i++){
            for(int p=1;p<=2;p++){
                playerRowMap.get(p).put(i,new HashSet<>());
                playerColumnMap.get(p).put(i,new HashSet<>());
            }
        }
        playerDiagnolMap = new HashMap<>();
        playerDiagnolMap.put(1,new HashSet<>());
        playerDiagnolMap.put(2,new HashSet<>());


        playerDiagnolMap2 = new HashMap<>();
        playerDiagnolMap2.put(1,new HashSet<>());
        playerDiagnolMap2.put(2,new HashSet<>());
    }
//
    public int move(int row, int col, int player) {
        ticToc[row][col]=player;

        Map<Integer, Set<Integer>> integerRowSetMap = playerRowMap.get(player);
        Set<Integer> integerColumns = integerRowSetMap.get(row);
        integerColumns.add(col);
        integerRowSetMap.put(row,integerColumns);
        playerRowMap.put(player,integerRowSetMap);
        if(integerColumns.size()==size)
            return player;

        Map<Integer, Set<Integer>> integerColumnSetMap = playerColumnMap.get(player);
        Set<Integer> integerRows = integerColumnSetMap.get(col);
        integerRows.add(row);
        integerColumnSetMap.put(col,integerRows);
        playerColumnMap.put(player,integerColumnSetMap);

        if(integerRows.size()==size)
            return player;
        if(row==col){
            playerDiagnolMap.get(player).add(row);
            if(playerDiagnolMap.get(player).size()==size)
                return player;
        }

        if(row==(size-1-col)){
            playerDiagnolMap2.get(player).add(row);
            if(playerDiagnolMap2.get(player).size()==size)
                return player;
        }

        return 0;
    }*/

    public static void main(String[] args) {
        DesignTicTacToe ticTacToe= new DesignTicTacToe(2);
        ticTacToe.move(0,1,2);
        ticTacToe.move(1,0,1);
        System.out.println( ticTacToe.move(1,1,2));


    }
}
