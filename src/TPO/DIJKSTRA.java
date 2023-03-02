package TPO;

import Implementaciones.ImplemEstatica;

public class DIJKSTRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplemEstatica grafo = new ImplemEstatica();
        grafo.inicializarGrafo(6);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        
        grafo.agregarArista(1, 5, 10);
        grafo.agregarArista(1, 6, 5);
        grafo.agregarArista(6, 5, 10);
        grafo.agregarArista(5, 4, 20);
        grafo.agregarArista(4, 3, 5);
        grafo.agregarArista(3, 2, 10);
        grafo.agregarArista(6, 2, 20);
        grafo.agregarArista(1, 3, 40);
        grafo.agregarArista(2, 4, 5);
        grafo.agregarArista(3, 5, 5);

        
        
        int[] listado = grafo.dijkstra(1);
        
        for(int i = 0 ;i < listado.length; i++ ) {
        	System.out.println(listado[i]);
        }
        //System.out.println(grafo.dijkstra(1)[0]);

	}

}
