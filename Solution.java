package walmart;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = -1, x = -1;
		while (sc.hasNext()) {
			if (n == -1)
				n = sc.nextInt();
			else
				x = sc.nextInt();
		}
		sc.close();
		System.out.println(selfies(n, x));

	}

	private static int selfies(int n, int x) {
		int numOfCombinations = 1;
		for (int i = 1; i <= n; i++) {
			numOfCombinations *= i;
		}
		return Math.abs(numOfCombinations + 1 - x);
	}

}
