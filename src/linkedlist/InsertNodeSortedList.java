package linkedlist;


import java.io.BufferedWriter;
import java.io.IOException;

public class InsertNodeSortedList{


    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }


    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Write your code here
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode temp = llist;
        if(llist.data >= newNode.data){
            newNode.next =  llist;
            llist.prev = newNode;
            llist = newNode;
            return llist;
        }
        while(temp != null){
            if(newNode.data < temp.data){
                DoublyLinkedListNode previous = temp.prev;
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev = newNode;
                previous.next = newNode;
                return llist;
            }

            if(temp.next == null){
                temp.next = newNode;
                newNode.prev = temp;
                return llist;
            }
            temp = temp.next;
        }
        return llist;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        llist = prev;
        return llist;
    }


}
