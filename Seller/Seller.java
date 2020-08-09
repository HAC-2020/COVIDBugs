package Seller;
import Item.Item;
import java.util.*;
/*for a single seller*/
public class Seller {
    private String name;
    private ArrayList<Item> products;
    private HashMap<String, List<Coordinates>> sLocation; //seller location, requires string, coordinates
    private String[] deliveryOpts; // home delivery or in store
    private String[] payments; //type of payment (VISA)
    /*Might also need Total sales?*/
    /*Column/block for requested products?*/
    /*public Seller(){
        products = new ArrayList<Item>();
        //List<Coordinates> location = new ArrayList<>();
        sLocation = new HashMap<String,List<Coordinates>>();
    }*/
    /*need to add coordinates*/
    //needs lon and lat
    public Seller(String n, Item it, String[] pm, String[] delivery) {
        name = n;
        products = new ArrayList<Item>();
        products.add(it);
        payments = pm;
        deliveryOpts = delivery;//should be string

        //sLocation.put(c,loc);
    }

    public Seller setLocation(String s, double la, double lo) {
        List<Coordinates> cor = new ArrayList<Coordinates>();
        cor.add(new Coordinates(la, lo));
        sLocation = new HashMap<String, List<Coordinates>>();
        this.sLocation.put(s, cor);
        return this;
    }
    public HashMap<String, List<Coordinates>> getLocation() {
        return sLocation;
    }
    /*set vendor name*/
    public void setName(String n) {
        name = n;
    }

    /*get vendor name*/
    public String getName() {
        return name;
    }

    public int numOfProducts() {
        return products.size();
    }

    /*To print out items in stock along with seller location*/
    public void printStock() {
        System.out.println("Name: " + getName());
        System.out.print("Located at: " + sLocation.keySet());//+ sLocation.values().toString());
        for (List<Coordinates> t : sLocation.values()) {
            for (Coordinates x : t) {
                System.out.println("[" + x.getLatitude() + ", " + x.getLongitude() + "]");
            }
        }
//        for(Map.Entry<String,List<Coordinates>> entry : sLocation.entrySet()){
//            for(entry val : )
//        }
        for (int i = 0; i < products.size(); i++) {
            products.get(i).printItem();
        }
        System.out.println("We accept payments of the form: ");
        for (int j = 0; j < payments.length; j++) {
            System.out.print(payments[j]);
            if (j != payments.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("Delivery Options: ");
        for (int m = 0; m < deliveryOpts.length; m++) {
            System.out.print(deliveryOpts[m]);
            if (m != deliveryOpts.length - 1) {
                System.out.print(", ");
            }
        }
    }

    /* add items to the list*/
    public void add(Item it) {

        if (products.isEmpty()) {
            products.add(it);
        } else {
            int index = search(it.getSKU());
            ;
            if (index != -1) {
                System.out.print("The SKU exists. Use different SKU.\n");
                /*ask if they want to update it*/
                //update(it.getSKU());
            } else {
                products.add(it);
            }
        }

    }
    public Item getItem(int i){
        int searched = search(i);
        return products.get(searched);
    }
    /*
    accepts SKU numbers and search and product list
    */
    public int search(int s) {

        for (int i = 0; i < products.size(); i++) {
            /*need to return position if SKU exists*/
            if (products.get(i).getSKU() == s) return i;
        }
        return -1;
    }

    /*takes in SKU, search if it exists. if it does, update, if it does not, add to product*/
    public void update(int s) {
        int index = search(s);
        if (index == -1) {
            System.out.print("Invalid SKU.\n");
        } else {
            System.out.print("SKU found! \n");
            products.get(index).printItem();

            System.out.print("update description? (Y/N) \n");
            /*For testing purposes*/
            char decision = 'y';
            if (decision == 'y') {
                System.out.print("Please update your item description.\n");
                String k = "One time use Masks";
                products.get(index).updateDescription(k);
                products.get(index).printItem();
            }
            System.out.print("update quantity? (Y/N) \n");
            if (decision == 'y') {
                System.out.print("Please update your item quantities. \n");
                int newQuantity = 5;
                products.get(index).updateQuantity(newQuantity);
                products.get(index).printItem();
            }
        }
    }
    /*sku and quantity*/
    public void sell(int s, int q) {
        int index = search(s);
        if (index == -1) {
            System.out.print("Invalid SKU.\n");
        } else {
            System.out.print("SKU found! \n");
            if (products.get(index).getQuantity() == 0) {
                System.out.print("Out of stock\n");
                products.get(index).printItem();
            }else{
                q -= q;
                products.get(index).updateQuantity(q);
                System.out.print(q + " was them was removed from stock. \n");
                products.get(index).printItem();
            }

        }
    }

    /*class to store seller location*/
    public class Coordinates{
        private double latitude,longitude;
        public Coordinates(double la,double lo){
            latitude=la;
            longitude=lo;
        }
        public double getLatitude(){
            return latitude;
        }
        public double getLongitude() {
            return longitude;
        }
    }

}