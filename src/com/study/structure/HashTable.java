package com.study.structure;

import java.util.LinkedList;

/**
 * 검색하고자하는 키 값을 입력받아서 해쉬함수를 돌려서 반환받은 해쉬코드를 배열의 인덱스로 환산을 해서
 * 데이터에 접근하는 방식의 자료구조
 * F(key) -> HashCode -> Index -> Value
 * 해쉬함수는 어떤 특정한 규칙을 이용해 입력받은 키 값으로 그 키 값이 얼마나 큰지에 상관없이
 * 동일한 해쉬코드를 만들어 준다
 * 암호화폐의 핵심 기술인 블록체인에서도 각 사용자들의 공공 장부를 비교할 때 해쉬코드를 이용함
 * 장점 :
 * 검색속도가 매우 빠르다
 * 단점 :
 * hash algorithm collision
 * O(1) -> O(n)
 * - different keys -> same code
 * - different code -> same index
 * get Hash code(Key)
 *     K  +   E  +   Y = hashCode
 * ASCII + ASCII + ASCII
 * 고정된 크기의 배열 선언!
 */
class HashTableTest {
    public class Node{
        private String key;
        private String value;
        //constructor
        public Node(String key, String value){
            this.key = key;
            this.value = value;
        }
        //getter
        public String value(){
            return value;
        }
        //setter
        public void value(String value){
            this.value = value;
        }
    }
    private LinkedList<Node>[] data;
    // constructor
    public HashTableTest(int size){
        this.data = new LinkedList[size];
    }

    /**
     * Create Hash Algorithm
     * @param key
     * @return
     */
    public int getHashCode(String key){
        int hashCode = 0;
        for(char c : key.toCharArray()){
            hashCode += c;
        }
        return hashCode;
    }
    public Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)) return node;
        }
        return null;
    }

    /**
     * Convert hashcode to Index
     * @param hashCode
     * @return
     */
    public int convertToIndex(int hashCode){
        return hashCode % data.length;
    }
    /**
     * put key and value in linked list
     * @param key
     * @param value
     */
    public void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        //Print hashcode and Index
        System.out.println(key + ", hashcode(" + hashCode + "), index(" + index + ")");
        LinkedList<Node> list = data[index];
        if(list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if(node == null)
            list.addLast(new Node(key, value));
        else
            node.value(value);
    }

    /**
     * get value from linked list
     * @param key
     * @return node.value
     */
    public String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? "Not Found" : node.value();
    }

}

public class HashTable {
    public static void main(String[] args){
        HashTableTest h = new HashTableTest(3);
        h.put("ye", "Yerin is smart");
        h.put("rin", "Yerin is a devil");
        h.put("an", "Life is beautiful?");
        h.put("apple", "I phone lover");
        h.put("an", "really?"); //modifying data
        System.out.println(h.get("ye"));
        System.out.println(h.get("rin"));
        System.out.println(h.get("an"));
        System.out.println(h.get("apple"));
        System.out.println(h.get("ap"));
    }
}

