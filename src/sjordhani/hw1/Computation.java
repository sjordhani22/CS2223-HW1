package sjordhani.hw1;

import edu.princeton.cs.algs4.*;

/**
 * Copy this class into your USERID.hw1 package 
 */
public class Computation {

	/**
	 * Return a stack of prime factors, with larger factors towards the top of the stack,
	 * and smaller factors at the bottom.
	 * 
	 * In fact, the resulting stack will be the factors of n in reverse order.
	 * 
	 * @param n    integer to be factored
	 * @return     stack of factors, where the factors appear in reverse sorted order (largest on top).
	 */
	static Stack<Long> factorize(long n) {
		long i = 2; // We want to start at 2 because we are avoiding using 0, and 1 for factors 
		
		Stack<Long> fStack = new Stack<Long>(); // Initialize a stack where the factors will be placed 
		
		while(i <= n) {
		if((n % i) == 0) { // Is it a factor? 
				fStack.push(i); // If it is, push onto stack 
				n = n/i; // Update n so that we can determine what the prime factorization of the n value 
			}
			else {
				i++; // If i is not a factor we want to increment it to check the next number in line 
			}
		}
		System.out.println(fStack); // This is additional but it lets us see what the stack will come out to be 
		return fStack;
	}
	
	/**
	 * Given a stack of numbers, representing the prime factors of a number n, return
	 * true if the number n is a perfect square.
	 * 
	 * This method may change the contents of the stack
	 * 
	 * @param factors   a Stack of factors (in reverse order) as produced by factorize.
	 * @return          True if the factors represents a number that is a square; false otherwise.
	 */
	static boolean isSquare(Stack<Long> factors) {
		long n = 1; 
/* We use 1 because it wont affect the multiplication of all the factors 
 Ex: If we set n to 0 then we would always return 0 for the n value no matter how many times we go through the while loop */
		
		while(factors.size() > 0) { // We want to get all of the prime factors out of the stack until its empty 
			n = n * factors.pop(); // Multiplying all the factors together will give us the number that was being prime factorized
			
		}
		int sqrt = (int)Math.sqrt(n); 
		/* This is going to give us the int sqrt value which is important for non-square numbers who have a square root of a
		 * decimal number which in this case will round it to be an integer and return false in the next if statement */  
		if(sqrt * sqrt == n) {
			return true; 
		}
		return false;  
	}
	
	public static void main(String[] args) {
		// Read token. push if operator.
		StdOut.println("Enter a positive integer:");
		String s = StdIn.readString();

		try {
			long val = Long.valueOf(s);
			
			Stack<Long> factors = factorize(val);
			if (isSquare(factors)) {
				System.out.println(val + " is a perfect square.");
			} else {
				System.out.println(val + " is NOT a perfect square.");
			}
			
		} catch (Exception e) {
			System.out.println(s + " is not an integer.");
		}
	}
}
