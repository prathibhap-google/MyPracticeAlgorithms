package com.practice.examples.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/*
Given a graph G, find the number of vertices that are not reachable from the given vertex

Time Complexity: O(V + E)
*/
public class UnReachableNodesUsingDFS {

    int V;
    int count = 0;
    LinkedList<Integer> adj[];

    UnReachableNodesUsingDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0; i<V;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int w) {
        adj[u].add(w);
    }

    public void countUnreachableNodes(int s, boolean[] visited) {
        visited[s] = true;
        count++;
        Iterator<Integer> itr = adj[s].listIterator();
        while(itr.hasNext()) {
            int vertices = itr.next();
            if(!visited[vertices])
                countUnreachableNodes(vertices, visited);
        }
    }

    public int doDFS( int s) {
        boolean[] visited = new boolean[V];
        countUnreachableNodes(s, visited);
        return (V-count);
    }

    public static void main(String[] args) {
        UnReachableNodesUsingDFS g = new UnReachableNodesUsingDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int cnt = g.doDFS(2);
        System.out.print(cnt);
    }
}
