package com.practice.examples.strings;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Input:  "A man, a plan, a canal: Panama" is a palindrome.
Output:  true

Input: "race a car"
Output:  false

Time Complexity: O(logN)
Space complexity : O(1)
*/

public class Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        if(s.length() == 1)
            return true;

        int left = 0;
        int right = s.length();

        // keep two pointers at the start and end of a string. Compare two pointers to check whether the characters match.
        // Check for only alphanumeric characters. Skip others.
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))){
                left++;
                right--;
            } else if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome pal = new Palindrome();
        boolean res = pal.isPalindrome("race a car");
        System.out.println("is palindrome: " + res);
    }
}
