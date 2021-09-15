import CITS2200.Overflow;
import CITS2200.Underflow;

public class StackBlock implements CITS2200.Stack{
	
	/** Declaring the object which will act as our stack.
	 * 
	 * 	Note: The top of the stack begins as the zero-index. When elements are added the top is updated.
	 */
	private Object[] items;
	private int top;
	private int size;
	
	/**
	 * Initialises a new instane of the class, creating an array of size s and setting the top object index to zero.
	 * 
	 * @param s
	 */
	public StackBlock(int s) {
		items = new Object[s];
		top = 0;
		size = s;
	}

	/**
	 * Retrieves the top object from the stack.
	 */
	public Object examine() throws Underflow {
		/**
		 * Simply returns the object at the top index position of the stack.
		 */
		if(this.isEmpty()) {
			throw new Underflow("Empty Stack");
		}else {
			return items[top];
		}
		
	}
	
	/**
	 * checks to see if the stack is empty.
	 */
	public boolean isEmpty() {
		/**
		 * Checks if the top index position of the stack is populated.
		 */
		if(items[top] == null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retrieves the top object from the stack and removes it.
	 */
	public Object pop() throws Underflow {
		
		if(!this.isEmpty()) {
			/**
			 * Temp is used to store the top object temporarily to be returned after it is removed from the stack.
			 */
			Object temp = items[top];
			
			/**
			 * Replacing the top item with null, then setting the top index back one increment, only if the stack is not empty.
			 */
			items[top] = null;
			
			if(top >= 1) {
				top--;
			}
			
			
			return temp;
		}else {
			throw new Underflow("Empty Stack");
		}
	}
	
	/**
	 * First must check that the stack is not empty.
	 * 
	 * Adds the objected passed into the top of the stack, then updates the top index.
	 * @param arg0
	 */
	public void push(Object arg0) throws Overflow {
		if(this.isEmpty()) {
			items[top] = arg0;
		}else if(top == size - 1){
			throw new Overflow("Stack is full");
		}else {
			top++;
			
			items[top] = arg0;
		}
	}

	
}
