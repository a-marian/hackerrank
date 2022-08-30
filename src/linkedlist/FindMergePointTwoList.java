package linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;

public class FindMergePointTwoList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }


    //Floyd’s Cycle Finding Algorithm
    // detect if there is a loop in the linked list
    boolean detectLoop(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode slowPointer = head,
                fastPointer = head;

        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer)
                return true;
        }

        return false;
    }


    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException, IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

     public   static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

            while (head2 != null) {
                SinglyLinkedListNode temp = head1;
                while (temp != null){
                    if (temp == head2){
                        return head2.data;
                    }
                    temp = temp.next;
                }
                head2 = head2.next;
            }
            return head1.data;
        }

    }
