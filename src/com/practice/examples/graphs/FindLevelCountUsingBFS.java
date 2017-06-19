package com.practice.examples.graphs;

import java.util.*;

/*
Given a graph G and a level, find the number of vertices in the given level.

Time Complexity: O(V + E)
*/

public class FindLevelCountUsingBFS {

    public int printLevelBFS(int v, int nlevel, int V, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        int tempCount = 0;
        int level = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            tempCount = queue.size();
            level = level + 1;
            while(tempCount > 0) {
                int val = queue.poll();
                if(nlevel == level){
                    count++;
                }
                Iterator<Integer> itr = adj[val].listIterator();
                while(itr.hasNext()) {
                    int vertices = itr.next();
                    if(!visited[vertices]){
                        queue.add(vertices);
                        visited[vertices] = true;
                    }
                }
                tempCount--;
            }
        }
        return count;
    }


    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        FindLevelCountUsingBFS g1 = new FindLevelCountUsingBFS();

        int noOfVertices = g.getAllVertices();
        LinkedList<Integer> adj[] = g.getAllEdges();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        int cnt = g1.printLevelBFS(2, 2, noOfVertices, adj);
        System.out.print(cnt);
    }
}
