package ainterview.question;

 // The Class BigOExamples.
 
public class BigOExamples {

	/* Constant. O(1)*/
	public int constant(int n) {
		if (n > 1) {
			return n;
		} else {
			return 0;
		}
	}

	/*Linear. O(n)*/
	public int linear(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			sum += j;

		}
		return sum;
	}
   
    /* Quadratic. O(n^2)*/
	public int quadratic(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				sum += j * k;
			}
		}
		return sum;
	}

   /* Cubic. O(n^3)*/
	public int cubic(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				for (int l = 0; l < n; l++) {
					sum += j * k / (l + 1);
				}
			}
		}
		return sum;
	}

	/**
	 * Logarithmic. O(log n). Binary Search. 
	 * @param data the to search
	 * @param key the key
	 * @return the int
	 */
	public int logarithmic(Integer[] data, int key) {
		int startIndex = 0;
		int endIndex = data.length - 1;

		while (startIndex < endIndex) {
			int midIndex = (endIndex - startIndex / 2) + startIndex;
			int midValue = data[midIndex];

			if (key > midValue) {
				startIndex = midIndex++;
			} else if (key < midValue) {
				endIndex = midIndex - 1;
			} else {
				return midIndex;
			}
		}
		return -1;
	}

	/**
	 * Linear Logarithmic. O(n log n). Quick Sort.
	 * 
	 * @param data the to search
	 * @param key the key
	 * @return the int
	 */
	public Integer linearLogarithmic(Integer[] data) {

		QuickSort<Integer> sorter = new QuickSort<Integer>();
		sorter.sort(data);

		return data[0];
	}

}
