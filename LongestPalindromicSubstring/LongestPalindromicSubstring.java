package LongestPalindromicSubstring;

import java.util.*;


public class LongestPalindromicSubstring{

    Boolean memo[][];
    boolean memo2[][];

	public LongestPalindromicSubstring() {
	}

    // Brute Force
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLen = 1, start = 0;
        int end = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int flag = 1;

                // check palindrome
                for(int k = 0; k < (j - i + 1) / 2; k++){
                    if(s.charAt(i + k) != s.charAt(j - k))
                        flag = 0;
                }

                if(flag != 0 && (j - i + 1) > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    // Dynamic Programming memoization top down
    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }

                if(dp[j][i] && max < i - j + 1){
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
                System.out.println(String.format("dp[%d][%d] = %b, max = %d, start = %d, end = %d;", j, i, dp[j][i], max, start, end));
            }
        }
        return s.substring(start, end + 1);
    }

    // Easy understand top dowm dp solution
    public String longestPalindrome3(String s) {

        int len = s.length();

        memo = new Boolean[len][len];
        int maxLen = 0;
        String res = "";

        for(int left = 0; left < len; left++){
            for(int right = 0; right < len; right++){
                if(s.charAt(left) == s.charAt(right) && isPalin(s, left + 1, right - 1)){
                    if(maxLen < right - left + 1){
                        maxLen = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalin(String s, int left, int right){
        if(left >= right){
            return true;
        }

        if(memo[left][right] != null){
            return memo[left][right];
        }

        if(s.charAt(left) != s.charAt(right)){
            memo[left][right] = false;
            return memo[left][right];
        }

        if(right - left <= 2){
            memo[left][right] = true;
            return memo[left][right];
        }

        memo[left][right] = isPalin(s, left + 1, right - 1);
        return memo[left][right];
    }

    // Bottom-up dp solution (boolean: allow null, Boolean: Null Pointer Exception)
    public String longestPalindrome4(String s) {
        int len = s.length();
        
        int maxLen = 0;
        String res = "";
        memo2 = new boolean[len][len];
        
        for(int l = len - 1; l >= 0; l--){
            for(int r = l; r < len; r++){
                if(s.charAt(l) == s.charAt(r)){
                    if(r - l <= 2){
                        memo2[l][r] = true;
                    }else{
                        memo2[l][r] = memo2[l + 1][r - 1];
                    }
                }  

                if(memo2[l][r] && maxLen < r - l + 1){
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
            }
        }

        return res;
    }
}
