package practico03;

public class Main {
    public static void main(String[] args) {
        Digraph digraph = new Digraph(6);
        digraph.agregarArista(0, 1);
        digraph.agregarArista(0, 2);
        digraph.agregarArista(1, 2);
        digraph.agregarArista(2, 0);
        digraph.agregarArista(2, 3);
        digraph.agregarArista(3, 3);
        digraph.agregarArista(4, 5);
        digraph.agregarArista(5, 4);
        digraph.agregarArista(5, 3);
        System.out.println("Grafo dirigido");
        System.out.println(digraph);
        digraph.eliminarArista(5,3);
        digraph.eliminarArista(0,1);
        digraph.eliminarArista(1,2);
        System.out.println("Grafo dirigido");
        System.out.println(digraph);
        System.out.println("DFS");
        digraph.DFS(2);

        Digraph digraph2 = new Digraph(5);
        digraph2.agregarArista(0, 1);
        digraph2.agregarArista(0, 2);
        digraph2.agregarArista(1, 2);
        digraph2.agregarArista(2, 0);
        digraph2.agregarArista(2, 3);
        digraph2.agregarArista(3, 3);
        digraph2.agregarArista(4, 4);

        System.out.println("Recorrido DFS 2: ");
        digraph2.DFS(2);
    }
}
