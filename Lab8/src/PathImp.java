import java.util.LinkedList;
import java.util.Queue;

import CITS2200.Graph;

public class PathImp implements CITS2200.Path{
	

	/**
	 * Calculates and returns the weight of the minimum spanning tree, otherwise
	 * return -1 if no minimum spanning tree is found.
	 * 
	 * @return weight
	 * @param graph
	 */
	public int getMinSpanningTree(Graph graph) {
		
		int vertices = graph.getNumberOfVertices();
		
		int[][] edges = new int[vertices*vertices][3];
		
		/**
		 * add all edges to array, first index is weight, second is starting vertex, third is ending vertex
		 */
		int count = 0;
		
		for(int i = 0; i < vertices; i++) {
			for(int b = 0; b < vertices; b++) {
				int[] temp = new int[] {graph.getWeight(i, b), i, b};
				
				edges[count] = temp;
				
				count++;
			}
		}
		
		Queue<Integer> searched = new LinkedList<Integer>();
		
		quickSort(edges, 0, edges.length-1);
		
		int tempWeight = 0;
		
		int x = 0;
		while(edges[x][0] == 0) {
			x++;
		}
		
		searched.add(edges[x][1]);
		searched.add(edges[x][2]);
		
		tempWeight += edges[x][0];
		
		for(int i = x; i < edges.length; i++) {
			if(!searched.contains(edges[i][2]) && edges[i][0] != 0) {
				searched.add(edges[i][2]);
				tempWeight += edges[i][0];
				
				if(!searched.contains(edges[i][1])) {
					searched.add(edges[i][1]);
				}
			}
		}
		
		if(searched.size() == vertices) {
			return tempWeight;
		}else {
			return -1;
		}
	}
	
	/**
	 * Private quicksort method sorts an array into ascending order.
	 * 
	 * 
	 * @param a, array
	 * @param p, first index of array
	 * @param r, last index of array
	 */
	private void quickSort(int[][] a, int p, int r) {
		if (p<r) {
			
			int q = partition(a, p, r);
			
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
			
		}
	}
	
	/**
	 * Private method to partition the array in which quicksort is working on.
	 * 
	 * Returns index.
	 * 
	 * @param a, array
	 * @param p, first index of arrray
	 * @param r, last index of array
	 * @return index
	 */
	private int partition(int[][] a, int p, int r) {
		int x = a[r][0];
		
		int i = p-1;
		
		for (int j = p; j <= r-1; j++) {
			if (a[j][0] <= x) {
				i++;
				
				int[] temp = a[i];
				
				a[i] = a[j];
			
				a[j] = temp;
			}
		}
		
		int[] temp = a[i+1];
		
		a[i+1] = a[r];
		a[r] = temp;

		
		return i+1;
	}
	

	/**
	 * Uses Dijkstra's algorithm to calculate and return an array 
	 * of the distances from the given start vertex (n) to each of the other
	 * vertices in the graph.
	 * 
	 * @return distances
	 * @param graph
	 * @param starting vertex, n
	 */
	
	/**
	 * Global Variables
	 */
	int[] distances;
	Queue<Integer> searched;
	Queue<Integer> unsearched;
	
	public int[] getShortestPaths(Graph graph, int n){
		
		int[][] matrix = graph.getEdgeMatrix();
		int vertices = graph.getNumberOfVertices();
		
		distances = new int[vertices];
		
		for(int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		distances[n] = 0;
		
		unsearched = new LinkedList<Integer>();
		searched = new LinkedList<Integer>();
		
		unsearched.add(n);
		
		while(searched.size() != vertices) {
			int tempVertex = unsearched.remove();
			
			searched.add(tempVertex);
			
			findMin(tempVertex, matrix, graph);
		}
		
		
		return distances;
		
	}
	
	/**
	 * Private function which finds the minimum weight vertex from the starting vertex.
	 * 
	 * @param v starting vertex
	 * @param matrix
	 * @param graph
	 */
	private void findMin(int v, int[][] matrix, Graph graph) {
		int dist = -1;
		int newDist = -1;
		
		for(int i = 0; i < matrix[v].length; i++) {
			if(!searched.contains(i) && matrix[v][i] != 0) {
				dist = graph.getWeight(v, i);
				newDist = distances[v] + dist;
				
				if(newDist < distances[i]) {
					distances[i] = newDist;
				}
				
				unsearched.add(i);
			}
		}
	}

}
