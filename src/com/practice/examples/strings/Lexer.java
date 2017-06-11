package com.practice.examples.strings;
import java.util.*;

/*
Find the longest word in sequence in given set of tokens.
Input:  tokens = {"ab","aba","A"}; input = "ababbbaAab";
Output: {"aba", "A", "ab"}
*/
public class Lexer{

    public String[] tokenize(String[] tokens, String input){
        char[] str = input.toCharArray();
        HashSet<String> set = new HashSet<String>(Arrays.asList(tokens));
        ArrayList<String> tempArray = new ArrayList<String>();
        int j = 0;
        while(j < str.length) {
            int maxlength = 0;
            String newString = "";
            int index = 0;
            String currentString = "";
            for (int i = j; i < str.length; i++) {
                currentString = currentString + str[i];
                if (set.contains(currentString)){
                    if((Math.abs(i-j+1) > maxlength)){
                        maxlength = Math.abs(i-j+1);
                        newString = currentString;
                        index = i + 1;
                    }
                }
            }
            if(maxlength != 0){
                tempArray.add(newString);
                j = index;
            }else {j++;}
        }
        return tempArray.toArray( new String[tempArray.size()]);
    }
}
