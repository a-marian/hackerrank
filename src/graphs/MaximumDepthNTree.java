package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthNTree {

    public int maxDepthBFS(Node root) {
        if(root == null) return 0;
        int depth = 0;

        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i < size; i++){
                Node currentNode = queue.poll();
                for(Node child: currentNode.children){
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth++;
    }

    private int maxDepth;
    public int maxDepthDFS(Node root){
        if(root == null) return 0;
        getMathDepth(root, 1);
        return maxDepth;
    }

    public void getMathDepth(Node node, int depth){
        if(node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        for(Node child: node.children){
            getMathDepth(child, depth+1);
        }
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}




