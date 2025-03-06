package practice;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
      int totalGain=0;
      int currentGain=0;
      int answer=0;
      for(int i=0;i<gas.length;i++){
          totalGain+=(gas[i]-cost[i]);
          currentGain+=(gas[i]-cost[i]);
          if(currentGain<0){
              currentGain=0;
              answer=i+1;
          }
      }

        return totalGain>=0?answer:-1;
    }

    public static void main(String[] args) {
       /* int []gas = {1, 2, 3, 4, 5};
        int []cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
        int []gas1 = {2,3,4};
        int []cost1 = {3,4,3};
        System.out.println(canCompleteCircuit(gas1,cost1));*/

        int []gas2 = {5,8,2,8};
        int []cost2 = {6,5,6,6};
        System.out.println(canCompleteCircuit(gas2,cost2));

  /*      int []gas3 = {2};
        int []cost3 = {2};
        System.out.println(canCompleteCircuit(gas3,cost3));*/


    }
}
