package Shop;
import java.util.*;
import Seller.Seller;
import Buyer.Buyer;
import Item.Item;
import java.util.ArrayList;
public class Shop {
    public static ArrayList<Seller> sellerslist;

    //initilizes arraylist
    public Shop(){
        sellerslist = new ArrayList<Seller>();
    }
    /*
    checks if buyer or seller is in range call for
    checking locality
     */
    public boolean inRange(double range, double distance){
        if (range > distance){
            return true;
        }
        return false;
    }
    //
    public static Seller NewSeller(String name, Item productname, String[] pm, String[] delivery,
                          String S, double la, double lo){
         Seller seller1 = new Seller(name, productname, pm, delivery);
         seller1.setLocation(S, la, lo);
         return seller1;
    }

    public static void buyer(){

    }
    public static double distance(double lat1,double lat2,double lon1,double lon2){
        lat1= Math.toRadians(lat1);
        lat2= Math.toRadians(lat2);
        lon1= Math.toRadians(lon1);
        lon2= Math.toRadians(lon2);

        /*Haversine formula*/
        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;
        double a = Math.pow(Math.sin(dlat/2),2)+
                Math.cos(lat1)*Math.cos(lat2)+
                Math.pow(Math.sin(dlon/2),2);
        double c = 2*Math.asin(Math.sqrt(a));
        double r = 3956;   //this is in Km, use 3956 for mi
        return c * r;
    }
    //finds if seller name is in the list
    public static int getSeller(String name){
       // if(sellerslist == null) return -1;
        for (int i = 0; i < sellerslist.size(); i++){
            if (name == sellerslist.get(i).getName()){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        int user_input = 0;
        /*To store user inputs*/
        String sellerName = "Jack";
        /* items they are selling (sku,quantity,descrip,price)*/
        Item produce= new Item(1111, 5, "Banana",9.99);

        String pm1 = "visa";
        String pm2 = "paypal";
        String[] payments = new String[]{pm1,pm2}; // payments seller accepts
       // String[] PM = new String []{"null","null","null","null"}; //payments to store in sellerObj
       // for(int i = 0;i<payments.length;i++)    PM[i] = payments[i];

        /* could be boolean just to check if they do instore or not and store it in bool instore or home delivery*/
        String[] delivery = new String[]{"in Store", "home delivery"};

        /*Seller Location*/
        String city = "Santa Cruz";
        double latitude = 36.9741;
        double longitude = 122.0308;

        if (user_input == 1){ //if it a seller
            if(sellerslist==null){
                Seller sellerObj = NewSeller(sellerName,produce,payments,
                        delivery,city,latitude,longitude); //make seller obj with necessary information about seller
                sellerslist = new ArrayList<Seller>();
                sellerslist.add(sellerObj); // adds to seller list
            }
            int position = getSeller(sellerName);
            if (position == -1){
                Seller sellerObj = NewSeller(sellerName,produce,payments,
                        delivery,city,latitude,longitude); //make seller obj with necessary information obout seller
                sellerslist.add(sellerObj); // adds to seller list
            }else{
                System.out.println("Hello " + sellerslist.get(position).getName()); //print out existing seller Name
                //ask if they want to add more items or update the items
                int updateItem = 1;// This will be user input
                if(updateItem == 1) {
                    //ask for SKU to update item
                    boolean exit = false;
                    /*loop until user put in correct SKU*/
                    while(exit==false) {
                        int userSKU = 1111; //user input sku
                        int itemPos = sellerslist.get(position).search(userSKU); //search for sku pos in item list
                        if (itemPos == -1) {
                            System.out.println("Item Does Not Exist. Please type in valid SKU"); //print out existing seller Name

                        } else {
                            sellerslist.get(position).update(itemPos);
                            exit = true;
                        }
                    }
                }else{
                    /*need to ask user for item details*/
                    Item itToAdd= new Item(1111, 5, "Banana",9.99);
                    sellerslist.get(position).add(itToAdd);/*ask for item to add*/
                }
            }




        }else{
            Buyer buyer1 = new Buyer();
            buyer1.chooseCity("Fremont");
            /*Buyer section goes here*/


            /*Assume this is buyer coordinates*/
            double buyerLat = 37.5485;
            double buyerLon = 121.9886;

            double closerSellerLat  = 37.3382;
            double closerSellerLon = 121.8863;

            double d1 = distance(buyerLat,latitude,buyerLon,longitude);
            double d2 = distance(buyerLat,closerSellerLat,buyerLon,closerSellerLon);
            if(d2<d1) System.out.print("CloserSeller is closer to Buyer.");
            //test
            Seller sellerObj = NewSeller(sellerName,produce,payments,
                    delivery,city,latitude,longitude); //make seller obj with necessary information about seller
            sellerslist = new ArrayList<Seller>();
            sellerslist.add(sellerObj); // adds to seller list
            //end of test
            int userChoice = 0; //user choice of vendor to shop at
            /*calculate the distance between a buyer and all the seller.*/
            if(!sellerslist.isEmpty()) {
                double[] distances = new double[sellerslist.size()];
                double dist =0; //to store a single distance between a seller and a buyer
                /*Need better way of accessing Hashmap values*/
                for(int i = 0 ; i< sellerslist.size();i++) {
                    double sellerLat = 0;
                    double sellerLon = 0;
                    sellerslist.get(i).getLocation().keySet(); //return the city seller is in
                    for (List<Seller.Coordinates> t : sellerslist.get(i).getLocation().values()) {
                        for (Seller.Coordinates x : t) {
                            sellerLat = x.getLatitude();
                            sellerLon = x.getLongitude();
                        }
                    }
                    dist = distance(buyerLat,latitude,buyerLon,longitude);
                    distances[i]=dist;
                }
                /* Return every seller's name that is within the certain radius*/
                System.out.print("Press to shop at this vendor: \n");

                for(int j = 0 ; j <distances.length;j++){
                    /*if distance between seller and a buyer is less than 5 km*/
                    if(distances[j]<5) System.out.println(j+": "+sellerslist.get(j).getName());
                }

            }
            /*Then you should have the position of in the sellerlist. You can use that to get into seller's stock*/
            System.out.println("Welcome to "+sellerslist.get(userChoice).getName());
            double finalprice = 0;
            int user_input1 = 1;
            while (user_input1 == 1){

                /*Pick Items,
                 call sellerslist's sell method to reduce the stock,
                * add to cart if they are able to get the exact amount, else return out of stock
                * */
                sellerslist.get(userChoice).printStock(); // print all the items that vendor has.
                System.out.print("Enter the item number you wish to buy along with the amount. \n");
                int userItemChoice = 1111; //the item user want to buy
                int userItemAmount = 5;
                sellerslist.get(userChoice).sell(userItemChoice,userItemAmount);
                Item posOfItem = sellerslist.get(userChoice).getItem(userItemChoice); // to get description
                user_input = 1;

                buyer1.addToCart(new Item(userItemChoice, userItemAmount, posOfItem.getDescription(), posOfItem.getPrice()));
                buyer1.viewCart();
                finalprice += (sellerslist.get(userChoice).getItem(userItemChoice).getPrice() * userItemAmount);
                System.out.println("Your total is $" + finalprice);
                System.out.println("Would you like to add another item?");
                user_input1 = 0;
                //ask user for input?
            }

            //check out




        }




    }
}
