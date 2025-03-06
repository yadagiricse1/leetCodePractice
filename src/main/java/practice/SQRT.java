package practice;

public class SQRT {
  /*  Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
   */
  public static int mySqrt(int x){
      long l=1;
      long r=(long)1e5;
      while(l<=r){
          long m=l+(r-l)/2;
          if(m*m<=x){
              l=m+1;

          } else{
            r=m-1;
          }
      }
      return (int)r;
  }
    public static int mySqrt2(int x) {
        if(x<=1)
            return x;
        int count=0;
        int num=x;
        while(num>0){
            num=num/10;
            count++;
        }
        if(count<=4){
            int i=1;
            while(i<=(x/i)){
                i++;
            }
            return i-1;
        } else {
            int min=1;
            if(count%2==0)
                min=3;
            int multiplier=10;
            int j=0;
            while(j<(count/2-1)){
                min=min*multiplier;
                j++;
            }
            int i=min;
            int [] primes={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73, 79, 83, 89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227};
            int k=0;
            while(i<=(x/i)){
                i=i+primes[k%primes.length];
                k++;
                if(i>23000)
                    System.out.println(i);

            }
            i=i-primes[(k-1)%primes.length];
            while(i<=(x/i)){
                i++;
            }
            return i-1;

        }


    }
    public static int mySqrt1(int x) {
        if(x<=1)
            return x;
       int i=1;
       while(i<=(x/i)){
           i++;
       }
        return i-1;
    }

    public static void main(String[] args) {
        //int x=43046721;//6561
       // int x=537001935; //23173
        int x=486;

        System.out.println(mySqrt(x));

    }
}
