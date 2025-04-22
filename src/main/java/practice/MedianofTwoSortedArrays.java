package practice;

public class MedianofTwoSortedArrays {
   static int p1=0;
    static int p2=0;
    public static double getMin(int[] nums1, int[] nums2){
        if(p1< nums1.length&&p2<nums2.length){
            if(nums1[p1]<nums2[p2]){
                return nums1[p1++];
            } else{
                return nums2[p2++];
            }

        } else if(p1< nums1.length){
            return nums1[p1++];

        } else if(p2<nums2.length){
            return nums2[p2++];

        }
        return -1;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m=nums1.length;
       int n=nums2.length;

       if((m+n)%2==0){
           for(int i=0;i<(m+n)/2-1;i++){
               getMin(nums1,nums2);
           }
           return  (getMin(nums1,nums2)+ getMin(nums1,nums2))/2.0;

       } else{
           for(int i=0;i<(m+n)/2;i++){
               getMin(nums1,nums2);
           }
           return  getMin(nums1, nums2);

       }

    }

    public static void main(String[] args) {
        int []nums1={1,4,6,8};
        int []nums2={2,3,5,7};

        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
