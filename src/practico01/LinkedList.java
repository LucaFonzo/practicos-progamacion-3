package practico01;
/*
* Ejercicio 1.
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)
* */

public class LinkedList<T> {
    private Node<T> first;

    public LinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    public T extractFront() {
        return this.first.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        int count = 0;

        while (aux != null){
            if (count == index){
                return aux.getInfo();
            }
            count++;
            aux = aux.getNext();
        }
        return null;
    }

    public int size() {
        Node<T> aux = this.first;
        int count = 0;

        while (aux != null){
            count++;
            aux = aux.getNext();
        }
        return count;
    }
    @Override
    public String toString() {
        String result = "";
        Node<T> aux = this.first;
        while (aux != null){
            result +=  aux.getInfo() + (aux.getNext() != null ? "->": "");
            aux = aux.getNext();
        }
        return result;
    }
}
