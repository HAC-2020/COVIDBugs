
public class Item {
    private int sku;
    private int quantity;
    private String description; //of item
    private double price;
    public Item(){
        sku=-1;
        price = 0.0;
        quantity=0;
        description = "none";
    }
    public Item(int s, int q, String des, double p){
        sku = s;
        quantity = q;
        description = des;
        price = p;
    }
    public void setSKU(int s){
        sku = s;
    }
    public int getSKU(){
        return sku;
    }
    public void setQuantity(int q){
        quantity = q;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setDescription(String d){
        description = d;
    }
    public String getDescription(){
        return description;
    }
    public void updateDescription(String d){
        description = d;
        System.out.println("Description has been updated\n");
    }
    public void updateQuantity(int q){
        quantity = q;
        System.out.println("Quantity has been updated\n");
    }
    public void setPrice(int p){
        price = p;
    }
    public double getPrice(){
        return price;
    }
    public void printItem(){
        System.out.println("SKU: "+this.getSKU()+"\n");
        System.out.println("Description: "+this.getDescription()+"\n");
        System.out.println("Quantity: "+this.getSKU()+"\n");
        System.out.println("Price: $"+this.getPrice()+"\n");
    }

}