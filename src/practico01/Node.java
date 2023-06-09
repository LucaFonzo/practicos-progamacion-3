package practico01;

public class Node<T extends Comparable> {
    private T info;
    private Node<T> next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
