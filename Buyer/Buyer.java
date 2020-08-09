package Buyer;
import java.util.*;
import java.util.LinkedList;
import Item.Item;
public class Buyer {
	private String location;
	private LinkedList<Item> cart;
	public int size = 0;
	
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
		size++;

	}
	
	public void removeFromCart(Item product) {
		cart.remove(product);
		System.out.println(product.getDescription() + " has been removed from cart.");
		size--;
	}
	
//	@Override
//	public String toString() {
//		return cart.;
//	}
	
	//override linkedlist toString
	public void viewCart() {
		System.out.print("[");
		for(int i = 0; i < cart.size();i++){
				System.out.print(cart.get(i).getDescription());
				if(i == cart.size()-1) System.out.println("]");
				else System.out.print(", ");
		}

	}
	
}
