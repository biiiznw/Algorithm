package com.study.linkedlist;

/**
 * linked list
 * [][]-[][]-[][]합
 * 노드에 다음 노드의 주소를 갖고 있는
 * 길이가 정해져 있지 않은 데이터의 연결된 집
 * 한 방향으로만 움직일 수 있는 것은 단방향 링크드 리스트
 * 양쪽 방향으로 움직힐 수 있는 것은 양방향 링크드 리스트
 *
 */


class Node{
    private int data;
    private Node next = null;
    public Node(int data){
        this.data = data;
    }

    public void append(int data){
        Node end = new Node(data);
        Node n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data){
        Node n = this;
        while (n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
            }else
                n = n.next;
        }
    }

    public void retrieve(){
        Node n = this;
        while (n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}



public class SinglyLinkedListTest {
    public static void main(String[] args){
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2);
        head.retrieve();
    }
}
