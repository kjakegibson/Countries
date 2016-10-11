package com.tiy.wednesday.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CountriesAppMethods {

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
