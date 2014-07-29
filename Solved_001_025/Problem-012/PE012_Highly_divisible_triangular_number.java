package Solved_001_025;

/**
 * Highly divisible triangular number
 * Problem 12
 * 
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
 * ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ... Let us list the
 * factors of the first seven triangle numbers: 1: 1 3: 1,3 6: 1,2,3,6 10:
 * 1,2,5,10 15: 1,3,5,15 21: 1,3,7,21 28: 1,2,4,7,14,28 We can see that 28 is
 * the first triangle number to have over five divisors. What is the value of
 * the first triangle number to have over five hundred divisors?
 */
public class PE012_Highly_divisible_triangular_number {
	private static int result;
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int counter = 0;
		
		for (int i = 1; counter <= 500; i++) {
			if (i % 2 == 0) {
				counter = count(i / 2) * count(i + 1);
			} else {
				counter = count(i) * count((i + 1) / 2);
			}
			
			if (counter > 500) {
				result = i;
			}
		}
		
		long end = System.nanoTime();
		long runtime = end - start;
		System.out.println(result * (result + 1) / 2);
		System.out.println("Runtime: " + runtime / 1000000 + "ms (" + runtime
				+ "ns)");
	}

	private static int count(int n) {
		int result = 0;
		
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				result += 2;
				
				if (n / i == i) {
					result--;
				}
			}
		}
		
		return result;
	}
}
