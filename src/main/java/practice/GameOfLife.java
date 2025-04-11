package practice;

public class GameOfLife {
// without any additional space solution
    public static void gameOfLife(int[][] board){
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]==1){
                    int liveCount =  numberOfLiveNeighbors(board,i,j,rows,columns);
                    if(liveCount<2||liveCount>3)
                        board[i][j]=-1;
                } else {
                    int liveCount =  numberOfLiveNeighbors(board,i,j,rows,columns);
                    if(liveCount==3)
                        board[i][j]=2;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(board[i][j]==-1)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;

            }
        }

    }

    private static int numberOfLiveNeighbors(int[][] board, int i, int j, int rows, int columns) {
        int count =0 ;
        if(i-1>=0){
            if(Math.abs(board[i-1][j])==1)
                count++;
            if(j-1>=0 && Math.abs(board[i-1][j-1])==1)
                count++;
            if(j+1<columns && Math.abs(board[i-1][j+1])==1)
                count++;
        }
        if(i+1<rows){
            if(Math.abs(board[i+1][j])==1)
                count++;
            if(j-1>=0 && Math.abs(board[i+1][j-1])==1)
                count++;
            if(j+1<columns && Math.abs(board[i+1][j+1])==1)
                count++;
        }
        if(j-1>=0 && Math.abs(board[i][j-1])==1){
            count++;
        }

        if(j+1<columns && Math.abs(board[i][j+1])==1){
            count++;
        }
        return count;

    }

    public static void gameOfLife1(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        int [][] boardCopy = new int[rows][columns];
        for(int i=0;i<rows;i++){
            System.arraycopy(board[i], 0, boardCopy[i], 0, columns);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(boardCopy[i][j]==1){
                  int liveCount =  numberOfLiveNeighbors1(boardCopy,i,j,rows,columns);
                  if(liveCount<2||liveCount>3)
                      board[i][j]=0;
                  else board[i][j]=1;
                } else {
                    int liveCount =  numberOfLiveNeighbors1(boardCopy,i,j,rows,columns);
                    if(liveCount==3)
                        board[i][j]=1;
                }
            }
        }


    }

    private static int numberOfLiveNeighbors1(int[][] boardCopy, int i, int j, int rows, int columns) {
      int count =0 ;
      if(i-1>=0){
          if(boardCopy[i-1][j]==1)
              count++;
          if(j-1>=0 && boardCopy[i-1][j-1]==1)
              count++;
          if(j+1<columns && boardCopy[i-1][j+1]==1)
              count++;
      }
      if(i+1<rows){
          if(boardCopy[i+1][j]==1)
              count++;
          if(j-1>=0 && boardCopy[i+1][j-1]==1)
              count++;
          if(j+1<columns && boardCopy[i+1][j+1]==1)
              count++;
      }
      if(j-1>=0 && boardCopy[i][j-1]==1){
          count++;
      }

      if(j+1<columns && boardCopy[i][j+1]==1){
            count++;
      }
        return count;
    }

    public static void main(String[] args) {
        int [][] board ={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
}
