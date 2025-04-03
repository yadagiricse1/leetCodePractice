package practice.contest;

public class LongestPalindromeAfterSubstringConcatenationI {
    public static int longestPalindrome(String s, String t) {
       String s1=s+t;
        int n = s1.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            dp[i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    dp[j] = dpPrev[j - 1] + 2;
                } else {
                    dp[j] = Math.max(dpPrev[j], dp[j - 1]);
                }
            }
            dpPrev = dp.clone();
        }

        String s2=t+s;
        int n1 = s2.length();
        int[] dp1 = new int[n];
        int[] dpPrev1 = new int[n];

        for (int i = n1 - 1; i >= 0; --i) {
            dp1[i] = 1;
            for (int j = i + 1; j < n1; ++j) {
                if (s2.charAt(i) == s2.charAt(j)) {
                    dp1[j] = dpPrev1[j - 1] + 2;
                } else {
                    dp1[j] = Math.max(dpPrev1[j], dp1[j - 1]);
                }
            }
            dpPrev1 = dp1.clone();
        }

       return Math.max(dp[n - 1],dp1[n - 1]);
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("aaaa","abcde"));

    }

}
