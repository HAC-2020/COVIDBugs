package Buyer;
import java.util.*;
import java.util.LinkedList;
import Item.Item;
public class Buyer {
	private String location;
	private LinkedList<Item> cart;
	private LinkedList<Item> saved;
	public int sizeCart = 0;
	public int sizeSaved = 0;
	
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
		sizeCart++;

	}
	
	public void removeFromCart(Item product) {
		cart.remove(product);
		System.out.println(product.getDescription() + " has been removed from cart.");
		sizeCart--;
	}
	
	public void addToSaved(Item product) {
		saved.add(product);
		System.out.println(product.getDescription() + " has been added to your saved items!");
		sizeSaved++;
	}
	
	public void removeFromSaved(Item product) {
		saved.remove(product);
		System.out.println(product.getDescription() + " has been removed from your saved items.");
		sizeSaved--;
	}
	
	public void moveFromCartToSaved(Item product) {
		if (cart.contains(product)) {
			cart.remove(product);
			sizeCart--;
			saved.add(product);
			sizeSaved++;
			System.out.println(product.getDescription() + " has been moved to your saved items!");
		}
	}
	
	public void viewCart() {
		System.out.print("[");
		for(int i = 0; i < cart.sizeCart();i++){
				System.out.print(cart.get(i).getDescription());
				if(i == cart.sizeCart()-1) System.out.println("]");
				else System.out.print(", ");
		}
	}
	
	public void viewSaved() {
		System.out.print("[");
		for(int i = 0; i < saved.sizeSaved();i++){
				System.out.print(saved.get(i).getDescription());
				if(i == saved.sizeSaved()-1) System.out.println("]");
				else System.out.print(", ");
		}
	}
	
}
