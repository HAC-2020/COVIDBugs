package Shop;
import java.util.*;
import Seller.Seller;
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
    public void NewSeller(String name, Item productname, String[] pm, String[] delivery, String S, double la, double lo){
         Seller seller1 = new Seller(name, productname, pm, delivery);
         seller1.setLocation(S, la, lo);
         sellerslist.add(seller1);
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
    //finds the name of seller
    public static int getSeller(String name){
        for (int i = 0; i < sellerslist.size(); i++){
            if (name == sellerslist.get(i).getName()){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String name = "Walmart";
        String temp = ;
        String temp1 = ;
        String destemp = ;
        int skutemp = ;
        int qtemp = ;
        double ptemp = ;
        if (args[1] == "1"){
            int position = getSeller(name);
            if (position == -1){
                NewSeller();//needs inputs
            }else{
                System.out.println("Hello" + sellerslist.get(position).getName());
                String[] PM = new String []{"null","null","null","null"};
                //adds all payment method into an array
                //use temp to place pm into array

                //places delivery options into array
                for(int i = 0; i < 4; i++) {
                    PM[i] = temp; //pls give me payment methods here
                }
                String[] delivery = new String []{"null","null"};
                for(int i = 0; i < 2; i++){
                    delivery[i] = temp1; //pls give delivery options here
                }
            }



//            while (something != null;){
//
//            }


            .add(new Item(skutemp, qtemp, destemp, ptemp));
            NewSeller(args[2], , PM, delivery);

        }else{

        }
        HashMap<String, List<Coordinates>> temp1 = Seller.getLocation();
        HashMap<String, List<Coordinates>> temp2 = Buyer.getLocation();
        distance()
    }
}
