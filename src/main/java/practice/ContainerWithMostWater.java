package practice;

public class ContainerWithMostWater {

    public static int maxArea(int[] height){
        int i=0;
        int j=height.length-1;
        int result=0;
        while(i<j){

            int minHeight = Math.min(height[i],height[j]);
            result=Math.max(result,minHeight*(j-i));

            while(i<j && height[i]<=minHeight){
                i++;
            }
            while(i<j && height[j]<=minHeight){
                j--;
            }
        }

        return result;
    }

    public static int maxArea1(int[] height) {
        int beging=0;
        int ending =height.length-1;
        int max=0;

        while(beging<ending){
            int temp = (ending - beging) * Math.min(height[beging], height[ending]);
            if(temp>max)
                max=temp;
            if(height[beging]<height[ending]){
                beging++;
            } else {
                ending--;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int  height[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));


    }
}
