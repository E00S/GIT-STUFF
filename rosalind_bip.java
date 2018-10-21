import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RosalindBipartiteness {

    // This section of code is from GraphTraversal.java written by Peter
    static boolean traverseDepthColor(List<Integer>[] graph, int start, Set<Integer> visited, int[] color) {
        visited.add(start);
        for (Integer n : graph[start]) {
            if(color[start] == 1 && color[n] == 0) {
                color[n] = 2;
            }
            else if(color[start] == 2 && color[n] == 0) {
                color[n] = 1;
            }
            else if (color[start] == color[n]) {
                return false;
            }
            if (!visited.contains(n)) {
                if(!traverseDepthColor(graph, n, visited, color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        In in = new In("rosalind_bip.txt");
        int numGraph = in.readInt();

        for (int i = 0; i < numGraph; i++) {
            int node = in.readInt();
            int edge = in.readInt();
            List<Integer>[] graph = new List[node + 1];

            for (int n = 0; n < node + 1; n++) {
                graph[n] = new ArrayList<>();
            }

            int temp1, temp2;
            for (int n = 0; n < edge; n++) {
                temp1 = in.readInt();
                temp2 = in.readInt();
                graph[temp1].add(temp2);
                graph[temp2].add(temp1);
            }

            Set<Integer> visited = new HashSet<>();
            int[] color = new int[node + 1];
            color[1] = 1;

            if(traverseDepthColor(graph, 1, visited, color))
                StdOut.print(1 + " ");
            else
                StdOut.print(-1 + " ");
        }
    }
}