package practice;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        char [] abbrArray=abbr.toCharArray();
        StringBuilder sb =new StringBuilder(word);
        int count=0;
        for(int i=0;i<abbrArray.length;i++){
            int start=i;
            if(Character.isDigit(abbrArray[i])){
                int temp=Integer.valueOf(""+abbrArray[i]);
                if(temp ==0 )
                    return false;
                else {
                    while((i+1)<abbrArray.length && Character.isDigit(abbrArray[i+1])){
                        temp=temp*10+Integer.valueOf(""+abbrArray[i+1]);
                        i++;
                    }
                }
                count+=temp;
                sb.replace(start,start+temp,String.valueOf(temp));

            }else{
                count++;
            }
        }
        return sb.toString().equals(abbr) && word.length()==count;
    }
}
