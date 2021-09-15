
public class ProjectTest {
	private static final int[][] pic = new int[][] { 
	    { 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
	    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
	    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
	    { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
	    { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
	    { 2, 2, 1, 1, 1, 0, 5, 5, 5, 0, 0 }, 
	    { 0, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1 }
	  };
	  
	  private static MyProject m = new MyProject();
	  
	  public static void main(String[] args) {
		  
		  System.out.println("Flood fill count: " + m.floodFillCount(pic, 6, 7));
		  
		  System.out.println("Brightness of brightest square: " + m.brightestSquare(pic, 3));
		  
		  System.out.println("Darkest Path Brightness: " + m.darkestPath(pic, 0, 0, 5, 8));
		  
		  
		  int[][] queries = new int[][] {{0, 0, 5}, {6, 7, 9}};
		  
		  System.out.println(m.brightestPixelsInRowSegments(pic, queries)[0]);
		  System.out.println(m.brightestPixelsInRowSegments(pic, queries)[1]);
		 
	  }
}



/*	public int[][] brightness;
	private int[][] seenMatrix;
	private Queue<int[]> unseen;
	private Queue<int[]> seen;
 * 
 * 
 * 
 * 		seenMatrix = new int[image.length][image[0].length];
		unseen = new LinkedList<int[]>();
		seen = new LinkedList<int[]>();
		
		int[] start = new int[] {ur, uc};
		
		unseen.add(start);
		
		brightness = new int[image.length][image[0].length];
		
		brightness[ur][uc] = image[ur][uc];
		
		while(seen.size() != image.length*image[0].length) {
			
			int[] tempPixel = unseen.remove();
			
			seen.add(tempPixel);
			
			findMaxBrightness(tempPixel, image);
		}
		
		return brightness[vr][vc];
		
		
		
		
			private void findMaxBrightness(int[] pixel, int[][] image) {
		int tempBrightness = Integer.MAX_VALUE;
		
		//search left and right
		for(int i = pixel[1] - 1; i < pixel[1]+2; i++) {
			
			int[] newPixel = new int[] {pixel[0], i};
			
			if(i != pixel[1] && i >= 0 && i < image[pixel[0]].length) {
				if(seenMatrix[newPixel[0]][newPixel[1]] != 1) {
					tempBrightness = image[pixel[0]][i];
					
					if(tempBrightness > brightness[newPixel[0]][newPixel[1]]) {
						brightness[newPixel[0]][newPixel[1]] = tempBrightness;
					}
					
					seenMatrix[newPixel[0]][newPixel[1]] = 1;
					unseen.add(newPixel);
				}
			}
		}
		
		//search up and down
		for(int j = pixel[0] - 1; j < pixel[0]+2; j++) {
			
			int[] newPixel = new int[] {j, pixel[1]};
			
			if(j != pixel[0] && j >= 0 && j < image.length) {
				if(seenMatrix[newPixel[0]][newPixel[1]] != 1) {
					tempBrightness = image[j][pixel[1]];
					
					if(tempBrightness > brightness[newPixel[0]][newPixel[1]]) {
						brightness[newPixel[0]][newPixel[1]] = tempBrightness;
					}
					
					seenMatrix[newPixel[0]][newPixel[1]] = 1;
					unseen.add(newPixel);
				}
			}
		
		
		
		
		
		*/

