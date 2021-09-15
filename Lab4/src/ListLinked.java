
import CITS2200.Link;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class ListLinked implements CITS2200.List{
	
	/**
	 * Setting variables for the list, 
	 * as well as after last and before first indexes.
	 */
	
	private Link before;
	private Link after;
	
	/**
	 * Linked List constructor.
	 * 
	 */
	public ListLinked() {
		
		after = new Link(null, null);
		before = new Link(null, after);
		
	}

	/**
	 * Moves window to the after last position.
	 * 
	 * @param window
	 */
	public void afterLast(WindowLinked window) {
		
		window.link = after;
		
	}

	/**
	 * Moves window to the before first position.
	 * 
	 * @param window
	 */
	public void beforeFirst(WindowLinked window) {
		window.link = before;
		
	}

	/**
	 * Deletes and returns element under window, moves window one place forward,
	 * throws OutOfBounds if window is over before first or after last positions.
	 * 
	 * @exception OutOfBounds
	 * @param window
	 * @return original object under window.
	 */
	public Object delete(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window) && !isBeforeFirst(window)) {
			Object temp = window.link.item;
			
			window.link.item = null;
			
			window.link = window.link.successor;
			
			return temp;
		}else {
			throw new OutOfBounds("Cannot delete sentinal node.");
		}
	}

	/**
	 * Throws OutOfBounds if over after last or before first, otherwise returns element
	 * under window.
	 * 
	 * @return the element under the window.
	 * @exception OutOfBounds
	 * @param window
	 */
	public Object examine(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window) && !isBeforeFirst(window)) {
			return window.link.item;
		}else {
			throw new OutOfBounds("Cannot examine sentinal node.");
		}
	}

	/**
	 * Element added to list after window position, throws OutOfBounds if window is over
	 * after last position.
	 * 
	 * @exception OutOfBounds
	 * @param window
	 * @param e
	 */
	public void insertAfter(Object e, WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window)) {
			
			window.link.successor = new Link(window.link.item, window.link.successor);
			
			window.link.successor.item = e;
			
		}else {
			throw new OutOfBounds("Inserting after end of list.");
		}
		
	}

	/**
	 * Element added to list before window position, throws OutOfBounds if window is over
	 * before first position.
	 * 
	 * @exception OutOfBounds
	 * @param window
	 * @param e
	 */
	public void insertBefore(Object e, WindowLinked window) throws OutOfBounds {
		if(!isBeforeFirst(window)) {
			
			window.link.successor = new Link(window.link.item, window.link.successor);
			
			if(isAfterLast(window)) {
				after = window.link.successor;
			}
			
			window.link.item = e;
			window.link = window.link.successor;
			
		}else {
			throw new OutOfBounds("Inserting before start of list.");
		}
		
	}

	/**
	 * Return true if window is over the after last position.
	 * 
	 * @return true if window is over the after last position.
	 * @param window
	 */
	public boolean isAfterLast(WindowLinked window) {
		
		return window.link == after;
	}

	/**
	 * Return true if window is over before first position.
	 * 
	 * @return true if window is over before first position.
	 * @param window
	 */
	public boolean isBeforeFirst(WindowLinked window) {

		return window.link == before;
	}

	/**
	 * Returns true if the list is empty.
	 * 
	 * @return if list is empty.
	 */
	public boolean isEmpty() {
		
		return before.successor == after;
	}

	/**
	 * Moves window to the next position in list. Throws OutOfBounds if in the after last position.
	 * 
	 * @exception OutOfBounds
	 * @param window
	 */
	public void next(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window)) {
			window.link = window.link.successor;
		}else {
			throw new OutOfBounds("Cannot move past end of list.");
		}
		
	}

	/**
	 * Moves to the previous position in the list. Throws OutOfBounds if in the before first position.
	 * 
	 * @exception OutOfBounds
	 * @param window
	 */
	public void previous(WindowLinked window) throws OutOfBounds {
		if(!isBeforeFirst(window)) {
			Link current = before.successor;
			Link previous = before;
			
			while(current != window.link) {
				previous = current;
				current = current.successor;
			}
			
			window.link = previous;
		}else {
			throw new OutOfBounds("No items before current window position.");
		}
		
	}

	/**
	 * Replaces the element at the window and returns the original element. Throws OutOfBounds if window
	 * is in the before first or after last position.
	 * 
	 * @return original element at window position
	 * @exception OutOfBounds
	 * @param window
	 * @param e
	 */
	public Object replace(Object e, WindowLinked window) throws OutOfBounds {
		if(!isBeforeFirst(window) && !isAfterLast(window)) {
			
			Object temp = window.link.item;
			
			window.link.item = e;
			
			return temp;
		}else {
			throw new OutOfBounds("Cannot replace sentinal node.");
		}
	}

}
