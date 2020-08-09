import java.util.*;
import java.util.LinkedList;

public class Buyer {
	private String location;
	private LinkedList<Item> cart;
	private LinkedList<Item> saved;
	
	public Buyer() {
		location = "";
		cart = new LinkedList<Item>();
		saved = new LinkedList<Item>();
	}
	
	public void chooseCity(String city) {
		location = city;
	}
	
	public void addToCart(Item product) {
		cart.add(product);
		System.out.println(product.getDescription() + " has been added to cart!");
	}
	
	public void removeFromCart(Item product) {
		cart.remove(product);
		System.out.println(product.getDescription() + " has been removed from cart.");
	}
	
	public void addToSaved(Item product) {
		saved.add(product);
		System.out.println(product.getDescription() + " has been added to your saved items!");
	}
	
	public void removeFromSaved(Item product) {
		saved.remove(product);
		System.out.println(product.getDescription() + " has been removed from your saved items.");
	}
	
	public void moveFromCartToSaved(Item product) {
		if (cart.contains(product)) {
			cart.remove(product);
			saved.add(product);
			System.out.println(product.getDescription() + " has been moved to your saved items!");
		}
	}
	
//	@Override
//	public String toString() {
//		return cart.;
//	}
	
	//override linkedlist toString - ? not sure why not working
	public void viewCart() {
		System.out.println("In your cart: " + cart.toString());
	}
	//override linkedlist toString - ? not sure why not working
	public void viewSaved() {
		System.out.println("Your saved items: " + saved.toString());
	}
	
}
