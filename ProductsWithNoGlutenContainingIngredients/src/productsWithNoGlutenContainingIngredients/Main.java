/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package productsWithNoGlutenContainingIngredients;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<ProductsWithNoGlutenContainingIngredients> products = new ArrayList<>();
		ProductsWithNoGlutenContainingIngredients.process("resources/productsWithNoGlutenContainingIngredients.txt",
														  products);
		System.out.println(products.size() + " items added");
	}
}
