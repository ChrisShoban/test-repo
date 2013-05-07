package com.rodcut.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingModel;

public class RodCuttingTest {

	private static ArrayList<Rod> rods;
	private static int totalLength;
	private static Scanner scanner;

	public static void main(String[] args) throws InterruptedException {
		getInput();
		RodCuttingModel model = new RodCuttingModel(totalLength, rods);
		printWithTime("Greedy Algorithm Maximum Revenue : ", model.getGreedyAlgorithmMaximumRevenue());
		printWithTime("Dynamic Programming Algorithm Maximum Revenue : ", model.getDynamicAlgorithmMaximumRevenue());
		printWithTime("Branch And Bound Algorithm Maximum Revenue : ", model.getBranchAndBoundAlgorithmMaximumRevenue());

	}

	private static void getInput() {
		rods = new ArrayList<Rod>();
		int index = 0;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter total length capacity [int] : ");
			totalLength = scanner.nextInt();
			
			System.out.println("Enter number of rods for price list [int] : ");
			int numberOfRods = scanner.nextInt();
			
			for(int i = 0; i < numberOfRods; i++) {
				System.out.println("Add a new rod (Length[int], Price[double]) : ");
				String rodDetail = scanner.next();
				String[] rodDetailArr = rodDetail.split(",");
				int length = Integer.parseInt(rodDetailArr[0].trim());
				double price = Double.parseDouble(rodDetailArr[1].trim());
				rods.add(new Rod(index++, length, price));
			}
		}
		catch (InputMismatchException e) {
			System.err.println("YOUR INPUT IS NOT WELL FORMATTED. PLEASE CHECK INSTRUCTIONS.");
		}
		catch (NumberFormatException e) {
			System.err.println("YOUR INPUT IS NOT WELL FORMATTED. PLEASE CHECK INSTRUCTIONS.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printWithTime(String text, double revenue) {
		// long start = Calendar.getInstance().getTimeInMillis();
		// System.out.println(start);
		System.out.println(text + revenue);
		// long end = Calendar.getInstance().getTimeInMillis();
		// System.out.println(end);
		// System.out.println("TIME TAKEN : " + (end - start));
	}
}
