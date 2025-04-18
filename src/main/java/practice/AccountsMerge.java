package practice;

import java.util.*;


public class AccountsMerge {
   static Set<String> visited = new HashSet<>();
   static  Map<String, List<String>> adjacent = new HashMap<>();


    public static List<List<String>> accountsMerge(List<List<String>> accounts){

        for(List<String> account: accounts){

        String firstEmail = account.get(1);
         for(int i=2;i<account.size();i++){
             String adjacentEmail =  account.get(i);

             if(!adjacent.containsKey(firstEmail)){
                 adjacent.put(firstEmail, new ArrayList<>());
             }
             adjacent.get(firstEmail).add(adjacentEmail);

             if(!adjacent.containsKey(adjacentEmail)){
                 adjacent.put(adjacentEmail, new ArrayList<>());
             }
             adjacent.get(adjacentEmail).add(firstEmail);

         }

        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(List<String> account: accounts){
         String name =  account.get(0);
            List<String> mergedAccount =new ArrayList<>();
            String firstEmail = account.get(1);

           if(!visited.contains(firstEmail)){
               mergedAccount.add(name);
               DFS(mergedAccount,firstEmail);
               Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
               mergedAccounts.add(mergedAccount);

            }

        }


        return mergedAccounts;
    }

    private static void DFS(List<String> mergedAccount, String firstEmail) {
        visited.add(firstEmail);
        mergedAccount.add(firstEmail);

        if(!adjacent.containsKey(firstEmail))
            return;
       List<String> accounts = adjacent.get(firstEmail);
       for(String email:accounts){

           if(!visited.contains(email)){
               DFS(mergedAccount,email);
           }

       }

    }

    // need to work for better solution
    public static List<List<String>> accountsMerge1(List<List<String>> accounts) {
        Map<String,Set<String>> tempMap =new HashMap<>();

        for(List<String> account:accounts){
            for(int i=1;i<account.size();i++){
                if(!tempMap.containsKey(account.get(i))){
                    tempMap.put(account.get(i),new HashSet<>(account));
                } else {
                    tempMap.get(account.get(i)).addAll(account);
                }
            }
        }
        Set<List<String>> results = new HashSet<>();

        for(String email: tempMap.keySet()){

            Set<String> consolidatedAccount =  tempMap.get(email);
            if(consolidatedAccount.size()==2){
              List<String> result =  new ArrayList<>();
              for(String str:consolidatedAccount){
                  if(!str.contains("@"))
                      result.add(0,str);
                  else
                      result.add(str);

              }

                results.add(result);
            } else {
                Queue<String> emailsQueue = new LinkedList<>();
                emailsQueue.add(email);
                String name = null;
                List<String> result = new ArrayList<>();

                while(!emailsQueue.isEmpty()){
                    String em =emailsQueue.poll();
                    Set<String> consolidatedAccount1 =   tempMap.get(em);
                    for(String element: consolidatedAccount1){
                        if(element.contains("@")){
                            if(!result.contains(element)){
                                result.add(element) ;
                                emailsQueue.add(element);
                            }
                        } else{
                            name =element;
                        }

                    }


                }
                Collections.sort(result);
                result.add(0,name);
                results.add(result);
            }


        }

        return results.stream().toList();

    }

    public static void main(String[] args) {
        List<List<String>> accounts  = new ArrayList<>();
        accounts.add(List.of("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(List.of("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(List.of("Mary","mary@mail.com"));
        accounts.add(List.of("John","johnnybravo@mail.com"));
        List<List<String>> results =   accountsMerge(accounts);
        System.out.println(results);

    }
}
