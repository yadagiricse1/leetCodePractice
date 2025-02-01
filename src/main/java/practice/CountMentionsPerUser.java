package practice;

import java.util.ArrayList;
import java.util.*;

public class CountMentionsPerUser {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] userMentions= new int[numberOfUsers];

        int[] userIDTimeOffline= new int[numberOfUsers];
        Arrays.fill(userIDTimeOffline,-1);
        Map<Integer,Integer> userOnlineTimeStamp = new HashMap<>();
        for(List<String> event:events){
            if(Objects.equals(event.get(0), "MESSAGE")){
               String users= event.get(2);
               int timeStamp=Integer.valueOf(event.get(1));
               if(users.equals("ALL")){
                   for(int i=0;i<numberOfUsers;i++){
                       userMentions[i]=userMentions[i]+1;
                   }
               }else if(users.equals("HERE")){
                   for(int i=0;i<numberOfUsers;i++){
                       if(userIDTimeOffline[i]!=-1){
                        if(((timeStamp-60)>=userIDTimeOffline[i])){
                            userMentions[i]++;
                        }
                       } else {
                           userMentions[i]++;
                       }
                   }



               } else {
                 String[] userIds = users.split(" ");
                 for(String s:userIds) {
                     int userId=Integer.valueOf(s.replace("id",""));
                     userOnlineTimeStamp.put(userId,timeStamp);
                     userMentions[userId]++;
                 }

               }


            } else if(Objects.equals(event.get(0), "OFFLINE")){
                userIDTimeOffline[Integer.valueOf(event.get(2))]=Integer.valueOf(event.get(1));
            }



        }


        return userMentions;
    }
    public static void main(String[] args) {
        //[["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]©leetcode
       List<List<String>> events =new ArrayList<>();
        /* events.add(List.of("MESSAGE","10","id1 id0"));
        events.add(List.of("OFFLINE","11","0"));
        events.add(List.of("MESSAGE", "71", "HERE"));*/
    /*    events.add(List.of("OFFLINE","10","0"));
        events.add(List.of("MESSAGE","12","HERE"));*/
        events.add(List.of("MESSAGE","2","HERE"));
        events.add(List.of("OFFLINE","2","1"));
        events.add(List.of("OFFLINE","1","0"));
        events.add(List.of("MESSAGE","61","HERE"));
        int results[]=countMentions(3,events);
        for(int i :results){
            System.out.println(i +" ");
        }


    }
}
