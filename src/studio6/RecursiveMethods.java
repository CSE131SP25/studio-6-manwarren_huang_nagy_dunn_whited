package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
			double sum = 0.0;
			for (int power = 1; power <= n; ++power) {
				sum = sum + Math.pow(0.5, power);
			}
			return sum;
		
	}

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		
		// FIXME complete the recursive drawing
		int N = 1;
		double currentRadius = radius;
		while (currentRadius >= radiusMinimumDrawingThreshold) {
			for (int i = 1; i <= Math.pow(4,  N); i++) {
				double X = xCenter;
				double Y = yCenter;
				for (int j = 0; j < N; j++) {
					if (i % Math.pow(4,  N - 1) == 0) {
						Y = Y + currentRadius;
					} else if (i % Math.pow(4,  N - 1) == 1) {
						X = X + currentRadius;
					} else if (i % Math.pow(4,  N - 1) == 2) {
						Y = Y - currentRadius;
					} else if (i % Math.pow(4,  N - 1) == 3) {
						X = X - currentRadius;
					}
				}
				StdDraw.ellipse(X, Y, currentRadius, currentRadius);
			}
			N++;
			currentRadius = currentRadius * 1.0 / 3.0;
		}
		
	}
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			// FIXME create a helper method that can recursively reverse the given array
			int[] reversed = new int[array.length];
			if (array.length > 0) {
				int lastIndex = array.length - 1;
				for (int index = 0; index <= array.length / 2; ++index) {
					int mirrorIndex = lastIndex - index;
					// note:
					// since we read from array and write to reversed
					// we do not need to use a temp variable
					reversed[index] = array[mirrorIndex];
					reversed[mirrorIndex] = array[index];
				}
			}
			return reversed;
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
			while (q != 0) {
				int temp = q;
				q = p % q;
				p = temp;
			}
			return p;
		
	}


}
