package practice;

import java.util.*;

public class ShortestPathinBinaryMatrix {

    public  static int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if(grid[0][0]!=0|| grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for(int[] neighbour:getNeighbours(grid,row,col,rows,columns)){
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                grid[neighbourRow][neighbourCol]=distance+1;
                queue.add(new int[]{neighbourRow, neighbourCol});
            }
        }
        return -1;
    }
    private static List<int[]>  getNeighbours(int[][] grid, int i, int j, int rows, int columns) {
        List<int[]> neighbours = new ArrayList<>();
        if(i-1>=0){
            if(grid[i-1][j]==0){
                    neighbours.add(new int[]{i-1,j});
            }
            if(j-1>=0 && grid[i-1][j-1]==0){
                    neighbours.add(new int[]{i-1,j-1});
            }

            if(j+1<columns && grid[i-1][j+1]==0){
                neighbours.add(new int[]{i-1,j+1});
            }

        }
        if(i+1<rows){
            if(grid[i+1][j]==0){
                neighbours.add(new int[]{i+1,j});
            }

            if(j-1>=0 && grid[i+1][j-1]==0){
                neighbours.add(new int[]{i+1,j-1});

            }
            if(j+1<columns && grid[i+1][j+1]==0){
                neighbours.add(new int[]{i+1,j+1});
            }

        }
        if(j-1>=0 && grid[i][j-1]==0){
            neighbours.add(new int[]{i,j-1});
        }

        if(j+1<columns && grid[i][j+1]==0){
            neighbours.add(new int[]{i,j+1});
        }

        return neighbours;
    }


    public static void main(String[] args) {

        int [][]grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }
}
