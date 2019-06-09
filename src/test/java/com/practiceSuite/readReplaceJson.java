package com.practiceSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.internal.matchers.Each;

public class readReplaceJson {

	public static void main(String args[]) throws IOException {
		HashMap<String, String> dataSet = new HashMap<String, String>();

		dataSet.put("code", "aaa");
		dataSet.put("email", "aa@a.com");
		dataSet.put("city", "Noida");
		dataSet.put("state", "uttarPradesh");
		dataSet.put("province", "province");
		dataSet.put("country", "india");
		dataSet.put("name", "Saurabh Singh");
		dataSet.put("province", "NorthIndia");

		// System.out.println(dataSet);

		File file = new File("C:\\Workspace\\com.practiceSuite\\JsonBody.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;

		while ((st = br.readLine()) != null) {

			if (st.contains(":")) {
				String[] eachLine = st.split(":");
				String toReplace = null;
				if (eachLine[1].trim().startsWith("\"$")) {
					// if (eachLine[1].trim().contains("$")) {
					if (eachLine[1].trim().endsWith(",")) {
						toReplace = eachLine[1].substring(3, eachLine[1].trim().length() - 1);

					} else {
						toReplace = eachLine[1].substring(3, eachLine[1].trim().length());
					}
					String oldChar = "$" + toReplace;
					String newChar = dataSet.get(toReplace);
					st = st.replace(oldChar, newChar);

				}
			}

			System.out.println(st);

		}

	}
}
