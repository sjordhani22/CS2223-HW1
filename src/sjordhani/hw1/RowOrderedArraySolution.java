package sjordhani.hw1;

import algs.hw1.arraysearch.RowOrderedArraySearch;

/**
 * Copy this class into your package, which must have USERID has its root.
 */
public class RowOrderedArraySolution extends RowOrderedArraySearch {

	/** Construct problem solution for given array. Do not modify this method. */
	public RowOrderedArraySolution(int[][] a) {
		super(a);
	}
	
	/** 
	 * For this homework assignment, you need to complete the implementation of this
	 * method.
	 */
	@Override
	public int[] locate(int target) {    
			int low = 0;
			int high = length()-1;

			while (low <= high) {  
				int mid = (low+high)/2;
	  
				int rc = inspect(mid, 0);  // We will be inspecting the first item in each row and comparing them 
				if (rc == target) {
					return new int[] { mid, 0};
				} else if (rc > target) {
					high = mid-1; 
				} else {
					low = mid+1;  			}
			}
			return binarySearch(high, target); // We found the row, run binary search on the appropriate row 
		}
		
		public int[] binarySearch(int row, int target) {
		int low = 1;
		int high = length()-1;
  
		while (low <= high) {
			int mid = (low+high)/2;

			int rc = inspect(row, mid) - target; // Using the "minus target" method is similar to simply comparing to target 
			if (rc < 0) { // The target is on the right side 
				low = mid+1; 
			} else if (rc > 0) { // The target is on the left side 
				high = mid-1; 
			} else {
				return new int[] { row, mid };
			}
		}
		return null;
		}
		
	
	/** Be sure that you call your class constructor. Do not modify this method. */ 
	public static void main (String args[]) {
		int[][] ar = RowOrderedArraySearch.create(13);
		new RowOrderedArraySolution(ar).trial();
	}
}
