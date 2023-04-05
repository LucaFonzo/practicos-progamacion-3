package practico01;
/*
* Ejercicio 3.
Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
elementos utilizando el método push(T o). Para retirar elementos de la colección se utiliza el
método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). Por
último, es posible invertir el orden de los elementos de la pila mediante el método reverse().
* */

public class Stack<T extends Comparable> {
    private LinkedList<T> stack;

    public Stack(){
        this.stack = new LinkedList<>();
    }

    public void push(T o){
        this.stack.insertFront(o);
    }

    public T pop(){
        return this.stack.extractFront();
    }

    public T top(){
        return this.stack.get(0);
    }

    public void reverse(){
        this.stack.reverse();
    }
}
