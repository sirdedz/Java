import java.util.Queue;
import java.util.LinkedList;

import CITS2200.Graph;

public class SearchImp implements CITS2200.Search{
	

	/**
	 * Outputs an array specifying the parent vertex for each vertex,
	 * otherwise outputs -1 if no parent.
	 * 
	 * Uses a breadth first search.
	 * 
	 * n is starting vertex.
	 * 
	 * @return array
	 * @param graph
	 * @param n
	 */
	public int[] getConnectedTree(Graph graph, int n) {
		
		int[][] tempGraph = graph.getEdgeMatrix();
		
		int[] result = new int[tempGraph.length];
		String[] colour = new String[tempGraph.length];
		
		
		for(int i = 0; i < tempGraph.length; i++) {
			result[i] = -1;
			colour[i] = "white";
		}
		
		Queue<Object> queue = new LinkedList<Object>();
		Queue<Integer> vertex = new LinkedList<Integer>();
		
		queue.add(tempGraph[n]);
		vertex.add(n);
		
		colour[n] = "grey";
		
		
		while(!queue.isEmpty()) {
			int[] w = (int[]) queue.remove();
			int vertexNumber = vertex.remove();
					
			for(int i = 0; i < w.length; i++) {
				if(colour[i] == "white" && w[i] == 1) {
					result[i] = vertexNumber;
					colour[i] = "grey";
					
					queue.add(tempGraph[i]);
					vertex.add(i);
				}
			}
			
			colour[vertexNumber] = "black";
			
		}
		
		return result;
	}

	/**
	 * Outputs an array specifying the distance each vertex is from the starting vertex,
	 * otherwise -1 if the vertex is not reachable.
	 * 
	 * n is starting vertex.
	 * 
	 * @return array
	 * @param graph
	 * @param n
	 */
	public int[] getDistances(Graph graph, int n) {
		int[][] tempGraph = graph.getEdgeMatrix();
		
		int[] result = new int[tempGraph.length];
		String[] colour = new String[tempGraph.length];
		
		
		for(int i = 0; i < tempGraph.length; i++) {
			result[i] = -1;
			colour[i] = "white";
		}
		
		Queue<Object> queue = new LinkedList<Object>();
		Queue<Integer> vertex = new LinkedList<Integer>();
		
		queue.add(tempGraph[n]);
		vertex.add(n);
		result[n] = 0;
		colour[n] = "grey";
		
		int distance = 2;
		
		while(!queue.isEmpty()) {
			int[] w = (int[]) queue.remove();
			int vertexNumber = vertex.remove();
			
			for(int i = 0; i < w.length; i++) {
				if(colour[i] == "white" && w[i] == 1) {
					result[i] = result[i]+distance;
					colour[i] = "grey";
					
					queue.add(tempGraph[i]);
					vertex.add(i);
				}
			}
			
			distance++;
			
			colour[vertexNumber] = "black";
			
		}
		
		return result;
	}
	
	
	/**
	 * Declaring global variables that the recursive Depth First Search (DFS)
	 * can use to store values in, to be passed to the getTimes function.
	 */

	int[] finTime;
	int[] disTime;
	String[] colour;
	int time;
	int[][] matrix;
	
	/**
	 * Output array of the start and finish times for each vertex,
	 * where array[i][0] is the start time and array[i][1] is the finish
	 * time for vertex i.
	 * 
	 * n is the number of the starting vertex.
	 * 
	 * @return array
	 * @param graph
	 * @param n
	 */
	public int[][] getTimes(Graph graph, int n) {
		matrix = graph.getEdgeMatrix();
		
		int vertices = matrix.length;
		
		colour = new String[vertices];
		
		for(int i = 0; i < vertices; i++) {
			colour[i] = "white";
		}
		
		finTime = new int[vertices];
		
		int[][] times = new int[vertices][2];
		
		disTime = new int[vertices];
		
		time = 0;
		
		
		DFS(n);
		
		for(int i = 0; i < vertices; i ++) {
			times[i][0] = disTime[i];
			times[i][1] = finTime[i];
		}
		
		
		return times;
	}
	
	/**
	 * Private function to depth first search the graph, called in the getTimes function.
	 * Will store the discovery time and finish time of the search of each vertex in the 
	 * global variables provided, so the getTimes functioncan access this data.
	 * 
	 * 
	 * @param vertex
	 */
	private void DFS(int vertex) {
		colour[vertex] = "grey";
		disTime[vertex] = time;
		time++;
		
		int[] edges = matrix[vertex];
		
		for(int i = 0; i < edges.length; i++) {
			if(colour[i] == "white" && edges[i] == 1) {
				DFS(i);
			}
		}
		
		colour[vertex] = "black";
		finTime[vertex] = time;
		time++;
	}

}
