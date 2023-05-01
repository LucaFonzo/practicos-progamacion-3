package practico03;

import java.util.ArrayList;
import java.util.List;
public class Ungraph {
    private int numVertices;
    private List<List<Integer>> listaAdyacencia;

    public Ungraph(int numVertices) {
        this.numVertices = numVertices;
        this.listaAdyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            this.listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino) {
        this.listaAdyacencia.get(origen).add(destino);
        this.listaAdyacencia.get(destino).add(origen);
    }

    public void eliminarArista(int origen, int destino) {
        this.listaAdyacencia.get(origen).remove(Integer.valueOf(destino));
        this.listaAdyacencia.get(destino).remove(Integer.valueOf(origen));
    }

    public List<Integer> getVerticesAdyacentes(int vertice) {
        return this.listaAdyacencia.get(vertice);
    }

    public int obtenerNumVertices() {
        return this.numVertices;
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
