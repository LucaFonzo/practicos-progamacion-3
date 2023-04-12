package practico01;

import java.util.Iterator;
/*
* Ejercicio 5.
    A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
    iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
    hora de recorrer la lista de principio a fin si se cuenta con un iterador?
* */

public class IteratorLinkedList implements Iterator {
    private Node current;

    public IteratorLinkedList(Node current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public Object next() {
        Node aux = this.current;
        this.current = this.current.getNext();
        return aux.getInfo();
    }

    public Comparable getCurrent() {
        return this.current.getInfo();
    }
}
