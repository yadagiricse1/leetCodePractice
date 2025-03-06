package practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SortMatrixByDiagnal {
    public static int[][] sortMatrix(int[][] grid) {
        Map<Integer, List<Integer>> indexDiffElemeptsMap= new ConcurrentHashMap<>();

        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                int index= i-j;
                if(!indexDiffElemeptsMap.containsKey(index)){
                    indexDiffElemeptsMap.put(index,new ArrayList<>()) ;
                }
                indexDiffElemeptsMap.get(index).add(grid[i][j]);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : indexDiffElemeptsMap.entrySet()){
            int index = entry.getKey();
            List<Integer> value = entry.getValue();
            if(index<0)
                value = value.stream().sorted().collect(Collectors.toList());
            else
                value= value.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            indexDiffElemeptsMap.put(index,value);
        }
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                int index= i-j;
                List<Integer> values=  indexDiffElemeptsMap.get(index);
                grid[i][j]=values.get(0);
                values.remove(0);
            }

        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid= {{1,7,3},{9,8,2},{4,5,6}};
        grid=  sortMatrix(grid);
       for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                System.out.print(grid[i][j]+" ");

            }
            System.out.println();
        }

    }
}
