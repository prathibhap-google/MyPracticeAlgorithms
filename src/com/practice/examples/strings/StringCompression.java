package com.practice.examples.strings;

/*
Compress a given string "aabbbccc" to "a2b3c3".
Note: If the compressed string is larger than the original string, return the original string.

Input:  "aaabbbbeeeeccb",
Output:  "a3b3e3c2b1"

Input: "abc"
Output:  since "a1b1c1" length is greater than "abc" return "abc"

Time Complexity: O(N)
Space complexity : O(N)
*/

public class StringCompression {

    public String getCompressedString(String s){
        if(s == null || s.length() == 0) return null;

        // if string is of length1 return the actual string
        if(s.length() == 1) return s;

        StringBuilder sBuilder = new StringBuilder();
        char c = s.charAt(0);
        int frequency = 1;

        //Append the char and frequency to the string builder when a new character is seen.
        for(int i=1;i<s.length();i++) {
            if (s.charAt(i) == c)
                frequency++;
            else {
                sBuilder.append(c);
                sBuilder.append(frequency);
                c = s.charAt(i);
                frequency = 1;
            }
            // anytime compressed length is greater than the actual string length return the actual string.
            if(sBuilder.toString().length() > s.length()) return s;
        }
        sBuilder.append(c);
        sBuilder.append(frequency);

        return (sBuilder.toString().length() > s.length()) ? s : sBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbbcccbbeeeee";
        StringCompression obj = new StringCompression();
        String compressedString = obj.getCompressedString(s);
        if(compressedString != null)
            System.out.println(compressedString);
    }
}
