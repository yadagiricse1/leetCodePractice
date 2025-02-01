package practice;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty() && t.isEmpty())
            return true;
        if(s.isEmpty())
            return true;
        if(t.isEmpty())
            return false;

        int firstIndex=t.indexOf(s.charAt(0));

        for(int i=0;i<s.length();i++){
            if(t.indexOf(s.charAt(i))!=-1){
                t=t.substring(t.indexOf(s.charAt(i))+1);
            } else {
                return false;
            }

        }
    return true;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(isSubsequence(s,t));
    }
}
