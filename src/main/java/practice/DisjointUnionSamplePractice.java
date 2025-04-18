package practice;

import java.util.*;

public class DisjointUnionSamplePractice {

    // group all Strings if any of the have matching strings. Find how may groups and what are the strings in each group

    public static List<List<String>> groupedStrings(List<List<String>> names){

        Map<String,Integer> nameAccountId = new HashMap<>();
        Map<Integer,Set<String>> accountIdName = new HashMap<>();
       int accountID=0;
        for(List<String> nameValues:names){
           Set<Integer> accounts = new HashSet<>();

           for(String name:nameValues){
               if(nameAccountId.containsKey(name)){
                   accounts.add(nameAccountId.get(name));
               }
           }

           if(accounts.isEmpty()){
               for(String name:nameValues){
                   nameAccountId.put(name,accountID);
                   accountIdName.computeIfAbsent(accountID, k -> new HashSet<>()).add(name);
               }
               accountID++;
           } else if(accounts.size()==1){
             int foundAccount =  accounts.iterator().next();
               for(String name:nameValues){
                   nameAccountId.put(name,foundAccount);
                   accountIdName.get(foundAccount).add(name);
               }

           } else {
             List<Integer> foundAccounts =  new ArrayList<>(accounts);
             Collections.sort(foundAccounts);
             int minAccount = foundAccounts.get(0);

             for(int i=1;i<foundAccounts.size();i++){
                 accountIdName.get(minAccount).addAll(accountIdName.get(foundAccounts.get(i)));
             }
             for(int i=1;i<foundAccounts.size();i++){
                 accountIdName.remove(foundAccounts.get(i));
             }

               for(String name:nameValues){
                   nameAccountId.put(name,minAccount);

               }
               accountIdName.get(minAccount).addAll(nameValues);


           }

        }
        List<List<String>> finalResults = new ArrayList<>();
        for(Set<String> values:accountIdName.values()){
            finalResults.add(new ArrayList<>(values));

        }
        //  return new ArrayList<>(accountIdName.values());
        return finalResults;
    }

    public static void main(String[] args) {
        List<List<String>> names = new ArrayList<>();
        names.add(List.of("a","b","c"));
        names.add(List.of("e","f","g"));
        names.add(List.of("c","d","e"));
        names.add(List.of("m","n","o"));

        System.out.println(groupedStrings(names));

    }
}
