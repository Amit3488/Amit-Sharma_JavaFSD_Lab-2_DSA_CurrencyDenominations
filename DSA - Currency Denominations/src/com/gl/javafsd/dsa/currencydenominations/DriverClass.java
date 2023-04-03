package com.gl.javafsd.dsa.currencydenominations;

import java.util.List;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {

		System.out.println("Enter the size of currency denominations ");
		try (Scanner sc = new Scanner(System.in)) {
			int size = sc.nextInt();

			int[] denominations = new int[size];
			System.out.println("Enter the currency denomination value in decreasing order");
			for (int i = 0; i < size; i++) {
				denominations[i] = sc.nextInt();
			}

			System.out.println("Enter the amount you want to pay");
			int amount = sc.nextInt();

			DenominationsCalculator calculator = new DenominationsCalculator(denominations, amount);

			Result result = calculator.calculate();

			boolean exactPaymentAchieved = result.isExactPaymentAchievedOrNot();
			if (exactPaymentAchieved) {

				System.out.println("Your payment approach in order to give min no of notes will be");

				List<DenominationInstancesPair> list = result.getDenominationInstancesList();

				for (DenominationInstancesPair pair : list) {

					int denominationValue = pair.getDenominationValue();
					int noOfInstances = pair.getNoOfInstances();

					System.out.println(denominationValue + ":" + noOfInstances);
				}
			} else {
				System.out.println("Exact payment cannot be achieved...");
			}
		}
	}
}