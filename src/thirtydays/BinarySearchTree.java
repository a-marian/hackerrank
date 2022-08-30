//https://www.hackerrank.com/challenges/30-binary-search-trees/problem?isFullScreen=true
package thirtydays;
import java.util.*;

class NodeBST {
    NodeBST left,right;
    int data;
    NodeBST(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTree{

    public static int getHeight(NodeBST root){
        //Write your code here
        if (root == null){
            return -1;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) +1;
    }

    public static NodeBST insert(NodeBST root, int data){
        if(root==null){
            return new NodeBST(data);
        }
        else{
            NodeBST cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        NodeBST root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
