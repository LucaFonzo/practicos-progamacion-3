package practico03;

import java.util.ArrayList;
import java.util.Iterator;

public class DFS {
    private Grafo grafo;
    private ArrayList<Integer> amarillos;
    private ArrayList<Integer> negros;
    private int tiempo;

    public DFS(Grafo grafo){
        this.grafo = grafo;
        this.amarillos = new ArrayList<>();
        this.negros = new ArrayList<>();
        this.tiempo = 0;
    }

    public void search(){
        Iterator<Integer> vertices = grafo.obtenerVertices();

        while(vertices.hasNext()){
            int vertice = vertices.next();

            if (!negros.contains(vertice))
            {
                search(vertice);
            }
        }
    }
    private void search(int verticeId){
        this.amarillos.add(verticeId); // Marca el vertice como visitado,pero no explorado completamente
        this.tiempo++;

        System.out.println("Visiting vertex " + verticeId + " at time " + this.tiempo);

        Iterator<Integer> vecinos = grafo.obtenerAdyacentes(verticeId);

        while(vecinos.hasNext()){
            int adyacente = vecinos.next();
            if(!this.negros.contains(adyacente)){ // Chequea si el adyacente ya fue visitado
                search(adyacente); // Recursivamente explora el adyacentes
            }else if (this.amarillos.contains(adyacente)){
                System.out.println("Hay ciclo!");
            }
        }

        this.amarillos.remove(verticeId); // Marca el vertice como completamente explorado
        this.negros.add(verticeId);
        this.tiempo++;
    }
}

