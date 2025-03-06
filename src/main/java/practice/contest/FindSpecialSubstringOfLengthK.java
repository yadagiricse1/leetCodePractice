package practice.contest;

public class FindSpecialSubstringOfLengthK {
    public static boolean hasSpecialSubstring(String s, int k) {
        if(s.length()==k){
          String r=s.charAt(0)+"";
          s=s.replace(r,"");
            return s.length()==0;
        }

       char [] charArry= s.toCharArray();
       int count=1;
       for(int i=0;i<s.length()-1;i++){
            if(charArry[i]==charArry[i+1]){
                if(count<k){
                    count++;
                }
                else {
                    while(i<s.length()-1&& charArry[i]==charArry[i+1]){
                        i++;
                    }
                    if(i==s.length()-1)
                        return false;
                    count=1;

                }

            } else {
                if(count==k)
                    return true;
                count=1;
            }
       }
        if(count==k)
            return true;
        return false;

    }

    public static void main(String[] args) {
        String s="jkjhfgg";
        int k=2;


        System.out.println(hasSpecialSubstring(s,k));
    }
}
