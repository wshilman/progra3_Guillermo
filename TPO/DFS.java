package TPO;
import Implementaciones.ImplemEstatica;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j, w;
	
		ImplemEstatica grafo = new ImplemEstatica();
		grafo.inicializarGrafo(10);
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		
		grafo.agregarArista(1 , 2 , 1);
		grafo.agregarArista(1 , 4 , 1);
		grafo.agregarArista(2 , 3 , 1);
		grafo.agregarArista(3 , 4 , 1);
		grafo.agregarArista(4 , 2 , 1);
		
        System.out.println("Los vertices y aristas del grafo se representaran a traves de una matriz de la siguiente manera:");
		
		System.out.println("\t");
		
		grafo.mostrarMatriz();
		
		

		System.out.println("Vertices con sus respectivos padres segun el recorrido de DFS:");
		
		System.out.println("\t");
		
		int[] p = new int[5];
		
		// Creo un arreglo con marca en B (vertices no visitados)
		String marca[] = new String[5];
		for(w=0; w<marca.length; w++) {
			marca[w] = "B";
		}
		
		int[] dfs = DFS(grafo, 1, p, marca);
		
		// Voy leyendo el arreglo de padres de salida y reconstruyendo el recorrido de c�mo se visit� el Grafo.
		for(j=1; j<dfs.length; j++) {
			System.out.println("Hijo: "+j+" / Padre: "+dfs[j]);
		}
	}
	
	public static int[] DFS(ImplemEstatica grafo, int origen, int[]p, String[] marca) {
		// Utilizo una marca para ver el estado de cada nodo, donde:
		// G es descubierto, B es no visitado y N visitado.
		marca[origen] = "G";
		
		// Recorro los adyacentes al nodo origen. 
		for (int v: grafo.adyacentes(origen)) 
			if(marca[v] == "B") {
				// P es un arreglo de Padres y nos sirve para dibujar el grafo de salida.
				// El �ndice nos dice el hijo y el elemento que est� en ese �ndice es el padre.
				p[v] = origen;
				// Llamada recursiva a DFS donde origen ahora es v.
				DFS(grafo, v, p, marca);
			}
		
		// Cambio a visitado.
		marca[origen] = "N";
		
		// Retorno el arreglo de padres 
		return p;
		
	}

}
