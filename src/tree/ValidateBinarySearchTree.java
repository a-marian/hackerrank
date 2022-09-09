package tree;

import java.io.*;

public class ValidateBinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node buildTree(String [] arr, int from, int to) {
        int middle = from + (to - from) / 2;
        Node node = new Node();
        node.data = Integer.valueOf(arr[middle]);
        if (middle > from) {
            node.left = buildTree(arr, from, middle - 1);
            node.right = buildTree(arr, middle + 1, to);
        }
        return node;
    }

    public static boolean checkBST(Node root) {
        return validate(root, null, null);
    }

    public static boolean validate(Node root, Integer max, Integer min){
        if(root == null){
            return true;
        } else if(max != null && root.data >= max ||
                min != null && root.data <= min ){
            return false;
        } else {
            return validate(root.left, root.data, min) && validate(root.right, max, root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int maxHeight = Integer.valueOf(in.readLine());
            String [] line = in.readLine().split(" ");
            ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
            Node root = solution.buildTree(line, 0, line.length);
            if (solution.checkBST(root)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }
}

//Input
//1 2 3 4 5 6 7
//Output
//Yes

//Input
//3 5 7 9 11 13 15
//Output
//Yes

//Input
//1 2 4 3 5 6 7
//Output
//No
