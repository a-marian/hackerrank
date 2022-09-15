package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, GNode> nodeLookup = new HashMap<Integer, GNode>();

    public static class GNode {
        private int id;

        LinkedList<GNode> adjacent = new LinkedList<GNode>();
        private GNode(int id){
            this.id = id;
        }
    }


    private GNode getNode(int id){
        return nodeLookup.get(id);
    }

    private void addEdge(int source, int destination){
        GNode s = getNode(source);
        GNode d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination){
        GNode s = getNode(source);
        GNode d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(GNode source, GNode destination, HashSet<Integer> visited){
        if(visited.contains(source.id)){
            return false;
        }
        if(source == destination){
            return true;
        }
        for (GNode child: source.adjacent) {
            if(hasPathDFS(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        return  hasPathBFS(getNode(source), getNode(destination));
    }

    public boolean hasPathBFS(GNode source, GNode destination){
        LinkedList<GNode> nextToVisit = new LinkedList<GNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            GNode node = nextToVisit.remove();
            if(node == destination){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);
            for (GNode child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }


}
