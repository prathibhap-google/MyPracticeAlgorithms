package com.practice.examples.strings;

/*
Given a string, find the length of the longest palindromic subsequence.
Input:  "bbbab",
Output:  longest palindromic subsequence is "bbbb". length:  4.

Input: "cbbd"
Output:  longest palindromic subsequence is "bb". length:  2.

Time Complexity: O(N^2)
Space complexity : O(N^2)
*/

public class LongestPalindromicSubsequence {

    public int findLongestPSubsequence(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] ch = s.toCharArray();
        int[][] LCS = new int[ch.length][ch.length];

        // if length is equal to 1 each character is considered to be a palindrome.
        for( int i=0;i < ch.length; i ++ ) {
            LCS[i][i] = 1;
        }

        /*
        Algorithm explanation:
        1.start comparsing two characters at a time.(eg. for string bbbab -> consider  1st iteration (bb, bb, ba, ab)
        2nd iteration (bbb, bba, bab) -> 3rd iteration (bbba, bbab) - > then the whole string
        2. In each iteration compare first and last character and apply the below formula
            if(both values are same) - > LCS[i][j] = 2+LCS[i+1][j-1]
            else - > LCS[i][j] = Maximum(LCS[i][j-1] , LCS[i+1][j])
         */
        for(int len=2;len <= ch.length;len++) {
            for(int i=0;i < ch.length - len + 1;i++){

                int j = i + len - 1;
                if (ch[i] == ch[j]) {
                    if(len == 2)
                        LCS[i][j] = 2;
                    else
                        LCS[i][j] = 2 + LCS[i+1][j-1];
                } else {
                    LCS[i][j] = Math.max(LCS[i+1][j], LCS[i][j-1]);
                }
            }
        }
        return LCS[0][ch.length-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int result = lps.findLongestPSubsequence("bbab");
        System.out.println(result);
    }
}
