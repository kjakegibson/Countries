package com.tiy.wednesday.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Validator {

	public static boolean userInputForMenu(String menuInput, boolean correctInput) {
		switch (menuInput) {
		case "1":
		case "2":
		case "3":
		case "4":
			correctInput = false;
			break;
		default:
			System.out.println("I'm sorry, that is not a valid option\n");
		}
		return correctInput;
	}

	public static boolean testingDeleteInput(boolean correctInput, String countryToDelete,
			ArrayList<String> fromOurTextFile) {
		int indexToDelete;
		indexToDelete = Integer.parseInt(countryToDelete);

		if (indexToDelete >= 0 || indexToDelete < fromOurTextFile.size()) {
			fromOurTextFile.remove(indexToDelete);
			correctInput = false;
		}
		return correctInput;
	}

	public static void helloAndWelcome() {
		System.out.println("Hello and welcome to the Countries List App");
		System.out.println("Would you like to view my list of countries? Press 1");
		System.out.println("Would you like to add to the list of countries? Press 2");
		System.out.println("Or Remove from the list? Press 3");
		System.out.println("Would you like to leave the App? Press 4");
	}// helloAndWelcome

	public static void overWriteFile(String causeToPrint, File aNewFile, ArrayList<String> fromOurTextFile) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile)))) {

			for (int i = 0; i < fromOurTextFile.size(); i++) {
				causeToPrint = fromOurTextFile.get(i);
				out.println(causeToPrint);
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// overWriteFile

	public static void AppendToTextFile(String causeToPrint, File aNewFile) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile, true)))) {
			out.println(causeToPrint);

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// appendToTextFile

	public static ArrayList<String> ourReader(ArrayList<String> fromOurTextFile, File aNewFile) {
		try (BufferedReader in = new BufferedReader(new FileReader(aNewFile))) {
			String readingStuff;

			while ((readingStuff = in.readLine()) != null) {

				fromOurTextFile.add(readingStuff);

			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fromOurTextFile;
	}// ourReader

}
