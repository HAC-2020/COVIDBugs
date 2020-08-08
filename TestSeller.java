package Seller;

import Item.Item;
public class TestSeller{
    public static void main(String[] args){
        String[] pay_with = {"Visa","MasterCard","Paypal"};
        String[] shoppingOpts = {"Delivery","In store Only"};
        Item product = new Item(1234,5,"Masks",32.23);
        Item product1 = new Item(1111,2,"Hand Sanitizer",9.99);
        Seller shop = new Seller("Broski",product,pay_with,shoppingOpts).setLocation(
                "Fremont",37.5485,121.9886);

        System.out.println(shop.getName());
        System.out.println(shop.numOfProducts());

        shop.add(product);
        System.out.println(shop.search(1234));
        System.out.println(shop.search(0000));
        shop.update(0000);
        shop.update(1234);
        shop.add(product1);
        shop.printStock();
    }
}