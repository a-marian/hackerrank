package tree;
import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class HeightBinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        if(root == null){
            return -1;
        } else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if (v1 < root.data && v2 < root.data){
            return lca(root.left, v1, v2);
        }

        if (v1 > root.data && v2 > root.data){
            return lca(root.right, v1, v2);
        }
        return root;
    }

    public boolean validate(Node root, Integer max, Integer min){
        if(root == null){
            return true;
        } else if(max != null && root.data >= max ||
                min != null && root.data <= min ){
            return false;
        } else {
            return validate(root.left, root.data, min) && validate(root.right, max, root.data);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);

        //lowest common ancestor
        int v1 = 2;
        int v2 = 9;
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
