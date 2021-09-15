import CITS2200.Graph;

public class ShortestPathTest {

	static Graph o = CITS2200.Graph.randomWeightedGraph(5, true, 0.8, 100);
	
	static PathImp p = new PathImp();
	
	static PathTest tester = new PathTest();
	static String[] inputs = new String[] {"R", "5", "0.8", "100"};
	
	public static void main(String[] args) {
		
		System.out.println(o.toString());
		
		int[] distances = p.getShortestPaths(o, 0);
		
		for(int i = 0; i < distances.length; i++) {
			System.out.println(distances[i]);
		}
		
		System.out.println(o.toString());
		
		System.out.println("MST");
		System.out.println(p.getMinSpanningTree(o));
		
		PathTest.main(inputs, o);
		
	}
	
}
















/*int[] distances;

public int[] getShortestPaths(Graph graph, int v) {
	int[][] matrix = graph.getEdgeMatrix();
	int vertices = matrix.length;
	
	String[] colour = new String[vertices];
	
	Queue<Integer> unsearched = new LinkedList<Integer>();
	
	for(int i = 0; i < vertices; i++) {
		colour[i] = "white";
		if(i != v) {
			unsearched.add(i);
		}
	}
	
	distances = new int[vertices];
	
	Queue<Integer> searched = new LinkedList<Integer>();
	
	distances[v] = 0;
	colour[v] = "grey";
	
	while(!unsearched.isEmpty()) {
		
		int tempVert = findMin(vertices, graph, v);
		
		searched.add(tempVert);
		unsearched.remove(tempVert);
		
		findMinDistance(tempVert, matrix[tempVert], graph, v);
	}
	
	return null;
}

private int findMin(int x, Graph graph, int n) {
	int minVert = -1;
	
	int[] edges = graph.getEdgeMatrix()[n];
	
	for(int i = 0; i < x; i++) {
		if(minVert == -1 && i != n) {
			minVert = i;
		}else {
			
			if(graph.getWeight(n, i) < graph.getWeight(n, minVert) && edges[i] == 1) {
				minVert = i;
			}
		}
	}
	
	return minVert;
}

private void findMinDistance(int vertex, int[] edges, Graph graph, int n) {
	for(int i = 0; i < edges.length; i++) {
		if(graph.getWeight(n, i) > graph.getWeight(n, vertex) + graph.getWeight(i, vertex)) {
			if(edges[i] == 1) {
			}
		}
	}
}*/