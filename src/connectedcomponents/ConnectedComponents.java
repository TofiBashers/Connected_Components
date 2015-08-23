/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectedcomponents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author TofixXx
 */

/** Solution for searching number of connected components
 *  in undirected graph
 */
public class ConnectedComponents {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("rosalind_cc.txt"));
                FileWriter writer = new FileWriter(new File("output.txt"))) {
            String inp[] = reader.readLine().split(" ");
            int V = Integer.parseInt(inp[0]);
            int E = Integer.parseInt(inp[1]);
            HashSet<Integer> AdjList[] = new HashSet[V + 1];
            for (int i = 0; i < V + 1; i++) {
                AdjList[i] = new HashSet();
            }
            while (reader.ready()) {
                String str[] = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                AdjList[a].add(b);
                AdjList[b].add(a);
            }
            DFS dfs = new DFS(AdjList, V, E);
            writer.write(Integer.toString(dfs.getComponentsNum()));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
