
public class DequeTest {

	public static void main(String[] args) {
		
		
		DequeCyclic<String> newlist = new DequeCyclic<String>(8);
		
		String c = "one";
		String b = "two";
		
		System.out.println(newlist.isFull());
		System.out.println(newlist.isEmpty());
		
		newlist.pushRight(c);
		
		System.out.println(newlist.isFull());
		
		newlist.pushLeft(c);	
		newlist.pushLeft(b);
		newlist.popLeft();
		newlist.popLeft();
		newlist.popLeft();
		
		System.out.println(newlist.isEmpty());
		
		System.out.println(newlist.peekLeft());
	}
	
	
}
