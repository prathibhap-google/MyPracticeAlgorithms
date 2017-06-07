package com.practice.examples;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring without repeating characters.
Input:  "abcabcbb",
Output:  longest substring: "abc", length:  3.

Input: "pppppp"
Output: longest substring: "p", length:  1.

Time Complexity: O(N)
Space complexity : O(N)
*/

public class LongestSubstringWithoutRepeation {

    public int lengthOfLongestSubstring(String s) {
     if(s==null || s.length() == 0){
         return 0;
     } else {
         int maxLength = 0;
         // store the position(index) of each character in hashmap
         HashMap<Character, Integer> hMap = new HashMap<>();
         for (int i = 0, j = 0; i < s.length(); i++) {
             //update j value only if the value in hashmap is greater than the current position of j.
             if (hMap.containsKey(s.charAt(i)))
                 j = Math.max(hMap.get(s.charAt(i)) + 1, j);
             hMap.put(s.charAt(i), i);
             maxLength = Math.max(maxLength, i - j + 1);
         }
         return maxLength;
     }
    }

    public String longestSubstring(String s) {
        if(s==null || s.length() == 0){
            return null;
        } else {
            int startIndex = 0;
            int endIndex = 0;
            int maxLength = 0;
            HashMap<Character, Integer> hMap = new HashMap<>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (hMap.containsKey(s.charAt(i)))
                    j = Math.max(hMap.get(s.charAt(i)) + 1, j);
                hMap.put(s.charAt(i), i);
                //when updating maxLength update the position of j and i to retreive the longest substring.
                if( maxLength < (i - j + 1)){
                    maxLength = (i - j + 1);
                    startIndex = j;
                    endIndex = i+1;
                }
            }
            return s.substring(startIndex, endIndex);
        }
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        LongestSubstringWithoutRepeation obj = new LongestSubstringWithoutRepeation();

        //find the length of the longest substring without any repeating characters.
        int length = obj.lengthOfLongestSubstring(s);
        System.out.println(length);

        //find the longest substring without any repeating characters.
        String subStr = obj.longestSubstring(s);
        if (subStr != null)
        System.out.println(subStr);

    }
}
