package practico03;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private Map<Integer,List<Arco>> listaAdyacencia;

    public GrafoDirigido()
    {
        this.listaAdyacencia = new HashMap();
    }
    @Override
    public void agregarVertice(int verticeId)
    {
        // TODO Auto-generated method stub
        this.listaAdyacencia.put(verticeId,new LinkedList<>());
    }

    @Override
    public void borrarVertice(int verticeId)
    {
        // TODO Auto-generated method stub
        this.listaAdyacencia.values().stream().forEach(v -> v.remove(verticeId));
        this.listaAdyacencia.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1) && this.listaAdyacencia.containsKey(verticeId2))
        {
            Arco<T> arco = new Arco<>(verticeId1,verticeId2,etiqueta);

            if (!this.listaAdyacencia.get(verticeId1).contains(arco))
            {
                this.listaAdyacencia.get(verticeId1).add(arco);
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1) && this.listaAdyacencia.containsKey(verticeId2))
        {
            this.listaAdyacencia.get(verticeId1).forEach(a ->
            {
                if (a.getVerticeDestino() == verticeId2)
                {
                    this.listaAdyacencia.remove(a);
                    return;
                }
            });
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        // TODO Auto-generated method stub
        return this.listaAdyacencia.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1) && this.listaAdyacencia.containsKey(verticeId2))
        {
            List<Arco> adyacentes = this.listaAdyacencia.get(verticeId1);
            for ()
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int cantidadVertices() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int cantidadArcos() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        GrafoDirigido grafoDirigido = new GrafoDirigido();
    }
}
