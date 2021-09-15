import CITS2200.Graph;

public class GraphTest {

	static Graph o = CITS2200.Graph.randomGraph(5, true, 0.5);
	
	static SearchImp s = new SearchImp();
	
	public static void main(String[] args) {
		System.out.println(o.toString());
		/*System.out.println(o.getEdgeMatrix()[0][0]);
		System.out.println(o.getEdgeMatrix()[0][1]);
		System.out.println(o.getEdgeMatrix()[1][0]);
		System.out.println(o.getEdgeMatrix()[1][1]);*/
		
		
		System.out.println("A----A");
		
		int[] list = s.getConnectedTree(o, 0);
		
		for(int i = 0; i < 5; i++) {
			System.out.print(list[i]);
		}
		
		System.out.println();
		System.out.println("A----A");
		
		
		int[] distances = s.getDistances(o, 0);
		
		for(int i = 0; i < 5; i++) {
			System.out.print(distances[i]);
		}
		
		System.out.println();
		System.out.println("B----B");
		
		int[][] times = s.getTimes(o, 4);
		
		for(int i = 0; i < 5; i++) {
			System.out.print(times[i][0]);
			System.out.print(",");
			System.out.println(times[i][1]);
		}
		
	}
}
