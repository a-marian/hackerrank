package graphs;

import java.util.*;

public class FindPathExistGraph {

    private static List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    //BFS
    public static boolean validPathBFS(int n, int[][]edges, int source, int destination){
        List<List<Integer>>  graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        Queue<Integer> queuey = new LinkedList<>();

        queuey.offer(source);

        while(!queuey.isEmpty()){
            int current = queuey.poll();
            if(current == destination) return true;
            visited[current] = true;

            for (int neighbor: graph.get(current)) {
                if(!visited[neighbor])
                    queuey.offer(neighbor);
            }
        }
        return false;
    }

    //DFS iteration
    public static boolean validPathDFSIteration(int n, int[][]edges, int source, int destination){
        List<List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        Stack<Integer> stacky = new Stack<Integer>();
        stacky.push(source);

        while (!stacky.isEmpty()){
            int current = stacky.pop();
            if (current == destination) return  true;
            visited[current] = true;

            for (int neighbor : graph.get(current)) {
                if(!visited[neighbor]) stacky.push(neighbor);
            }
        }
        return false;
    }

    //DFS Recursion
    public static boolean validPathDFSRecursion(int n, int[][]edges, int source, int destination){
        List<List<Integer>> graph= buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        return hasPath(graph, visited, source, destination);
    }

    private static boolean hasPath(List<List<Integer>> graph, boolean[] visited, int source, int destination) {
        if(source == destination) return true;
        visited[source] = true;

        for (int neighbor: graph.get(source)) {
            if(visited[neighbor]) continue;
            if(hasPath(graph, visited, neighbor,destination)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        //BFS
        System.out.println(validPathBFS(6, array, 0,5 ));
        //DFS Iteration
        System.out.println(validPathDFSIteration(6, array, 0,5 ));
        //DFS Recursion
        System.out.println(validPathDFSRecursion(6, array, 0,5 ));


    }
}
