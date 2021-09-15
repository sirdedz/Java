

public class Test {

	
	public static void main(String[] args) {
		
		//note: top variable must be changed to public for testing.
		
		StackBlock tester = new StackBlock(8);
		StackBlock tester2 = new StackBlock(1);
		StackBlock tester3 = new StackBlock(1);
		
		tester.push(tester2);
		tester.push(tester3);
		
		System.out.println(tester.isEmpty());
		
		System.out.println(tester.examine());
		System.out.println(tester.pop());
		
		System.out.println(tester.isEmpty());
		
		//System.out.println(tester.top);
		
		System.out.println(tester.pop());
		
		//System.out.println(tester.top);
		
		System.out.println(tester.isEmpty());
		
		System.out.println(tester.pop());
		System.out.println(tester.examine());

		
	}
}