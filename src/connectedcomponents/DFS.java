/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectedcomponents;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author TofixXx
 */

/** Realization of Depth-First Search algorithm, that calculates 
 * connected components number in undirected graph.
 */
public class DFS {

    private boolean marked[];
    private HashSet<Integer>[] adjList;
    private int componentsNum;

    DFS(HashSet<Integer>[] aList, int V, int E) {
        adjList = aList;
        marked = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            if (!marked[i]) {
                marked[i] = true;
                componentsNum++;
                search(i);
            }
        }
    }

    private void search(int v) {
        Iterator<Integer> it = adjList[v].iterator();
        while (it.hasNext()) {
            int s = it.next();
            if (!marked[s]) {
                marked[s] = true;
                search(s);
            }
        }
    }

    public int getComponentsNum() {
        return componentsNum;
    }
}
