package TPO;

import Implementaciones.ImplemEstatica;

public class Floyd {

	public static void main(String[] args) {
		
		int j, w;
		
		ImplemEstatica grafo = new ImplemEstatica();
		grafo.inicializarGrafo(7);
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArista(1 , 2 , 10);
		grafo.agregarArista(1 , 6 , 7);
		
		grafo.agregarArista(2 , 3 , 15);
		
		grafo.agregarArista(3 , 4 , 22);
		
		grafo.agregarArista(4 , 5 , 1);
		
		grafo.agregarArista(6 , 4 , 30);
		grafo.agregarArista(6 , 5 , 45);
		
		//muestro la matriz: 
		//exceptuando los ceros de la diagonal principal, 
		//el resto indicara cuando no hay conexion entre vertices
		
		System.out.println("El grafo en forma matricial se mostrara de la siguiente manera:");
		
		System.out.println("\t");
		
		grafo.mostrarMatriz();
		
		System.out.println("*******************************************");
		
		System.out.println("\t");
		
		System.out.println("El camino minimo para llegar a los vertices sera:");
		System.out.println("(El valor 99999 hace referencia a un valor alto como infinito, es decir, que no habra conexion entre los vertices)");
		
		System.out.println("\t");
		
		int[][] floyd = Floyd(grafo.retornarMatriz());
		
		// Muestro la matriz con los caminos m�s cortos entre cada nodo.
		for(j=0; j<floyd.length; j++) {
			for(w=0; w<floyd.length; w++) {
				System.out.print(floyd[j][w] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static int[][] Floyd(int matriz[][]) {
		// Floyd recibe una matriz de costos y nos devuelve una matriz que nos 
		// permite saber el camino m�s corto para ir de un nodo a otro.
		
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j] == 0)
                    matriz[i][j] = 99999; //si no existe una arista entre 2 nodos seteo 99999
                if(i == j) {
                	matriz[i][j] = 0; //Seteo la diagonal principal en 0
                }
            }
        }
		
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                	if(matriz[j][i] + matriz[i][k] < matriz[j][k]) {
                		matriz[j][k] = matriz[j][i] + matriz[i][k];
                    }
                }
            }
        }
		
		// Devuelvo la matriz con el caminos m�s cortos entre los vertices.
		return matriz;
		
	}

}
