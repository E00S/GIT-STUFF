import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RosalindConnectedComponents {
    // This section of code is from GraphTraversal.java written by Peter Drake
    static void traverseDepthFirst(List<Integer>[] graph, int start, Set<Integer> visited) {
        visited.add(start);
        for (Integer n : graph[start]) {
            if (!visited.contains(n)) {
                traverseDepthFirst(graph, n, visited);
            }
        }
    }

    //Changes .txt file into a array, makes the undirected graph and calls on
    // depth first search to find how many connected components exist
    public static void main(String[] args) {
        //reads ints from file to array/ nums has all the same values as temp
        // other than the first two values and index 0 is empty
        In in = new In("rosalind_cc.txt");
        int[] temp = in.readAllInts();
        int[] nums = new int[temp.length - 1];
        int count = 0;

        for (int i = 2; i < temp.length; i++) {
            nums[i - 1] = temp[i];
        }
        // makes graph
        List<Integer>[] graph = new List[temp[0] + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //puts values from the txt file into a undirected graph
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 != 0) {
                graph[nums[i]].add(nums[i + 1]);
                graph[nums[i + 1]].add(nums[i]);
            }
        }
        //keeps track of visited nodes and adds 1 to count if it finds a connected component
        //prints result
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= temp[0]; i++) {
            if (!visited.contains(i)) {
                count++;
                traverseDepthFirst(graph, i, visited);
            }
        }
        StdOut.println();
        StdOut.println("Count " + count);
    }
}