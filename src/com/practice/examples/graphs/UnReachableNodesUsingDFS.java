package com.practice.examples.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/*
Given a graph G, find the number of vertices that are not reachable from the given vertex

Time Complexity: O(V + E)
*/
public class UnReachableNodesUsingDFS {

    int count = 0;

    public void countUnreachableNodes(int s, boolean[] visited, LinkedList<Integer>[] adj) {
        visited[s] = true;
        count++;
        Iterator<Integer> itr = adj[s].listIterator();
        while(itr.hasNext()) {
            int vertices = itr.next();
            if(!visited[vertices])
                countUnreachableNodes(vertices, visited, adj);
        }
    }

    public int doDFS( int s, int V, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        countUnreachableNodes(s, visited, adj);
        return (V-count);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        UnReachableNodesUsingDFS uNodes = new UnReachableNodesUsingDFS();

        int noOfVertices = g.getAllVertices();
        LinkedList<Integer> adj[] = g.getAllEdges();

        int cnt = uNodes.doDFS(2, noOfVertices, adj);
        System.out.print(cnt);
    }
}
