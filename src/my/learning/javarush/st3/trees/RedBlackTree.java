package my.learning.javarush.st3.trees;

//package com.javarush.task.task36.task3604;

public class RedBlackTree {
    private static final Node EMPTY = new Node(0);// пустой элемент черный, элемент 0 - листья - нули

    static {
        EMPTY.left = EMPTY; //
        EMPTY.right = EMPTY;
    }

    protected Node current;//текущая нода
    private Node parent;//родительская нода
    private Node grand;//
    private Node great;
    private Node header;// корень

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);//создается корень с мин значением и два пустых нода
        // сразу создается  нода, у которой - два листа - нуллы, и черная
        header.left = EMPTY;// левый - ссылка на пустой
        header.right = EMPTY;//правый ссылка на пустой
    }

    public boolean isEmpty() { //#TODO
        return header.right == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) { //#TODO
        current = grand = parent = header; // текущий равен корню
        EMPTY.element = item;//пустой элемент равен нашему новому
        while (current.element != item) { // до тех пор пока каррент не будет равен айтему
            great = grand;
            grand = parent;
            parent = current;//парент = каррент
            current = item > current.element ? current.right : current.left;
            //у каррента
            if (current.left.color == Color.RED && current.right.color == Color.RED) {
                reorient(item); //если левый -красный
            }
        }
        // current = item

        if (current != EMPTY) {
            return;
        }

        current = new Node(item, EMPTY, EMPTY);

        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item);
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) { //#TODO
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }
    public void getRedBlackTree(){
        System.out.println(grand);
        System.out.println(parent);
        System.out.println(current);
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {// создается нода, с нулевыми правым и левым листьями
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;//присваивается черный цвет
        }
    }
}
