package com.practice.examples.strings;

/*
Given a dictionary, and a M x N board where every cell has one character.
Find all possible words that can be formed by a sequence of adjacent characters.
Input:

Dictionary : {"CAT" , "CAP"}
Matrix :
{'C','A','P'},
{'A','N','D'},
{'T','I','E'}
Output:  CAT, CAP

*/

public class WordBoggler {

    public static int SIZE = 26;

      /*
        Algorithm explanation:
        1. Create a Trie datastrucutre and add words in the dictionary to trie.
        2. Check for first letters in boggle and search the children of the root in a tree.
        Perform DFS until the word are found and the last node in the leaf node.
         */

      /* Trie Datastructure starts here */
    static class TrieNode {
        TrieNode[] children;
        boolean isLeaf;
        char data;

        public TrieNode(char data) {
            children = new TrieNode[SIZE];
            isLeaf = false;
            this.data = data;
        }

        public static void insert(TrieNode root, String s) {
            if(root == null) return;
            TrieNode currentNode = root;
            TrieNode[] currentNodeChildren = root.children;

            for(int i=0;i<s.length();i++){
                if(currentNodeChildren[s.charAt(i) - 'A'] == null) {
                    TrieNode newNode = new TrieNode(s.charAt(i));
                    currentNodeChildren[s.charAt(i) - 'A'] = newNode;
                    currentNode = newNode;
                    currentNodeChildren = currentNode.children;
                } else {
                    currentNode = currentNodeChildren[s.charAt(i) - 'A'];
                    currentNodeChildren = currentNode.children;
                }
            }
            currentNode.isLeaf = true;
        }
    }
    /* Trie Datastructure ends here */


    public static void findWordsInMatrix(char[][] boggle, TrieNode root) {
        int row = boggle.length;
        int col = boggle[0].length;
        boolean[][] visited = new boolean[row][col];
        TrieNode[] children = root.children;

        for (int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                char c = boggle[i][j];
                //check for each character in matrix there is a matching childnode for the root node.
                if(children[c -'A'] != null) {
                    //if child available start performing DFS until a leaf node is reached and the word is found.
                    performDFS(boggle, children[c -'A'], visited, "" + c, i, j);
                }
            }
        }
    }

    private static void performDFS(char[][] boggle, TrieNode child, boolean[][] visited, String s, int i, int j) {
        if (child.isLeaf)
            System.out.println(s);
        TrieNode[] childrens = child.children;
        visited[i][j] = true;

        //offset is required to match the 8 possible cells that can be traversed (up,bottom,left,right,diagonals)
        int[] offset = {-1, 0, 1};
        int xoffset = 0;
        int yoffset = 0;
        for (int k = 0; k < offset.length; k++) {
            xoffset = offset[k];
            for (int l = 0; l < offset.length; l++) {
                yoffset = offset[l];
                if (xoffset == 0 && yoffset == 0)
                    continue;
                if (hasNeigBhors(boggle, xoffset + i, yoffset + j) && !visited[xoffset + i][yoffset + j]) {
                    if (childrens[boggle[xoffset + i][yoffset + j] - 'A'] != null) {
                        performDFS(boggle, childrens[boggle[xoffset + i][yoffset + j] - 'A'], visited, s + boggle[xoffset + i][yoffset + j], xoffset + i, yoffset + j);
                    }
                }
            }
        }
    }

    //function to check reachable cells.
    private static boolean hasNeigBhors(char[][] boggle, int i, int j) {
        if ((i >= 0) && (i < boggle.length) && (j >= 0) && (j < boggle[0].length)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String dictionary[] = {"CAT" , "CAP"};
        int n = dictionary.length;
        char ch = '\0';
        TrieNode troot = new TrieNode(ch);

        for (int i=0; i<n; i++)
            TrieNode.insert(troot, dictionary[i]);

        char[][] boggle = {{'C','A','P'},
                           {'A','N','D'},
                           {'T','I','E'}
        };


        findWordsInMatrix(boggle, troot);
    }
}
