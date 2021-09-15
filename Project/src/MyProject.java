// Darby Edwards (22713383)

/**
 * CITS2200 Project 2020.
 * 
 * 
 * @author Darby Edwards, UWA, 2271 3383
 */
public class MyProject implements Project{
	
	/**
	 * Zero argument constructor
	 */
	public MyProject(){
		
	}

	/**
	 * Computes the number of pixels that change when performing a black flood-fill,
	 * from the pixel at (row, col) in the given image.
	 * 
	 * Flood fill changes the given pixel and all pixels of the same colour
	 * within one pixel to the specified colour.
	 * 
	 * Global variables colour, count and searched are used so the recursive function can store 
	 * values;
	 * 
	 * @return int number of pixels changes
	 * @param image
	 * @param row
	 * @param col
	 */
	private int count;
	private boolean[][] searched;
	public int floodFillCount(int[][] image, int row, int col) {
		
		int colour = image[row][col];
		searched = new boolean[image.length][image[0].length];
		
		count = 0;
		
		if(image[row][col] == 0) {
			return 0;
		}
		
		recursiveSearch(colour, row, col, image);
		
		if(count == 0) {
			count = 1;
		}
		
		return count;
	}
	
	/**
	 * Private function for recursively searching the 4 surrounding pixels to the given pixel
	 * and incrementing the count variable when pixels of the same colour are found.
	 * 
	 * @param colour
	 * @param row
	 * @param col
	 * @param image array of colour of pixels
	 */
	private void recursiveSearch(int colour, int row, int col, int[][] image) {
		//search up and down
		for(int i = row-1; i < row + 2; i++) {
			if(i >= 0 && i < image.length) {
				if(image[i][col] == colour && !searched[i][col]) {
					if(i != row) {
						count++;
						searched[i][col] = true;
						
						recursiveSearch(colour, i, col, image);
					}
				}
			}
		}
		
		//search left and right
		for(int j = col-1; j < col + 2; j++) {
			if(j >= 0 && j < image[row].length) {
				if(image[row][j] == colour && !searched[row][j]) {
					if(j != col) {
						count++;
						searched[row][j] = true;
						
						recursiveSearch(colour, row, j, image);
					}
				}
			}
		}
	}

	/**
	 * Computes the total brightness of the brightest k*k square in the image.
	 * 
	 * Total brightness refers to the sum of its pixel values.
	 * 
	 * 
	 * Note: K <= 2048
	 * 
	 * @return int total brightness
	 * @param image
	 * @param k width of square
	 */
	public int brightestSquare(int[][] image, int k) {
		
		int total = 0;
		
		//previous keeps track of the brightness of the previous k*k square.
		int previous = 0;
		
		for(int i = 0; i <= image.length - k; i++) {
			//searching through row
			for(int j = 0; j < image[i].length; j++) {
				//searching through column
				
				if(j >= k) {
					int[] newCol = nextCol(i, j, k, image);
					
					//Value of the next k*1 column
					int tempCol = newCol[0];
					
					//Value of the leftmost k*1 column of the previous square, in which we are discarding
					int lastCol = newCol[1];
					
					int tempTotal = (previous - lastCol) + tempCol;
					
					previous = tempTotal;
										
					if(tempTotal > total) {
						total = tempTotal;
						
					}
				}else if(j == 0){
					
					previous = 0;
					
					//find total of first k*k square of the row
					for(int a = i; a < i+k; a++) {
						for(int b = 0; b < k; b++) {
							previous += image[a][b];
						}
					}
					
					if(previous > total) {
						total = previous;
					}
				}
				
			}
		}
		
		return total;
	}
	
	/**
	 * Private function which finds the total brightness of both the next k*1 column
	 * and the last k*1 column of the square.
	 * 
	 * @param row
	 * @param col
	 * @param k size of square
	 * @param image
	 * @return total brightness of the next column
	 */
	private int[] nextCol(int row, int col, int k, int[][] image) {
		
		int tempCol = 0;
		int lastCol = 0;
		
		//finding value of the k*1 column at row, col.
		for(int i = row; i < row+k; i++) {
			tempCol += image[i][col];
		}
		
		//finding value of the leftmost k*1 column of the prefious k*k square.
		for(int x = row; x < row+k; x++) {
			lastCol += image[x][col-k];
		}
		
		int[] result = new int[] {tempCol, lastCol};
		
		return result;
	}
	
	
	
	

	/**
	 * Computes the maximum brightness that must be encountered when drawing a path from
	 * the pixel at (ur, uc) to the pixel at (vr, vc).
	 * 
	 * The path may only move to one adjacent pixel in one time interval.
	 * 
	 * The brightness refers to the value of the brightest pixel the path covers,
	 * including the starting and ending pixels, unseen queue is to store pixel
	 * locations they need their adjacent pixels searched as they arise.
	 * 
	 * @return int maximum brightness
	 * @param image
	 * @param ur starting row
	 * @param uc starting col
	 * @param vr finishing row
	 * @param vc finishing col
	 */
	
	private int[][] brightness;
	private PriorityQueueLinked<int[]> unseen;
	public int darkestPath(int[][] image, int ur, int uc, int vr, int vc) {
		
		int[] start = new int[] {ur, uc};
		
		unseen = new PriorityQueueLinked<int[]>();
		brightness = new int[image.length][image[0].length];
		
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				brightness[i][j] = Integer.MAX_VALUE;
			}
		}
		
		brightness[ur][uc] = image[ur][uc];
		
		unseen.enqueue(start, 0);
		
		while(!unseen.isEmpty()) {
			//Get current pixel
			int[] pixel = unseen.dequeue();
			
			//Search pixel above the current pixel
			if(pixel[0] > 0) {
				int[] above = new int[] {pixel[0] - 1, pixel[1]};
				
				if(brightness[pixel[0]][pixel[1]] < brightness[above[0]][above[1]]) {
					if(brightness[pixel[0]][pixel[1]] >= image[above[0]][above[1]]) {
						brightness[above[0]][above[1]] = brightness[pixel[0]][pixel[1]];
					}else {
						brightness[above[0]][above[1]] = image[above[0]][above[1]];
					}
					
					unseen.enqueue(above, brightness[above[0]][above[1]]);
				}
				
			}
			
			//Search pixel below current pixel
			if(pixel[0] < image.length-1) {
				int[] below = new int[] {pixel[0] + 1, pixel[1]};
				
				if(brightness[pixel[0]][pixel[1]] < brightness[below[0]][below[1]]) {
					if(brightness[pixel[0]][pixel[1]] >= image[below[0]][below[1]]) {
						brightness[below[0]][below[1]] = brightness[pixel[0]][pixel[1]];
					}else {
						brightness[below[0]][below[1]] = image[below[0]][below[1]];
					}
					
					unseen.enqueue(below, brightness[below[0]][below[1]]);
				}
				
			}
			
			//Search pixel to the left of current pixel
			if(pixel[1] > 0) {			
				int[] temp = new int[] {pixel[0], pixel[1] - 1};
				
				if(brightness[pixel[0]][pixel[1]] < brightness[temp[0]][temp[1]]) {
					if(brightness[pixel[0]][pixel[1]] >= image[temp[0]][temp[1]]) {
						brightness[temp[0]][temp[1]] = brightness[pixel[0]][pixel[1]];
					}else {
						brightness[temp[0]][temp[1]] = image[temp[0]][temp[1]];
					}
					
					unseen.enqueue(temp, brightness[temp[0]][temp[1]]);
					
				}
			}
			
			//Search pixel to the right of current pixel
			if(pixel[1] < image[pixel[0]].length-1) {
				int[] temp = new int[] {pixel[0], pixel[1] + 1};
				
				if(brightness[pixel[0]][pixel[1]] < brightness[temp[0]][temp[1]]) {
					if(brightness[pixel[0]][pixel[1]] >= image[temp[0]][temp[1]]) {
						brightness[temp[0]][temp[1]] = brightness[pixel[0]][pixel[1]];
					}else {
						brightness[temp[0]][temp[1]] = image[temp[0]][temp[1]];
					}
					
					unseen.enqueue(temp, brightness[temp[0]][temp[1]]);
				}
			}
		}
		
		
		
		return brightness[vr][vc];
	}
	
	/**
	 * Nested class for prioriy queue, used in the darkestPath method.
	 * Queue which stores elements in an order based on their priority,
	 * as specified by a value entered when enqueuing an element.
	 * 
	 * @author darbyedwards
	 *
	 * @param Object to be stored in priority queue.
	 */
	@SuppressWarnings("hiding")
	private class PriorityQueueLinked<Object>{

		/**
		 * Nested class for the link item for the priority queue.
		 * 
		 * 
		 * includes fields: item, priority, next
		 * 
		 * @author darbyedwards
		 */
		private class Link<Object>{
			Object item;
			int priority;
			Link<Object> next;
			
			
			/**
			 * Link constructor
			 * 
			 * @param Object to be stored
			 * @param priority
			 * @param link to next item
			 */
			private Link(Object o, int p, Link<Object> n) {
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
		 * Constructor without parameters
		 */
		void PriorityQueue(){
			front = null;
		}
		
		
		/**
		 * Dequeue and return the first item from the queue.

		 * @return item
		 */
		private Object dequeue() {
			if(!isEmpty()) {
				Object temp = (Object) front.item;
				
				front = front.next;
				
				return temp;
			}else {
				return null;
			}
		}

		/**
		 * Add item to the priority queue in front of all items with a 
		 * key less than the int provided (key).
		 * 
		 * Note: items with the same key are sorted in chronological order.
		 * @param item
		 * @param key
		 */
		public void enqueue(Object item, int key){
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
		 * Return true if the queue is empty, otherwise return false.
		 * 
		 * @return boolean
		 */
		public boolean isEmpty() {
			return front == null;
		}

	}

	

	/**
	 * Computes the results of a list of queries on the image.
	 * 
	 * Each query is a three element array {r, l, u}, which defines a row segment.
	 * 
	 * Note: l < u
	 * 
	 * Note: r = row, l = starting col, u = ending col
	 * 
	 * A row segment refers to a set of pixels (r, c) such that r is given, l <= c and c < u.
	 * 
	 * For each query, the value of the brightest pixel in the specified row segment is computed,
	 * the results are returned in the same order as the queries given.
	 * 
	 * @return int[] array of brightest pixel results
	 * @param image
	 * @param queries
	 */
	public int[] brightestPixelsInRowSegments(int[][] image, int[][] queries) {
		
		int[] result = new int[queries.length];
		
		//Iterate for each query
		for(int i = 0; i < queries.length; i++) {
			result[i] = 0;
			
			int endCol = queries[i][2];
			int segRow = queries[i][0];
			int startCol = queries[i][1];

			//find max brightness in row segment
			for(int j = 0; j < endCol - startCol; j++) {
				if(image[segRow][startCol + j] > result[i]) {
					result[i] = image[segRow][startCol+j];
				}
			}
		}
		
		
		return result;
	}


}
