package my.learning.javarush.arrays;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }
    public String get(int index) {
        if (first.next == null){
            return null;
        }
        if (index ==0){
            return first.next.value;
        }
        int result = 0;
        Node curr = first.next;
        while(curr!=null){
            ++result;
            if (result==index){
                return curr.next.value;
            } curr = curr.next;
        }
        return null;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;

    }
}

