package thirtydays;

import java.util.Scanner;

class NodeForLinkedList {
    int data;
    NodeForLinkedList next;
    NodeForLinkedList(int d){
        data=d;
        next=null;
    }

}
class MoreLinkedLists
{

    public static NodeForLinkedList removeDuplicates(NodeForLinkedList head) {
        //Write your code here
        if(head == null || head.next == null) return head;

        if(head.data == head.next.data) {
            head.next = head.next.next;
            removeDuplicates(head);
        } else {
            removeDuplicates(head.next);
        }
        return head;
    }

    public static NodeForLinkedList insert(NodeForLinkedList head, int data)
    {
        NodeForLinkedList p=new NodeForLinkedList(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            NodeForLinkedList start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(NodeForLinkedList head)
    {
        NodeForLinkedList start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

    public static NodeForLinkedList insertNodeAtPosition(NodeForLinkedList llist, int data, int position) {

// Write your code here
        NodeForLinkedList newNode = new NodeForLinkedList(data);
        if(position==1){
            newNode.next=llist;
            llist=newNode;
            return llist;
        }
        else {
            NodeForLinkedList previous = llist;
            int count=0;
            while(count<position-1) {
                previous = previous.next;
                count++;
            }
            NodeForLinkedList current=previous.next;
            newNode.next=current;
            previous.next=newNode;
        }
        return llist;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        NodeForLinkedList head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}
