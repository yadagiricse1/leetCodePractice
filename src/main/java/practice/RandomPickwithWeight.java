package practice;

public class RandomPickwithWeight {
    int sum=0;

    private int[] prefixSums;

    public RandomPickwithWeight(int[] w) {
        w=w;
        int prefixSum = 0;
        prefixSums =new int[w.length];
        for(int i=0;i<w.length;i++){
            prefixSum+=w[i];
            prefixSums[i]=prefixSum;
        }
        sum=prefixSum;
    }

    public int pickIndex1() {
        double target = sum*Math.random();
        int i=0;
        for(;i<prefixSums.length;i++){
            if(target<prefixSums[i])
                return i;
        }
        return i-1;

    }
    public int pickIndex() {
        double target = sum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
