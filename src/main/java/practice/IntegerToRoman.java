package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

  // approach 3
    //1994
    //MCMXCIV
  public static String intToRoman(int num){
      int [] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
      String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
      StringBuilder sb = new StringBuilder();
      int current=0;
      while(num!=0){
          while(num>=nums[current]){
              sb.append(roman[current]);
              num=num-nums[current];
          }
          current++;
      }
  return sb.toString();
  }
    public static String intToRoman2(int num){
        StringBuilder sb = new StringBuilder();
        while(num>999){
            sb.append("M");
            num=num-1000;
        }
        if(num>899){
            sb.append("CM");
            num=num-900;
        }
        while(num>499){
            sb.append("D");
            num=num-500;
        }
        if(num>399){
            sb.append("CD");
            num=num-400;
        }
        while(num>99){
            sb.append("C");
            num=num-100;
        }

        if(num>89){
            sb.append("XC");
            num=num-90;
        }
        while(num>49){
            sb.append("L");
            num=num-50;
        }
        if(num>39){
            sb.append("XL");
            num=num-40;
        }
        while(num>9){
            sb.append("X");
            num=num-10;
        }
        if(num==9){
            sb.append("IX");
            num= 0;
        }
        if(num>4){
            sb.append("V");
            num=num-5;
        }
        if(num==4){
            sb.append("IV");
            num=0;
        }
        while(num>0){
            sb.append("I");
            num=num-1;
        }
        return sb.toString();
    }
    public static String intToRoman1(int num) {
        Map<Integer,String> integerStringMap = new HashMap<>();
        integerStringMap.put(1,"I");
        integerStringMap.put(5,"V");
        integerStringMap.put(10,"X");
        integerStringMap.put(50,"L");
        integerStringMap.put(100,"C");
        integerStringMap.put(500,"D");
        integerStringMap.put(1000,"M");
        Map<Integer,List<Integer>> indexNumberMapping = new HashMap<>();
        indexNumberMapping.put(3,List.of(1000));
        indexNumberMapping.put(2,List.of(100,500));
        indexNumberMapping.put(1,List.of(10,50));
        indexNumberMapping.put(0,List.of(1,5));

        List<Integer> digits = new ArrayList<>();
        while(num>0){
            int remainder = num%10;
            digits.add(remainder);
            num=num/10;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=digits.size()-1;i>=0;i--){
            int digit= digits.get(i);
            if(i==3){
              String roman = integerStringMap.get(indexNumberMapping.get(i).get(0)) ;
                sb.append(String.valueOf(roman).repeat(Math.max(0, digit)));
            } else {
                if(digit==4){
                    String roman = integerStringMap.get(indexNumberMapping.get(i).get(0))+integerStringMap.get(indexNumberMapping.get(i).get(1)) ;
                    sb.append(roman);
                } else if(digit==9){
                    String roman = integerStringMap.get(indexNumberMapping.get(i).get(0))+integerStringMap.get(indexNumberMapping.get(i+1).get(0)) ;
                    sb.append(roman);

                } else {
                    StringBuilder rsb= new StringBuilder();
                    if(digit>=5){
                        digit=digit-5;
                        rsb.append(integerStringMap.get(indexNumberMapping.get(i).get(1)));
                    }
                    while(digit>0){
                        rsb.append(integerStringMap.get(indexNumberMapping.get(i).get(0)));
                        digit--;
                    }
                    sb.append(rsb);
                }
            }

        }


        return sb.toString();

    }

    public static void main(String[] args) {
        int num =1994;
       // System.out.println(intToRoman1(num));
        System.out.println(intToRoman(num));
    }
}
