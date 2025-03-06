package practice;

import java.util.*;
import java.util.stream.Collectors;
//https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
//https://leetcode.com/contest/weekly-contest-436/problems/assign-elements-to-groups-with-constraints/description/
//Need optimized solution //current solution Time Limit Exceeded for 9 testcases
public class AssignElementsToGroupsWithConstraints {
    public static int[] assignElements(int[] groups, int[] elements) {
        int []results=new int[groups.length];
        Arrays.fill(results, -1);
        Map<Integer,List<Integer>> groupIndexes=new HashMap<>();
        Map<Integer,Integer> groupMinIndex=new HashMap<>();
        Map<Integer,Integer> elementIndex=new HashMap<>();
        for(int j=0;j<elements.length;j++){
            if(!elementIndex.containsKey(elements[j]))
                elementIndex.put(elements[j],j);
        }
        for(int j=0;j<groups.length;j++) {
            if (!groupIndexes.containsKey(groups[j]))
                groupIndexes.put(groups[j], new ArrayList<>());
            groupIndexes.get(groups[j]).add(j);
        }
        for (Map.Entry<Integer, List<Integer>> entry : groupIndexes.entrySet()){
            for (Map.Entry<Integer, Integer> elememntEntry : elementIndex.entrySet()){
               int group= entry.getKey();
                int element= elememntEntry.getKey();
                int elementEntryIndex=elememntEntry.getValue();
                int remainder=group%element;
                if(remainder==0){
                    if(groupMinIndex.containsKey(group)){
                        if(groupMinIndex.get(group)>elementEntryIndex)
                            groupMinIndex.put(group,elementEntryIndex);
                    } else {
                        groupMinIndex.put(group,elementEntryIndex);
                    }
                }

            }

        }
        for (Map.Entry<Integer, List<Integer>> entry : groupIndexes.entrySet()){
            int group= entry.getKey();
            List<Integer> indexes= entry.getValue();
            if(groupMinIndex.containsKey(group)){
                int elementInd=groupMinIndex.get(group);
                for(int i:indexes){
                    results[i]=elementInd;
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {
        int [] groups={8,4,3,2,4};
        int[] elements={4,2};
        int []groups1=assignElements(groups,elements);
        for (int i=0;i< groups1.length;i++){
            System.out.print(groups1[i]+" ");
        }

    }
}
