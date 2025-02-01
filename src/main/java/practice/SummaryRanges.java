package practice;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges1(int[] nums) {

        return null;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums.length==0)
            return ranges;
        else if(nums.length==1){
            ranges.add(""+nums[0]);
            return ranges;
        }
        int i=1;
        for(;i<nums.length;){
            int start=nums[i-1];
            int current=nums[i-1];
            int next =nums[i];
            if(next - current == 1){
                while(i<nums.length&&(next-current)==1){
                    current=nums[i-1];
                    next =nums[i];
                    i++;
                }
                ranges.add(start+"->"+current);

            } else {
                ranges.add(""+current);
                i++;

            }

        }
         if((nums[nums.length-1]-nums[nums.length-2])==1){
            String s = ranges.get(ranges.size()-1);
             if(s.contains("->")){
                 String s1 = s.split("->")[0];
                 ranges.remove(ranges.size()-1);
                 ranges.add(s1+"->"+nums[nums.length-1]);
             } else {
                 ranges.remove(ranges.size()-1);
                 ranges.add(s+"->"+nums[nums.length-1]);
             }
         } else {
             ranges.add(""+nums[nums.length-1]);
         }
        return ranges;
    }

    public static void main(String[] args) {
        int []nums={0,1,2,3,8,9,10};
        System.out.println(summaryRanges(nums));

    }
}
