package sjordhani.hw1;

import algs.hw1.arraysearch.SpiralArraySearch;

/**
 * Copy this class into your package, which must have USERID has its root.
 */
public class SpiralArraySolution extends SpiralArraySearch {

	/** Construct problem solution for given array. Do not modify this method. */
	public SpiralArraySolution(int[][] a) {
		super(a);
	}
	
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	/**
	 * For this homework assignment, you need to complete the implementation of this
	 * method.
	 */
	@Override 	
	public int[] locate(int target) {
int n = this.length();
		
	
		if (min == Integer.MAX_VALUE) {
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					int rc = inspect(r,c);
					if (rc < min) {
						min = rc;
					}
					if (rc > max) {
						max = rc;
					}
				}
			}
		}
		
		if (target < min) { return null; }
		if (target > max) { return null; }
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (inspect(r,c) == target) {
					return new int[] { r, c };
				}
			}
		}
		
		return null;  // not found
	}
	/*	
	* Here is my original code, it had the right idea however, I could not get it to fully run because of my binarySearch helpers 

	
	public int[] locate(int target) {
		int n = length();
		
		
		int lo = n/2;
		int high = n - 1;
		
		while (lo <= high) {
			int mid = (lo+high)/2;
			
			int val = inspect(mid, mid);
			if (val == target) {
				return new int[] { mid, mid };
			} else if (val < target) {
				lo = mid+1;
			} else {
				// val > target
				high = mid - 1;
			}
		}

		// HERE: Haven't found target on diagonal. BUT you know the band
		// lo is the row (and column) of band in which value COULD exist
		int v = n - 1 - lo;
		int tLeftCorner = inspect(v, v);
		int tRightCorner = inspect(v, lo);
		int bLeftCorner = inspect(lo , v);
		/*int bRightCorner = inspect(n, n); 
		
		if(target == tLeftCorner) {
			return new int[] { v, v };
		}
		else if(target < tLeftCorner) {
			if(target > tRightCorner) {
				return binaryRowDescendingSearch(v, target);
			}
			else {
				return binaryColumnDescendingSearch(lo, target); 
			}
		}
		else {
			// target > inspect(v,v)   
			if(target > bLeftCorner) {
				return binaryRowAscendingSearch(v + n, target);
			}
			else {
				return binaryColumnAscendingSearch(v, target);
			}
			
		}
		//return null;
		}

	

	public int[] binaryRowAscendingSearch(int row, int target) {
		int low = 0;
		int high = row;

		while (low <= high) {
			int mid = (low + high) / 2;

			int rc = inspect(row, mid);
			if (rc < target) {
				low = mid + 1;
			} else if (rc > target) {
				high = mid - 1;
			} else {
				return new int[] { row, mid };
			}
		}
		return null;
	}
	
	public int[] binaryRowDescendingSearch(int row, int target) {
		int low = 0;
		int high = row;

		while (low <= high) {
			int mid = (low + high) / 2;

			int rc = inspect(row, mid);
			if (rc < target) {
				low = mid + 1;
			} else if (rc > target) {
				high = mid - 1;
			} else {
				return new int[] { row, mid };
			}
		}
		return null;
	}

	public int[] binaryColumnAscendingSearch(int col, int target) {
		int low = 0;
		int high = col;

		while (low <= high) {
			int mid = (low + high) / 2;

			int rc = inspect(mid, col);
			if (rc < target) {
				high = mid - 1;
			} else if (rc > target) {
				low = mid + 1;
			} else {
				return new int[] { mid, col };
			}
		}
		return null;
	}
	
	public int[] binaryColumnDescendingSearch(int col, int target) {
		int low = 0;
		int high = col;

		while (low <= high) {
			int mid = (low + high) / 2;

			int rc = inspect(mid, col);
			if (rc < target) {
				high = mid - 1;
			} else if (rc > target) {
				low = mid + 1;
			} else {
				return new int[] { mid, col };
			}
		}
		return null;
	}
*/
	/** Be sure that you call your class constructor. Do not modify this method. */
	public static void main(String args[]) {
		int[][] ar = SpiralArraySearch.create(13);
		new SpiralArraySolution(ar).trial();
	}
}
