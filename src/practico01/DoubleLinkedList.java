package practico01;

/*
 *  Ejercicio 8.
    Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente
    vinculada.
* */
public class DoubleLinkedList<T extends Comparable> {
    private DoubleNode first;
    public DoubleLinkedList(){
        this.first = null;
    }

    public void insertFront(T value){
        DoubleNode<T> tmp = new DoubleNode<T>(value);
        tmp.setNext(this.first);
        if (!(this.first == null)){
            this.first.setPrev(tmp);
        }
        this.first = tmp;
    }

    public T extractFront(){
        DoubleNode<T> tmp = this.first;
        this.first = tmp.getNext();
        this.first.setPrev(null);
        return tmp.getValue();
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public T get(int index){
        DoubleNode<T> tmp = this.first;
        int count = 0;
        while (tmp != null){
            if (count == index){
                return tmp.getValue();
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        DoubleNode<T> aux = this.first;
        while (aux != null){
            result +=  aux.getValue() + (aux.getNext() != null ? "->": "");
            aux = aux.getNext();
        }
        return result;
    }
}
