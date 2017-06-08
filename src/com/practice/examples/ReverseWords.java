package com.practice.examples;

/*
Given an input string, reverse the string word by word.

Input:  "Never stop trying",
Output:  "trying stop Never"

Input: "The sky is blue"
Output:  since "blue is sky The"
*/

public class ReverseWords {

    /*
    Algorithm explanation:
    1. Iterate through the character array. Each time you find a space reverse the word.
       "Never stop trying"  - > "reveN pots gniyrt"
       To reverse a word keep two pointers in the start and end and swap characters.
    2. Call reverse on the whole string
       "reveN pots gniyrt" - > "trying stop Never"
    */
    public String reverseWords(char[] stringArray) {
        if(stringArray.length == 0)
            return null;
        int index = 0;
        for(int i=0;i<stringArray.length;i++) {
            if(stringArray[i] == ' '){
                reverse(stringArray, index, i-1);
                index = i+1;
            }
        }
        reverse(stringArray,index,stringArray.length-1);
        reverse(stringArray,0,stringArray.length-1);

        return String.valueOf(stringArray);
    }

    /*
    Algorithm to reverse a word:
    Maintain two index start and end. Swap the cahr in end index to start index and the
    character in startindex to end index.
     */
    private void reverse(char[] stringArray, int startIndex, int endIndex) {
        while(startIndex >= 0 && endIndex < stringArray.length && startIndex <= endIndex) {
            char temp = stringArray[startIndex];
            stringArray[startIndex] = stringArray[endIndex];
            stringArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        ReverseWords revWords = new ReverseWords();
        String s = "The sky is blue";
        char[] arr = s.toCharArray();
        String result = revWords.reverseWords(arr);
        if(result != null)
            System.out.println(result);
    }
}
