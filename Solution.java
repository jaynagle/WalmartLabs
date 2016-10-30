package walmart;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static final BigInteger MODVAL = BigInteger.valueOf(1000000007);

	public static void main(String[] args) {
		// uncomment the one that needs to be tested.

		selfies();
		// progressions();
		// mountains();
		// minMax();

	}

	private static void selfies() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.close();

		System.out.println(Math.abs((int) (Math.pow(2, n) - 1) - x));
	}

	// Unimplemented
	private static int progressions() {
		Scanner sc = new Scanner(System.in);
		List<Integer> sequence = new ArrayList<>();

		int n = sc.nextInt();
		while (sc.hasNext()) {
			sequence.add(sc.nextInt());
		}
		sc.close();

		return 0;
	}

	private static void mountains() {
		Scanner sc = new Scanner(System.in);
		List<Integer> numOfSticks = new ArrayList<>();
		Map<Integer, BigInteger> lookupMap = new HashMap<>();

		int trips = sc.nextInt();
		for (int i = 1; i <= trips; i++) {
			numOfSticks.add(sc.nextInt());
		}
		sc.close();

		for (Integer sticks : numOfSticks) {
			int height = 0;

			BigInteger totalMountains = BigInteger.ZERO;
			for (int i = 2; i <= sticks; i = i + 2) {
				if (!lookupMap.containsKey(i)) {
					lookupMap.put(i, modValue(buildMountains(height, i)));
				}
				totalMountains = totalMountains.add(lookupMap.get(i));
			}
			System.out.println(modValue(totalMountains));
		}
	}

	private static BigInteger buildMountains(int height, int sticksLeft) {
		if (sticksLeft == 0) {
			return BigInteger.ONE;
		}

		if (height == 0) {
			return buildMountains(height + 1, sticksLeft - 1);
		} else if (height == sticksLeft) {
			return buildMountains(height - 1, sticksLeft - 1);
		}
		return modValue(buildMountains(height + 1, sticksLeft - 1))
				.add(modValue(buildMountains(height - 1, sticksLeft - 1)));
	}

	private static BigInteger modValue(BigInteger value) {
		return value.mod(MODVAL);
	}

	private static void minMax() {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();

		long result = 0;
		for (long i = a; i <= b; i++) {
			String digits = String.valueOf(i);
			for (int j = 1; j < digits.length() - 1; j++) {
				int digit = (int) (digits.charAt(j) - '0');
				int left = (int) (digits.charAt(j - 1) - '0');
				int right = (int) (digits.charAt(j + 1) - '0');
				if ((digit < left && digit < right) || (digit > left && digit > right)) {
					result += 1;
				}
			}
		}
		System.out.println(result);
	}

	// Incomplete
	private static void delivery() {
		Map<Integer, List<Integer>> foodPickupMap = new HashMap<>();
		Map<Integer, Integer> orderMap = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		String[] line = sc.next().split(" ");

		int numberOfNodes = Integer.parseInt(line[0]);
		int numberOfFoods = Integer.parseInt(line[1]);
		int numberOfReq = Integer.parseInt(line[2]);

		for (int i = 1; i <= numberOfFoods; i++) {
			line = sc.next().split(" ");
			List<Integer> foodPickupList = new ArrayList<>();
			for (int j = 1; j < line.length; j++) {
				foodPickupList.add(Integer.parseInt(line[j]));
			}
			foodPickupMap.put(i, foodPickupList);
		}

		for (int i = 1; i <= numberOfReq; i++) {
			line = sc.next().split(" ");
			orderMap.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}

		makeTree(numberOfNodes);
	}

	private static void makeTree(int nodes) {

	}
}

class Tree {
	Node root;

	public Tree(Node node) {
		this.root = node;
	}
}

class Node {
	int data;
	Node left, right = null;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}
