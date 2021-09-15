import java.util.ArrayList;
import java.util.LinkedList;

import CITS2200.BinaryTree;
import CITS2200.Iterator;

public class Treetest {
	
	static BinTree<Integer> left = new BinTree<Integer>();
	
	static BinTree<Integer> right = new BinTree<Integer>();
	
	static BinTree<String> Lonechild = new BinTree<String>("right", left, right);
	static BinTree<Integer> Lonechild2 = new BinTree<Integer>(3, left, right);
	static BinTree<Integer> Rone = new BinTree<Integer>(9, left, right);
	static BinTree<Integer> Lone = new BinTree<Integer>(1, Lonechild, Lonechild2);
	static BinTree<Integer> Lone1 = new BinTree<Integer>(6, Lonechild, Lonechild2);
	
	static BinTree<Integer> root = new BinTree<Integer>(7, Lone, Rone);
	
	
	static BinTree<Integer> root1 = new BinTree<Integer>(7, Lone1, Rone);
	
	
	static BinTree<Integer> LoneTwo = new BinTree<Integer>(7, Lone, Rone);
	static BinTree<Integer> RoneTwo = new BinTree<Integer>(7, Lone, Rone);
	static BinTree<Integer> rootTwo = new BinTree<Integer>(7, Lone, Rone);
	
	public static <E> void main(String[] args) {
		
		//System.out.println(root.getLeft().isEmpty());
		
		//System.out.println(root.getLeft());
		
		//System.out.println(root.getRight());
		
		//System.out.println(root.toString());
		
		ArrayList<Integer> str = new ArrayList<Integer>();
		str.add(1);
		str.add(2);
		
		System.out.println(root.equals(root));
		System.out.println(right.equals(left));
		System.out.println(left.equals(right));
		
		System.out.println(left.equals(root));
		System.out.println(root.equals(left));
		System.out.println(right.equals(root1));
		System.out.println(root1.equals(right));
		System.out.println(right.equals(str));
		System.out.println(str.equals(right));
		System.out.println(root.equals(root));
		
		
		Iterator<E> it = (Iterator<E>) root.iterator();
		
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		
		
	}
	
}

/*if(a instanceof BinaryTree) {

BinaryTree<E> tree = (BinaryTree<E>)a;

if(!contents.isEmpty()) {

	traverseCheck(tree, contents);
	
}else {
	if(tree.isEmpty()) {
		return true;
	}else {
		return false;
	}
}

if(contents.isEmpty()) {
	return true;
}else {
	return false;
}

}else{
return false;
}*/
