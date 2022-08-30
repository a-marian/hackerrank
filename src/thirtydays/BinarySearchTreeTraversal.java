package thirtydays;
/** TO_DO refactor and fix
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinarySearchTreeTraversal {

    class NodeForTreeTraversal {
        NodeForLinkedList left,right;
        int data;
        NodeForTreeTraversal(int data){
            this.data=data;
            left=right=null;
        }
    }

    static void levelOrder(NodeForTreeTraversal root){
        //Write your code here
        Queue<NodeForTreeTraversal> queuey = new LinkedList<>();
        //enqueque current root
        queuey.add(root);

        while(!queuey.isEmpty()){
            //dequeue next node
            NodeForTreeTraversal current = queuey.remove();
            System.out.print(current.data+" ");
            //enqueue child elements from next level in order
            if(current.left != null){
                queuey.add(current.left);
            }
            if(current.right != null){
                queuey.add(current.right);
            }
        }
    }

    public static NodeForTreeTraversal insertTraversal(NodeForTreeTraversal root, int data){
        if(root==null){
            return new NodeForTreeTraversal(data);
        }
        else{
            NodeForTreeTraversal cur;
            if(data<=root.data){
                cur=insertTraversal(root.left,data);
                root.left=cur;
            }
            else{
                cur=insertTraversal(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        NodeForTreeTraversal root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insertTraversal(root,data);
        }
        levelOrder(root);
    }
}

***/
