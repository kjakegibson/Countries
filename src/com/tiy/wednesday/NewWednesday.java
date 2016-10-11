package com.tiy.wednesday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.tiy.wednesday.utils.CountriesAppMethods;
import com.tiy.wednesday.utils.Validator;

public class NewWednesday {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int indexToDelete = 0;
		boolean correctInput = true;
		boolean contApp = true;
		String menuInput = null;
		String causeToPrint = null;
		String countryToDelete = null;
		ArrayList<String> fromOurTextFile = new ArrayList<>();

		Path ourNewestPath = Paths
				.get("\\Users\\admin\\NewWorkspace\\Week 3 Day 3\\src\\com\\tiy\\wednesday\\MyCountries.txt");
		File aNewFile = ourNewestPath.toFile();

		do {
			do {
				CountriesAppMethods.helloAndWelcome();
				menuInput = sc.nextLine();
				System.out.println(menuInput);

				correctInput = Validator.userInputForMenu(menuInput, correctInput);

			} while (correctInput);

			switch (menuInput) {
			case "1":// read from the file
				fromOurTextFile = CountriesAppMethods.ourReader(fromOurTextFile, aNewFile);

				for (int i = 0; i < fromOurTextFile.size(); i++) {
					System.out.println(fromOurTextFile.get(i));

				}
				fromOurTextFile.clear();
				break;

			case "2":// add to the file
				System.out.println("Which country would you like to add?");
				causeToPrint = sc.nextLine();
				CountriesAppMethods.AppendToTextFile(causeToPrint, aNewFile);
				break;

			case "3":// delete from the file
				System.out.println("Which country would you like to remove?");
				fromOurTextFile = CountriesAppMethods.ourReader(fromOurTextFile, aNewFile);

				do {
					correctInput = true;
					for (int i = 0; i < fromOurTextFile.size(); i++) {
						System.out.println(i + "." + fromOurTextFile.get(i));

					}
					countryToDelete = sc.nextLine();

					correctInput = Validator.testingDeleteInput(correctInput, countryToDelete, fromOurTextFile);

				} while (correctInput);

				CountriesAppMethods.overWriteFile(causeToPrint, aNewFile, fromOurTextFile);

				System.out.println();
				fromOurTextFile.clear();

			}
		} while (contApp);

	} // main

}// Class
