package com.practice.examples.graphs;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adj[];

    // build graph
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i< V;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int w) {
        adj[u].add(w);
    }

    public void addBothEdges(int u, int w) {
        adj[u].add(w);
        adj[w].add(u);
    }

    public LinkedList<Integer>[] getAllEdges() {
        return adj;
    }

    public int getAllVertices() {
        return V;
    }


}
