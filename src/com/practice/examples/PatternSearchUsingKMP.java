package com.practice.examples;

/*
Solution using "Knuth–Morris–Pratt algorithm"

Given a string, search for a pattern in the given string
Input:  String ->  "cardabccabcabc12", Pattern -> "abcabc12"
Output:  true

Input: String - > "cbbd" ,Pattern -> "abcd"
Output:  false

Time Complexity: O(String length + Pattern Length) -> O(m + n)
Space complexity : O(Pattern Length) -> O(n)
*/


public class PatternSearchUsingKMP {

     /*
        Algorithm explanation:
        1. Precompute prefix array using the given pattern to understand the next position to start the next search when the pattern didnt match.
        2. Start comparing pattern and string.
               -> If characters match increment index in both string and pattern.
               -> If the characters donot match the precomputed array will tell the index of pattern to be matched.
               This will avoid checking the pattern from beginning if there is a prefix available.
        3. If either the entire input string is processed or the pattern has ben found stop searching.
               -> If pattern found return true or return false.
         */

    public boolean findPatternInString(String s, String p) {
        int [] longestPrefixSuffix = findLongestPrefixSufix(p);
        int i=0;
        int j=0;
        while (i >= 0 && j >= 0 && i < s.length() && j < p.length()) {
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                if (j != 0)
                    j = longestPrefixSuffix[j-1];
                else
                    i++;
            }
        }
        if(j == p.length())
            return true;
        return false;
    }

    /*
        Algorithm explanation:
        1. Precompute prefix array using the given pattern to understand the next position to start the next search when the pattern didnt match.
           Keep two pointers i and j. i iterates through the array, j checks if there is a prefix.
            1. If there is a match in characters: Increment i and j -> update the array with j + 1;
            2. If there is no match: Increment i if j is pointing to 0th position, or point j to the (j-1) index and start comparing.

         */
    private int[] findLongestPrefixSufix(String p) {
        int [] preffixTable = new int[p.length()];

        for(int i=1,j=0; i < p.length();) {
            if(p.charAt(i) == p.charAt(j)) {
                preffixTable[i] = j + 1;
                j++;
                i++;
            }else {
                if(j != 0) {
                    j = preffixTable[j - 1];
                } else  {
                    i++;
                }
            }
        }
        return preffixTable;
    }

    public static void main(String[] args) {
        String s = "AbcAbcAbc12";
        String pattern = "AbcAbc12";
        PatternSearchUsingKMP kmp = new PatternSearchUsingKMP();
        boolean result = kmp.findPatternInString(s, pattern);
        System.out.print("Pattern Available: " + result);
    }
}
