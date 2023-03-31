package practico01;
/*
* Ejercicio 1.
Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)
* */

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
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
        Node<T> aux = this.first;
        this.first = this.first.getNext();
        return aux.getInfo();
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

    public void reverse(){
        Node<T> prev = null;
        Node<T> current = this.first;
        Node<T> next;
        while (current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.first = prev;
    }
    /*
    * Ejercicio 4.
    A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
    indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
    -1 si el elemento no existe en la lista.

    * */
    public int indexOf(T target){
        Node<T> current = this.first;
        int index = 0;
        while (current != null){
            if (current.getInfo() == target){
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public boolean contains(T valor){
        for (T i:this){
            if (i == valor){
                return true;
            }
        }
        return false;
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
    @Override
    public Iterator<T> iterator() {
        return new IteratorLinkedList(this.first);
    }
}

