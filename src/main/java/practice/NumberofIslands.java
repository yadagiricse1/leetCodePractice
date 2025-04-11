package practice;

public class NumberofIslands {


    public int numIslands(char[][] grid) {

        int count=0;
        int rows=grid.length;
        int columns = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){

                if(grid[i][j]==1){
                    count++;
                    checkBoundries(i,j,rows,columns,grid);
                }
            }
        }

        return count;
    }

    private void checkBoundries(int i, int j, int rows, int columns, char[][] grid) {
        if(i>=0&&i<rows&&j>=0&&j<columns){
            if(grid[i][j]==1){
                grid[i][j]=0;
                checkBoundries(i-1,j,rows,columns,grid);
                checkBoundries(i,j-1,rows,columns,grid);
                checkBoundries(i+1,j-1,rows,columns,grid);
                checkBoundries(i,j+1,rows,columns,grid);
            }
        }
    }
}
