package com.practice.examples.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/* Given a directed acyclic graph, do topological sort
*
* Time Complexity O(V+E)
* */

public class TopologicalSorting {

    int V;
    LinkedList<Integer> adj[];

    // build graph
    TopologicalSorting(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i< V;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int w) {
        adj[u].add(w);
    }

    public void doTopologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack();

        for(int i=0;i<V;i++) {
            if(!visited[i])
                doDFS(visited, stack, i);
        }

        //print the stack to get the result.
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //Do DFS. Once the vertex have been completely explored add the vertex into stack.
    private void doDFS(boolean[] visited, Stack<Integer> stack, int vertex) {
        visited[vertex] = true;

        Iterator<Integer> itr = adj[vertex].listIterator();

        while(itr.hasNext()) {
            int node = itr.next();
            if(!visited[node]){
                doDFS(visited, stack, node);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.doTopologicalSort();

    }
}
