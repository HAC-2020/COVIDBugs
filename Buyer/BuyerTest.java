package Buyer;
import java.util.*;

import Item.Item;
public class BuyerTest {
	public static void main(String[] args) {
		
		Buyer buyer1 = new Buyer();
		
		buyer1.chooseCity("Atlanta");
		
		Item mask = new Item(1234, 1, "Mask", 1.99);
		Item tp = new Item(1235, 1, "Toilet paper", 3.00);
		Item sanitizer = new Item(1223, 1, "Hand sanitizer", 5.00);
		Item wipes = new Item(1333, 1, "Wipes", 1.00);
		
		buyer1.addToCart(mask);
		buyer1.addToCart(tp);
		buyer1.addToCart(sanitizer);
		buyer1.removeFromCart(tp);
		
		buyer1.viewCart();

		buyer1.addToSaved(tp);
		buyer1.addToSaved(wipes);
		buyer1.moveFromCartToSaved(mask);
		
		buyer1.viewCart();
		buyer1.viewSaved();

		
	}
}
