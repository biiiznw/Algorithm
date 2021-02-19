package com.company.linkedlist;

/**
 * Unsorted list - Remove Duplicated Data In LinkedList
 * no buffer
 * space: O(1)
 * time: O(N2)
 */
class RemoveDuplicatedDataInLinkedList {
    Node header;
    static class Node{
        int data;
        Node next = null;
    }
    RemoveDuplicatedDataInLinkedList(){
        header = new Node();
    }
    void append(int data){
        Node end = new Node();
        end.data = data;
        Node n = header;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = header;
        while (n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
            }else
                n = n.next;
        }
    }

    void retrieve(){
        Node n = header.next;
        while (n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups(){
        Node n = header;
        while (n != null && n.next != null){
            Node r = n;
            while (r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}

public class RemoveDuplicatedDataInLinkedListTest {
    public static void main(String[] args){
        RemoveDuplicatedDataInLinkedList ll = new RemoveDuplicatedDataInLinkedList();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}
