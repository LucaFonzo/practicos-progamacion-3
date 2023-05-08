package practico03;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();
        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        System.out.println(grafo);
        System.out.println("Arcos: " + grafo.cantidadArcos());
        System.out.println("Vertices: " + grafo.cantidadVertices());
        // Agregar arcos
        grafo.agregarArco(1, 2, "A");
        grafo.agregarArco(1, 3, "B");
        grafo.agregarArco(2, 4, "C");
        grafo.agregarArco(3, 4, "D");
        Iterator<Integer> iterator = grafo.obtenerVertices();
        System.out.println("Iterator: " + iterator.next() + iterator.next() + iterator.next() + iterator.next());
        System.out.println(grafo);
        System.out.println("Arcos: " + grafo.cantidadArcos());
        System.out.println("Vertices: " + grafo.cantidadVertices());
        // Borrar arco
        grafo.borrarArco(1, 2);
        System.out.println(grafo);
        System.out.println("Arcos: " + grafo.cantidadArcos());
        System.out.println("Vertices: " + grafo.cantidadVertices());
        // Borrar vértice
        grafo.borrarVertice(3);
        System.out.println(grafo);
        System.out.println("Arcos: " + grafo.cantidadArcos());
        System.out.println("Vertices: " + grafo.cantidadVertices());


    }
}
