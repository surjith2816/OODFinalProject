package com.ecommerce.demo.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public List<String> readFile(String filePath) {
		List<String> csvLines = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				csvLines.add(line);
			}
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return csvLines;

	}

	public void writeFile(String output) {

		try (FileWriter writer = new FileWriter("src/main/java/edu/neu/csye6200/writingfile.csv");) {
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

	}

}