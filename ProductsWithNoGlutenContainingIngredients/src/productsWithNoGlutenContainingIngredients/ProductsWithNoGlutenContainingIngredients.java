/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package productsWithNoGlutenContainingIngredients;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProductsWithNoGlutenContainingIngredients {
	/**
	 * Read the text file and parse it into parts
	 * @param fileName The file name to parse
	 */
	public static void process(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			while (line != null) {
				String sku = line.substring(0,line.indexOf(" "));
				System.out.println(sku);
			}
			br.close();
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			try {br.close();} catch (Exception ex1) {}
		}
	}
}
