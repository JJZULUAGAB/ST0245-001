import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
    int [][] lista; 

	/**
	* Constructor para el grafo dirigido
	* @param vertices el numero de vertices que tendra el grafo dirigido
	*
	*/
	public DigraphAM(int size) {
        super(size);
	lista = new int[size][size]; 

    System.out.print("");
        
        
        
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public void addArc(int source, int destination, int weight) {
     lista[source][destination] = weight;
	}

	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> aux = new ArrayList<>();
		for(int i = 0; i<lista.length;i++){
			if(!(lista[vertex][i] == 0)){
				aux.add(i);
			}
				
		}
		if(aux.isEmpty())
			return null;
       return aux;
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
        return lista[source][destination];
		
	}
	public  static boolean  find_PathBFS(DigraphAM grafo ,int inicial,int objetivo ){
		if(objetivo > grafo.size())
		return false;
		boolean [] lista = new boolean[grafo.size()];
		return find_PathBFS( grafo ,inicial,objetivo,lista);
	}
	private static boolean  find_PathBFS(DigraphAM grafo ,int inicial,int objetivo,boolean[] visitados){
		boolean respuesta = false;
		visitados[inicial] = true;
		if(inicial == objetivo){
			return respuesta = true;
		}
		visitados[inicial] = true;
		Queue<Integer> lista = new LinkedList<>();
		ArrayList<Integer> visita = grafo.getSuccessors(inicial);
		if(visita == null)
			return false;
		for(int k: visita ){
			lista.add(k);
			if(k == objetivo){
				return true;
			}
		}
		while(lista.size() != 0){
			int nuevo = lista.poll();	
			if(visitados[nuevo] != true){
				respuesta = respuesta || find_PathBFS(grafo,nuevo,inicial,visitados);
			}
			if(respuesta == true)
			break;
		}

		return respuesta;
	}
	

}

import java.io.*; 
import java.util.*; 

    class Graph 
    { 
    private int V; 

    // Array of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 

    // Constructor 
    @SuppressWarnings("unchecked") 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 

    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);
    } 

    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 

        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 

    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 

        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 

    public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 

        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        g.addEdge(3, 4);

        System.out.println("A continuación se muestra el primer recorrido en profundidad"+ 
                        "(comenzando desde el vértice 2)"); 

        g.DFS(2); 
    } 
} 
