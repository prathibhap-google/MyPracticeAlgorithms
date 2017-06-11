package com.practice.examples.strings;


/*
Given a string, find all permutations of a string.

Input:  "ABC".
Output:  ABC ACB BAC BCA CBA CAB
*/

import java.util.HashSet;

public class Permutation {

    public static HashSet<String> permutationResult = new HashSet<>();

    public HashSet<String> findAllPermutations(String s, String permutation) {
        if(s.length() == 0)
            permutationResult.add(permutation);
        else {
            for (int i=0;i< s.length();i++) {
                findAllPermutations(s.substring(0,i) + s.substring(i+1), permutation + s.charAt(i));
            }
        }

        return permutationResult;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.findAllPermutations("HOPE","");

        //print all permutations
        for (String str : permutationResult) {
            System.out.print(str + " ");
        }
    }
}
