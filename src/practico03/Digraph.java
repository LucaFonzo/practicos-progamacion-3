package practico03;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private int numVertices;
    private List<List<Integer>> listaAdyacencia;

    public Digraph(int numVertices) {
        this.numVertices = numVertices;
        this.listaAdyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            this.listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino) {
        this.listaAdyacencia.get(origen).add(destino);
    }

    public void eliminarArista(int origen, int destino) {
        int index = this.listaAdyacencia.get(origen).indexOf(destino);
        if (index < 0){
            return;
        }
        this.listaAdyacencia.get(origen).remove(index);
    }

    public List<Integer> getVerticesAdyacentes(int vertice) {
        return new ArrayList<>(this.listaAdyacencia.get(vertice));
    }

    public int obtenerNumVertices() {
        return this.numVertices;
    }


    public void DFS(int vertice){
        boolean[] visitados = new boolean[this.numVertices];
        DFS(vertice,visitados);
    }

    private void DFS(int current,boolean[] visitados){
        visitados[current] = true;
        System.out.print(current + " ");
        List<Integer> adyacentes = this.getVerticesAdyacentes(current);
        for (int i = 0; i < adyacentes.size();i++){
            int adyacente = adyacentes.get(i);
            if (!visitados[adyacente]){
                DFS(adyacente,visitados);
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numVertices; i++) {
            sb.append(i).append(" -> ");
            sb.append(this.getVerticesAdyacentes(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
