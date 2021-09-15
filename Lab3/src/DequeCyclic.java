
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic<E> implements CITS2200.Deque<E>{
	
	
	/**
	 * Set up parameters
	 */
	private int first;
	private int last;

	private E[] items;
	
	
	
	@SuppressWarnings("unchecked")
	public DequeCyclic(int s){
		
		/**
		 * Constructor for the Deque, sets variables and creates deque.
		 */
		
		items = (E[]) new Object[s+1];
		
		first = 0;
		last = s;
		
	}

	public boolean isEmpty() {
		/**
		 * Checks if deque is empty
		 * 
		 * @returns whether the deque is empty
		 */
		
		return (first == (last + 1) % items.length);
	}

	public boolean isFull() {
		/**
		 * Checks if deque is full
		 * 
		 * @returns whether the deque is full
		 */
		
		return (first == (last + 2) % items.length);
	}

	public E peekLeft() throws Underflow {
		
		/**
		 * Returns left-most item in deque, otherwise throws underflow exception if deque is empty
		 * 
		 * @returns the left-most item in the deque
		 * @exception Underflow if deque is empty
		 */
		
		if(!this.isEmpty()) {
			return items[first];
		}
		else {
			throw new Underflow("List is empty.");
		}
	}

	public E peekRight() throws Underflow {

		/**
		 * Returns right-most item in deque, otherwise throws underflow exception if deque is empty
		 * 
		 * @returns the right-most item in the deque
		 * @exception Underflow if deque is empty
		 */
		
		
		if(!this.isEmpty()) {
			return items[last];
		}
		else {
			throw new Underflow("List is empty.");
		}
	}

	public E popLeft() throws Underflow {

		/**
		 * Removes and returns the left-most item in the deque, otherwise throws underflow exception if the deque is empty.
		 * 
		 * @returns left-most item in deque
		 * @exception Underflow if deque is empty
		 */
		
		if(!this.isEmpty()) {			
			E temp = items[first];
			
			first = (first + 1) % items.length;
			
			return temp;
		}
		else {		
			throw new Underflow("List is empty.");
		}
	}

	public E popRight() throws Underflow {

		/**
		 * Removes and returns the right-most item in the deque, otherwise throws underflow exception if the deque is empty.
		 * 
		 * @returns right-most item in deque
		 * @exception Underflow if deque is empty
		 */
		
		if(!this.isEmpty()) {
			E temp = items[last];
			
			last = (((last - 1) % items.length) + items.length) % items.length;
			
			return temp;
		}
		else {
			throw new Underflow("List is empty.");
		}
		
	}

	public void pushLeft(E c) throws Overflow {
		
		/**
		 * Adds object c to the left-most position in the deque. If the deque is full throws an overflow exception.
		 * 
		 * @param c the item to add
		 * @exception Overflow if deque is full
		 */
		
		if(!this.isFull()) {
			
			first = (((first - 1) % items.length) + items.length) % items.length;
			
			items[first] = c;
			
		}else {
			throw new Overflow("List is full.");
		}
		
	}

	public void pushRight(E c) throws Overflow {

		/**
		 * Adds object c to the right-most position in the deque. If the deque is full throws an overflow exception.
		 * 
		 * @param c the item to add
		 * @exception Overflow if deque is full
		 */
		
		if(!this.isFull()) {
			
			last = (last + 1) % items.length;
			
			items[last] = c;
			
			
		}else {
			throw new Overflow("List is full.");
		}
		
	}
}
