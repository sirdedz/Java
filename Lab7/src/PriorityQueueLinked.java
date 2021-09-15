import CITS2200.IllegalValue;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;
import CITS2200.Underflow;

public class PriorityQueueLinked<E> implements CITS2200.PriorityQueue<Object>{

	/**
	 * nested class
	 * 
	 * 
	 * includes fields: item, priority, next
	 * 
	 * @author darbyedwards
	 */
	private class Link<E>{
		Object item;
		int priority;
		Link<Object> next;
		
		
		/**
		 * Link constructor
		 * 
		 * @param o
		 * @param p
		 * @param n
		 */
		public Link(Object o, int p, Link<Object> n) {
			this.item = o;
			this.priority = p;
			this.next = n;
		}
	}
	
	
	/**
	 * Front link is declared.
	 */
	private Link<Object> front;
	
	/**
	 * Constructor
	 * @return 
	 */
	void PriorityQueue(){
		front = null;
	}
	
	
	/**
	 * Dequeue and return the first item from the queue.
	 * 
	 * Throw an Underflow exception if the queue is empty.
	 * 
	 * @return item
	 * @exception Underflow
	 */
	public Object dequeue() throws Underflow {
		if(!isEmpty()) {
			Object temp = (Object) front.item;
			
			front = front.next;
			
			return temp;
		}else {
			throw new Underflow("Empty Queue");
		}
	}

	/**
	 * Add item to the priority queue in front of all items with a 
	 * key less than the int provided (key).
	 * 
	 * Note: items with the same key are sorted in chronological order.
	 * 
	 * Throw IllegalValue exception if the key is less than 0.
	 * 
	 * @param item
	 * @param key
	 * @exception IllegalValue
	 */
	public void enqueue(Object item, int key) throws IllegalValue {
		if(isEmpty() || key > front.priority) {
			front = new Link<Object>(item, key, front);
		}else {
			Link<Object> link = front;
			
			while(link.next != null && link.next.priority >= key) {
				link = link.next;
			}
			
			link.next = new Link<Object>(item, key, link.next);
		}
		
	}

	/**
	 * Return the first item from the queue.
	 * 
	 * Throws Underflow exception if the queue is empty.
	 * 
	 * @return item
	 * @exception Underflow
	 */
	public Object examine() throws Underflow {
		if(!isEmpty()) {
			return (Object) front.item;
		}else {
			throw new Underflow("Empty Queue");
		}
	}

	/**
	 * Return true if the queue is empty, otherwise return false.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return front == null;
	}
	
	
	/**
	 * Nested iterator class implements CITS2200.Iterator
	 * 
	 * @author darbyedwards
	 *
	 */
	private class IteratorSub<E> implements CITS2200.Iterator<Object>{
		
		private Link<Object> frontSub;

		/**
		 * Constructor, takes the front link as parameter.
		 * 
		 * @param link
		 */
		public IteratorSub(Link<Object> temp) {
			frontSub = temp;
		}

		/**
		 * Returns true if there is a next element.
		 * 
		 * @return boolean
		 */
		public boolean hasNext() {
			
			if(frontSub != null) {
				return true;
			}else {
				return false;
			}
		}

		/**
		 * Returns the next element, moves the iterator to over that element.
		 * 
		 * @returns element
		 */
		public Object next() throws OutOfBounds {
			if(this.hasNext()) {
				Object o = (Object) frontSub.item;
				
				frontSub = frontSub.next;
				
				
				return o;
			}else {
				throw new OutOfBounds("No more items in queue.");
			}
		}
	
	}
	
	/**
	 * Create an instance of an iterator to handle the queue,
	 * return this iterator.
	 * 
	 * Need to traverse through the linkedlist and build a resulting queue,
	 * in priority order.
	 * 
	 * @return iterator
	 */
	public Iterator iterator() {
		
		Link<Object> temp = front;
		
		Iterator<Object> iterator = new IteratorSub(temp);
		
		return iterator;
	}


}
