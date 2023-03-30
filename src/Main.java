import practico01.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> listaEnteros = new LinkedList<>();
        listaEnteros.insertFront(4);
        listaEnteros.insertFront(3);
        listaEnteros.insertFront(7);
        listaEnteros.insertFront(1);
        System.out.println(listaEnteros.size());
        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros);
    }
}
