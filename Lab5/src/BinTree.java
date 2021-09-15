import java.util.LinkedList;
import java.util.Queue;

import CITS2200.BinaryTree;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;

public class BinTree<E> extends CITS2200.BinaryTree<E>{
	
	/**
	 * Constructor
	 */
	public BinTree() {
		super();
	}

	/**
	 * Constructor. Item is the node's item, b1 is the left child, b2 is the right child.
	 * 
	 * @param item
	 * @param b1
	 * @param b2
	 */
	public BinTree(E item, BinaryTree b1, BinaryTree b2) {
		super(item, b1, b2);
	}
	
	
	/**
	 * Returns true if both binary trees have exactly the same structure.
	 * 
	 * Traverse this tree first, entering contents to a queue, then check
	 * the contents against the provided tree.
	 * 
	 * @return true if both trees have the same structure.
	 * @param a
	 */
	public boolean equals(Object a) {
			
		Queue<E> contents = new LinkedList<E>();
		
		this.traverseThis(this, contents);
		
		Queue<E> contents2 = new LinkedList<E>();
		
		if(a instanceof BinaryTree) {
			
			BinaryTree<E> tree = (BinaryTree<E>)a;
			traverseThis(tree, contents2);
			
			if(contents.equals(contents2)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * 
	 * Traverse the tree, storing each item in the queue, including null
	 * for external leafs to store tree structure as well.
	 * 
	 * @param a
	 * @param list
	 */
	private void traverseThis(BinaryTree<E> a, Queue<E> list) {
		
		if(!a.isEmpty()) {
			list.add(a.getItem());
			
			traverseThis(a.getLeft(), list);
			traverseThis(a.getRight(), list);
		}else {
			list.add(null);
		}
	}
	
	/**
	 * Traverse the tree and add non-null items to the queue.
	 * 
	 * @param a
	 * @param list
	 */
	private void itTraverse(BinaryTree<E> a, Queue<E> list) {	
		if(!a.isEmpty()) {
			list.add(a.getItem());
			
			itTraverse(a.getLeft(), list);
			itTraverse(a.getRight(), list);
		}
	}
	
	/**
	 * Nested iterator class implements CITS2200.Iterator
	 * 
	 * @author darbyedwards
	 *
	 */
	private static class IteratorSub<E> implements CITS2200.Iterator<E>{
		
		Queue<E> items = new LinkedList<E>();
		
		
		/**
		 * Constructor, takes queue of items as parameter.
		 * 
		 * @param contents
		 */
		public IteratorSub(Queue<E> contents) {
			items = contents;
		}

		/**
		 * Returns true if there is a next element.
		 * 
		 * @return boolean
		 */
		public boolean hasNext() {
			
			if(items.peek() != null) {
				return true;
			}else {
				return false;
			}
		}

		/**
		 * Returns the next element.
		 * 
		 * @returns element
		 */
		public E next() throws OutOfBounds {
			if(this.hasNext()) {
				return items.remove();
			}else {
				throw new OutOfBounds("No more items in queue.");
			}
		}	
	}
	
	
	/**
	 * Provides an instance of iterator from the CITS2200 library,
	 * to return every element stored in the tree exactly once.
	 * 
	 * @return iterator
	 */
	public Iterator<E> iterator(){
		
		Queue<E> iteritems = new LinkedList<E>();
		
		itTraverse(this, iteritems);
		
		Iterator<E> it = new IteratorSub<E>(iteritems);
		
		return it;
		
	}
	
}
