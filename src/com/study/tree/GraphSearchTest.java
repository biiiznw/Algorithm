package com.study.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Depth - First Search (DFS)
 * 깊이우선검색
 * In order(Left, Root, Right)
 * Pre order(Root, Left, Right)
 * Post order(Left, Right, Root)
 *
 *
 *  Breadth - First Search (BFS)
 *  넓이우선검색
 *  시작점에서 자기 차일드 노드들을 다 방문하고
 *  그 다음 자식의 자식을 방문해서 leaf까지 도달하는 검색방식
 *
 *           1                    1
 *        /  |  \              /  |  \
 *       2   4   8            2   3   4
 *     /    / \   \         /    / \   \
 *    3    5   7   9       5    6   7   8
 *         |                    |
 *         6                    9
 *         DFS                  BFS
 *
 *  DFS : Stack
 *  BFS : Queue1
 *
 *  DFS : Stack
 *    0       7       |  |
 *   /       /        |  |
 *  1 - 3 - 5         |  |
 *  | / |    \        |__|
 *  2 - 4     6 - 8   STACK
 *  시작 노드를 스택에 먼저 넣고 시작
 *  한번 스택에 담았던 노드는 다시 넣지 못하고
 *  꺼낸 노드는 바로 출력한다
 *  0꺼내고 0의 차일드 노드 1을 스택에 넣는다. 0 출력
 *  스택에서 1을 꺼내고 1의 차일드 노드 2, 3을 스택에 넣는다. 1출력
 *  3을 꺼내고 3의 차일드 노드 4, 5를 스택에 넣고 3출력
 *  5를 꺼내고 5의 차일드 노드 6, 7을 스택에 넣고 5출력
 *  7을 꺼내고 7의 차일드 노드는 없으므로 7출력
 *  6을 꺼내고 6의 차일드 도드 8을 스택에 넣고 6 출력
 *  8을 꺼내고 8의 차일드 노드는 없으므로 8출력
 *  4를 꺼내고 4출력
 *  2를 꺼내고 2출력
 *  0-1-3-5-7-6-8-4-2
 *
 *  BFS : Queue1
 *    0       7       |  |  ↓
 *   /       /        |  |
 *  1 - 3 - 5         |  |
 *  | / |    \        |  |  ↓
 *  2 - 4     6 - 8   Queue1
 *  Queue를 만들고 시작 노드를 넣는다.
 *  한번 큐에 담았던 노드는 다시 담을 수 없고
 *  한번 나온 노드는 바로 출력한다.
 *  0을 꺼내고 0의 차일드 노드 1을 큐에 담는다 0출력
 *  1을 꺼내고 1의 차일드 노드 2,3을 큐에 담는다 1출력
 *  2를 꺼내고 2의 차일드 노드 4를 큐에 담는다 2출력
 *  3을 꺼내고 3의 차일드 노드 5를 큐에 담는다 3출력
 *  4를 꺼내고 4를 출력
 *  5를 꺼내고 5의 차일드 노드 6,7을 큐에 담는다 5출력
 *  6을 꺼내고 6의 차일드 노드 8을 큐에 담는다 6출력
 *  7을 꺼내고 출력
 *  8을 꺼내고 출력
 *  0-1-2-3-4-5-6-7-8
 *
 *  DFS(0)
 *  0-1-3-5-7-6-8-4-2
 *  BFS(0)
 *  0-1-2-3-4-5-6-7-8
 *  DFS(3)
 *  3-5-7-6-8-4-2-1-0
 *  BFS(3)
 *  3-1-2-4-5-0-6-7-8
 *
 *  DFS: Recursion
 *    0       7
 *   /       /
 *  1 - 3 - 5
 *  | / |    \
 *  2 - 4     6 - 8
 *  본인 노드 먼저 출력 후 자식 노드 호출 출력
 *  dfsR(0)
 *  dfsR(1)
 *  dfsR(2) (dfsR(3)) 2번에서 연결관계를 입력할 때 어떤 것을 먼저 가는지 선택 (왼쪽)
 *  dfsR(4) (dfsR(3))
 *  dfsR(3)
 *  dfsR(5)
 *  dfsR(6)
 *  dfsR(8)
 *  dfsR(7)
 *  0-1-2-4-3-5-6-8-7
 */
class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T item){
        Node<T> t = new Node<T>(item);
        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
    }

    public T dequeue(){
        if(first == null)
            throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null)
            last = null;
        return data;
    }

    public T peek(){
        if(first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
class Graph {
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i = 0; i <size; i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }
    void dfs(){
        dfs(0);
    }
    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    void bfs(){
        bfs(0);
    }
    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        while(!queue.isEmpty()){
            Node r = queue.dequeue();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }
    void dfsR(Node r){
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent){
            if(n.marked == false){
                dfsR(n);
            }
        }
    }
    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }
    void visit(Node n){
        System.out.print(n.data + " ");
    }
    void dfsR(){
        dfsR(0);
    }
}

public class GraphSearchTest {
    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
//        g.dfs();
//        g.bfs();
//        g.dfsR();
//        g.dfs(3);
        g.bfs(3);
//        g.dfsR(3);
    }

}
