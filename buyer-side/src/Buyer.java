import java.util.*;
import java.util.LinkedList;

public class Buyer {
	private String location;
	private LinkedList<Item> cart;
	
	public Buyer() {
		location = "";
		cart = new LinkedList<Item>();
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
	
//	@Override
//	public String toString() {
//		return cart.;
//	}
	
	//override linkedlist toString
	public void viewCart() {
		System.out.println(cart.toString());
		//System.out.println(Arrays.toString(cart.toArray()));
	}
	
}