package practico03;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private Map<Integer,List<Arco>> listaAdyacencia;
    private Integer cantidadVertices;
    private Integer cantidadArcos;

    public GrafoDirigido()
    {

        this.listaAdyacencia = new HashMap();
        this.cantidadVertices = 0;
        this.cantidadArcos = 0;
    }
    @Override
    public void agregarVertice(int verticeId)
    {
        // TODO Auto-generated method stub
        if (!this.listaAdyacencia.containsKey(verticeId))
        {
            this.listaAdyacencia.put(verticeId,new LinkedList<>());
            this.cantidadVertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId)
    {
        // Borrar los arcos que tengan a verticeId como origen
        List<Arco> arcos = this.listaAdyacencia.get(verticeId);
        if (arcos != null)
        {
            this.cantidadArcos -= arcos.size();
            this.listaAdyacencia.remove(verticeId);
        }
        // Borrar las referencias a verticeId como destino en los demás vértices
        for (List<Arco> adyacentes : this.listaAdyacencia.values())
        {
            for (Arco arco : adyacentes)
            {
                if (arco.getVerticeDestino() == verticeId)
                {
                    adyacentes.remove(arco);
                    this.cantidadArcos--;
                    break; //Termina el for si lo encuentra
                }
            }
        }/* O(n^2) */
        this.cantidadVertices--;
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1) && this.listaAdyacencia.containsKey(verticeId2))
        {
            Arco<T> arco = new Arco<>(verticeId1,verticeId2,etiqueta);
            List<Arco> listaAdyacenciaOrigen = listaAdyacencia.get(verticeId1);
            if (!listaAdyacenciaOrigen.contains(arco))
            {
                listaAdyacenciaOrigen.add(arco);
                this.cantidadArcos++;
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1) && this.listaAdyacencia.containsKey(verticeId2))
        {
            List<Arco> listaAdyacenciaOrigen = listaAdyacencia.get(verticeId1);
            listaAdyacenciaOrigen.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
            cantidadArcos -= listaAdyacenciaOrigen.size();
        }
    }

    @Override
    public boolean contieneVertice(int verticeId)
    {
        // TODO Auto-generated method stub
        return this.listaAdyacencia.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1))
        {
            List<Arco> adyacentes = this.listaAdyacencia.get(verticeId1);
            for (Arco a: adyacentes){
                if (a.getVerticeDestino() == verticeId2){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId1))
        {
            this.listaAdyacencia.get(verticeId1);
        }
        return null;
    }

    @Override
    public int cantidadVertices()
    {
        // TODO Auto-generated method stub
        return this.cantidadVertices;
    }

    @Override
    public int cantidadArcos()
    {
        // TODO Auto-generated method stub
        return this.cantidadArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices()
    {
        // TODO Auto-generated method stub
        return this.listaAdyacencia.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId)
    {
        // TODO Auto-generated method stub
        if (this.listaAdyacencia.containsKey(verticeId))
        {
            ArrayList<Integer> result = new ArrayList<>();
            List<Arco> adyacentes = this.listaAdyacencia.get(verticeId);
            for (Arco a: adyacentes){
                result.add(a.getVerticeDestino());
            }
            return result.iterator();
        }
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos()
    {
        // TODO Auto-generated method stub
        ArrayList<Arco<T>> arcos = new ArrayList();
        for (List<Arco> adyacentes : this.listaAdyacencia.values()) {
            for (Arco arco : adyacentes) {
                arcos.add(arco);
            }
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        ArrayList<Arco<T>> arcos = new ArrayList();
            for (Arco arco : this.listaAdyacencia.get(verticeId)) {
                arcos.add(arco);
            }
        return arcos.iterator();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grafo: \n");
        for (Integer verticeId : listaAdyacencia.keySet()) {
            sb.append(verticeId).append(": ");
            List<Arco> adyacentes = listaAdyacencia.get(verticeId);
            for (Arco arco : adyacentes) {
                sb.append(arco.getVerticeDestino()).append("(").append(arco.getEtiqueta()).append(")").append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
