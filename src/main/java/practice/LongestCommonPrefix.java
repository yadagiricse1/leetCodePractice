package practice;

public class LongestCommonPrefix {
    public static  String longestCommonPrefix(String[] strs) {
        if(strs.length==1)
            return strs[0];
        else {
            String matchingSupString= strs[0];
            for(int i=1;i<strs.length;i++){
                String s2=strs[i];
                 matchingSupString=commonPrefix(matchingSupString,s2);
                if(matchingSupString.isEmpty())
                    return "";
            }
            return matchingSupString;
        }

    }

    private static String commonPrefix(String matchingSupString, String s2) {
        int smallLength= Math.min(matchingSupString.length(), s2.length());
        int i=0;
        for(;i<smallLength;i++){
            if(matchingSupString.charAt(i)!=s2.charAt(i))
                break;
        }
      return matchingSupString.substring(0,i);
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
     //   System.out.println(longestCommonPrefix(strs));

        String s1="flower";
        String s2="flow";
        while (s2.indexOf(s1) != 0) {
            s1 = s1.substring(0, s1.length() - 1);
        }
        System.out.println(s1);

    }
}
