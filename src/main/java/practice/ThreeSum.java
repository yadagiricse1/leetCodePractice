package practice;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length && nums[i] <= 0;i++) {
            if(i==0||nums[i-1]!=nums[i]){

            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum =nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> result = List.of(nums[i], nums[low++], nums[high--]);
                    results.add(result);
                    while (low < high && nums[low] == nums[low - 1])
                        low++;

                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }

        }


        }
        return results;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        Set<List<Integer>> indexResults = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();

        Map<Integer,List<Integer>> numIndexMap = new HashMap();
        for(int i =0;i<nums.length;i++){
            if(!numIndexMap.containsKey(nums[i])){
                numIndexMap.put(nums[i],new ArrayList<>());
            }
            if(nums[i]==0){
                if(numIndexMap.get(nums[i]).size()<3)
                    numIndexMap.get(nums[i]).add(i);

            } else{
                numIndexMap.get(nums[i]).add(i);
            }

        }
        if(nums.length==numIndexMap.get(nums[0]).size()&&nums[0]==0){
           return List.of(List.of(0,0,0));
        } else if(numIndexMap.size()==3){
            int sum=0;
            boolean has3Zeros =false;
            for(int num:numIndexMap.keySet()){
                if(num==0){
                    if(numIndexMap.get(num).size()>=3)
                        has3Zeros=true;
                }

                sum+=num;
            }
            if(sum==0){
                results.add(numIndexMap.keySet().stream().toList());
                if(has3Zeros)
                    results.add(List.of(0,0,0));
                return results ;
            }

        }

        for(int i =0;i<nums.length;i++){
            int target= -1*nums[i];
            for (int j=i+1;j<nums.length;j++){
                if(i!=j){
                    int complement = target-nums[j];
                    if(numIndexMap.containsKey(complement)){
                   List<Integer>  probableList= numIndexMap.get(complement);
                   for(int k:probableList){
                       if(k > i && k > j ){
                           List<Integer> result=new ArrayList<>();
                           result.add(nums[i]);
                           result.add(nums[j]);
                           result.add(nums[k]);
                           Collections.sort(result);
                           if(!indexResults.contains(result))
                                indexResults.add(result);
                       }

                     }
                    }

                }
            }

        }

        for(List<Integer> result: indexResults){
            results.add(result);
        }

        return results;
    }


    public static void main(String[] args) {
        // int nums[] ={-1,0,1,2,-1,-4};
       // int nums[]={-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        int nums[] ={-2,0,1,1,2};
        System.out.println(threeSum(nums));

    }
}
