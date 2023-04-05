package practico01;

public class DoubleNode<T extends Comparable> {

    private T value;
    private DoubleNode prev;
    private DoubleNode next;
    public DoubleNode(T value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DoubleNode getNext(){
        return this.next;
    }
    public DoubleNode getPrev(){
        return this.prev;
    }
    public T getValue(){
        return this.value;
    }
    public void setNext(DoubleNode next){
        this.next = next;
    }
    public void setPrev(DoubleNode prev){
        this.prev = prev;
    }
}
