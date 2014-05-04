package Solved_026_050;

/**
 * Distinct powers
 * Problem 29
 * 
 * Consider all integer combinations of a^b for 2 <= a <= 5 and 2 <= b <= 5:
 * 
 * 2^2=4, 2^3=8, 2^4=16, 2^5=32
 * 3^2=9, 3^3=27, 3^4=81, 3^5=243
 * 4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * 5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * 
 * If they are then placed in numerical order, with any repeats removed, we get
 * the following sequence of 15 distinct terms:
 * 
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 * 
 * How many distinct terms are in the sequence generated by a^b for 2 <= a <= 100
 * and 2 <= b <= 100?
 */
public class PE029_Distinct_powers {
	int size = 100;
	int[][] counters = new int[size + 1][size + 1];

	public static void main(String[] args) {
		long start = System.nanoTime();

		PE029_Distinct_powers dp = new PE029_Distinct_powers();

		long end = System.nanoTime();
		long runtime = end - start;
		System.out.println(dp.getAnswer());
		System.out.println("Runtime: " + runtime / 1000000 + "ms (" + runtime
				+ "ns)");
	}

	public PE029_Distinct_powers() {
	}

	private boolean lowerDivisorExists(int j, int f) {
		for (int c = 1; c < f; c++) {
			if (j % c == 0 && j / c <= size) {
				return true;
			}
		}
		
		return false;
	}

	public int getAnswer() {
		for (int i = 2; i <= size; i++) {
			for (int j = 2; j <= size; j++) {
				counters[i][j] = 1;
			}
		}
		
		for (int i = 2; i <= size; i++) {
			int power = i * i;
			int limit = size;
			for (int f = 2; power <= size; f++) {
				for (int j = 2; j <= limit; j++) {
					if (j % f == 0) {
						int d = j / f;
						if (d <= size && lowerDivisorExists(j, f)) {
							counters[power][d] = 0;
						}
					}
				}
				limit = size * f;
				power *= i;
			}
		}
		
		int sum = 0;
		
		for (int i = 2; i <= size; i++) {
			for (int j = 2; j <= size; j++) {
				sum += counters[i][j];
			}
		}
		
		return sum;
	}
}
