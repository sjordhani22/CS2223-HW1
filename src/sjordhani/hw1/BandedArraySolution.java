package sjordhani.hw1;

import algs.hw1.arraysearch.BandedArraySearch;

/**
 * Copy this class into your package, which must have USERID has its root.
 */
public class BandedArraySolution extends BandedArraySearch {

	/** Construct problem solution for given array. Do not modify this method. */
	public BandedArraySolution(int[][] a) {
		super(a);
	}

	/**
	 * For this homework assignment, you need to complete the implementation of this
	 * method.
	 */
	@Override
	public int[] locate(int target) {
		int low = 0;
		int high = length() - 1;

		while (high - low != 1) { // This happens when we figure out the general location of the "band" where target is 
			int mid = (low + high) / 2;

			int rc = inspect(mid, mid); // We are doing a binary search on the diagonal positions from top left to bottom right 
			if (rc < target) {
				low = mid;
			} else if (rc > target) {
				high = mid;
			} else {
				return new int[] { mid, mid };
			}
		}
		/*
		 * Here we will observe if the target is in the row or column of the diagonal that is greater than target or if the target 
		 * if in the band that comes before 
		 */
		int rightIns= inspect(high, high); 
		
		if (rightIns < target) {
			return binaryColumnSearch(high, target);
		}
		else if (rightIns > target) {
			int leftIns = inspect(high, 0);
			if (leftIns > target) {
				return binaryColumnSearch(low, target);
			} else if (leftIns < target) {
				return binaryRowSearch(high, target);
			} else {  
				return new int[] { high, 0 };
			}
		} else {
			return new int[] { high, high };
		}
	}

	public int[] binaryRowSearch(int row, int target) {
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

	public int[] binaryColumnSearch(int col, int target) {
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

	/*
	 * int low = 0; int high = length()-1; int mid = -1; int val = -1;
	 * 
	 * 
	 * while (val < target) { mid = (low+high)/2;
	 * 
	 * val = inspect(mid, mid); if (val == target) { return new int[] { mid, mid}; }
	 * else if (val < target){ low = low + 1; high = high + 1;
	 * 
	 * } else if (val > target) { if(binaryRowSearch(mid, target) == null) { low =
	 * low - 1; high = high -1; binaryColumnSearch() } } return binarySearch(mid,
	 * target); }
	 * 
	 * 
	 * 
	 * boolean binaryColumnSearch(int[] collection, int target) { int low = 0; int
	 * high = collection.length-1;
	 * 
	 * while (low <= high) { int mid = (low+high)/2;
	 * 
	 * int rc = collection[mid] - target; if (rc < 0) { low = mid+1; } else if (rc >
	 * 0) { high = mid-1; } else { return true; } } return false; }
	 * 
	 * 
	 * 
	 * boolean binaryRowSearch(int[] collection, int target) { int low = 0; int high
	 * = collection.length-1;
	 * 
	 * while (low <= high) { int mid = (low+high)/2;
	 * 
	 * int rc = collection[mid] - target; if (rc < 0) { low = mid+1; } else if (rc >
	 * 0) { high = mid-1; } else { return true; } } return false; }
	 * 
	 */
	/** Be sure that you call your class constructor. Do not modify this method. */
	public static void main(String args[]) {
		int[][] ar = BandedArraySearch.create(13);
		new BandedArraySolution(ar).trial();
	}
}
