package com.practice.examples.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/* Given a directed acyclic graph, do topological sort
*
* Time Complexity O(V+E)
* */

public class TopologicalSorting {


    public void doTopologicalSort(int V, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack();

        for(int i=0;i<V;i++) {
            if(!visited[i])
                doDFS(visited, stack, i, adj);
        }

        //print the stack to get the result.
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //Do DFS. Once the vertex have been completely explored add the vertex into stack.
    private void doDFS(boolean[] visited, Stack<Integer> stack, int vertex, LinkedList<Integer>[] adj) {
        visited[vertex] = true;

        Iterator<Integer> itr = adj[vertex].listIterator();

        while(itr.hasNext()) {
            int node = itr.next();
            if(!visited[node]){
                doDFS(visited, stack, node, adj);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        TopologicalSorting tSort = new TopologicalSorting();

        int noOfVertices = g.getAllVertices();
        LinkedList<Integer> adj[] = g.getAllEdges();
        tSort.doTopologicalSort(noOfVertices, adj);

    }
}
