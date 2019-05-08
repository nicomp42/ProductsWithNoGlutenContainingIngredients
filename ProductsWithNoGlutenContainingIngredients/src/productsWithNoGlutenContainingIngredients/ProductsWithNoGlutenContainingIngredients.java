/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package productsWithNoGlutenContainingIngredients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductsWithNoGlutenContainingIngredients {
	private String sku;
	private String description;
	private String units;
	private String size;
	
	public ProductsWithNoGlutenContainingIngredients() {
		sku = "";
		description = "";
		units = "";
		size = "";
	}
	public ProductsWithNoGlutenContainingIngredients(String sku, String description, String size, String units) {
		this.sku = sku;
		this.description = description;
		this.size = size;
		this.units = units;
	}	
	
	/**
	 * Read the text file and parse it into parts
	 * @param fileName The file name to parse
	 */
	public static void process(String fileName, 
			                   ArrayList<ProductsWithNoGlutenContainingIngredients> products) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			while (line != null) {
				line = line.trim();
				String sku, description, units, size;
				int space1, space2;
				sku = null;
				description = null;
				units = null;
				size = "";
				space1 = 0; space2 = 0;
//				System.out.println(line);
				try {
					space1 = line.indexOf(" ");
					sku = line.substring(0,space1);
				} catch (Exception ex) {sku = null;}
				if (sku != null) {
					if (line.toUpperCase().endsWith("OZ")) {
						units = "OZ";
						line = line.substring(0,line.length() - 2).trim();
						space2 = line.lastIndexOf(" ");
						size = line.substring(space2);
						description = line.substring(space1, space2).trim();
					}
					if (isNumeric(sku) && description != null && size != null && units != null) {
						System.out.println(sku);
						products.add(new ProductsWithNoGlutenContainingIngredients(sku,description, size, units));
					}
				}
				line = br.readLine();
			}
			br.close();
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			try {br.close();} catch (Exception ex1) {}
		}
	}
	/**
	 * Check to see if a string contains a numeric value
	 * @param str The string to check
	 * @return True if str can be converted to a number
	 * Lifted from https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	 */
	private static boolean isNumeric(String str) { 
		try {  
		    Double.parseDouble(str);  
		    return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}
}
