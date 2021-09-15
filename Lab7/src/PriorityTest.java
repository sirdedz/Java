import CITS2200.Iterator;

public class PriorityTest {
	
	
	public static void main(String args[]) {
		
		
		
		PriorityQueueLinked<Integer> queue = new PriorityQueueLinked<Integer>();
		
		queue.enqueue(0, 0);
		queue.enqueue(5, 2);
		queue.enqueue(6, 6);
		queue.enqueue(10, 19);
		queue.enqueue(7, 3);
		
		System.out.println(queue.examine());
		System.out.println("-------");
		
		Iterator<Integer> i =  queue.iterator();
		
		
		System.out.println(queue.isEmpty());
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println(queue.examine());

	}
}
