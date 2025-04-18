package practice;

import java.util.*;

public class MakingALargeIsland {


    public static int largestIsland(int[][] grid) {
        int rows=grid.length;
        int columns = grid[0].length;

       int isIslandId =2;
        Map<Integer,Integer> islandIdSizes = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==1){
                  int size =  checkBoundries(i,j,rows,columns,grid,islandIdSizes,isIslandId);
                    islandIdSizes.put(isIslandId,size);
                    isIslandId++;
                }
            }
        }
        if(islandIdSizes.isEmpty())
            return 1;
        if(islandIdSizes.size()==1)
            return islandIdSizes.get(isIslandId-1)==rows*columns?islandIdSizes.get(isIslandId-1):islandIdSizes.get(isIslandId-1)+1;
       int maxIslandSize=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                Set<Integer> neighbours = new HashSet<>();
                int currentIslandSize = 1;
                if(grid[i][j]==0){
                    if((i-1)>=0&&grid[i-1][j]>1)
                        neighbours.add(grid[i-1][j]);
                    if((i+1)<rows&&grid[i+1][j]>1)
                        neighbours.add(grid[i+1][j]);
                    if((j-1)>=0&&grid[i][j-1]>1)
                        neighbours.add(grid[i][j-1]);
                    if((j+1)<columns&&grid[i][j+1]>1)
                        neighbours.add(grid[i][j+1]);
                }

                for(int id:neighbours){
                    currentIslandSize+= islandIdSizes.get(id);
                }
                maxIslandSize=Math.max(maxIslandSize,currentIslandSize);

            }
        }

        return maxIslandSize;
    }
    private static int checkBoundries(int i, int j, int rows, int columns, int [][] grid,Map<Integer,Integer> islandIdSizes ,int isIslandId) {

        if(i>=0&&i<rows&&j>=0&&j<columns && grid[i][j]==1){
               int size=1;
                grid[i][j]=isIslandId;
                size+=checkBoundries(i-1,j,rows,columns,grid,islandIdSizes,isIslandId);
                size+=checkBoundries(i,j-1,rows,columns,grid,islandIdSizes,isIslandId);
                size+=checkBoundries(i+1,j,rows,columns,grid,islandIdSizes,isIslandId);
                size+=checkBoundries(i,j+1,rows,columns,grid,islandIdSizes,isIslandId);
                return size;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][]grid = {{1,1},{1,1}};
        System.out.println(largestIsland(grid));
    }
}
