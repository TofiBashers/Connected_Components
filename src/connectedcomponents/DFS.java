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
public class DFS {

    boolean marked[];
    HashSet<Integer> AdjList[];
    int CompsNum;

    DFS(HashSet<Integer> AList[], int V, int E) {
        AdjList = AList;
        marked = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            if (!marked[i]) {
                marked[i] = true;
                CompsNum++;
                Search(i);
            }
        }
    }

    private void Search(int v) {
        Iterator<Integer> it = AdjList[v].iterator();
        while (it.hasNext()) {
            int s = it.next();
            if (!marked[s]) {
                marked[s] = true;
                Search(s);
            }
        }
    }

    public int CompsNum() {
        return CompsNum;
    }
}
