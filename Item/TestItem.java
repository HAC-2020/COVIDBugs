package Item;
public class TestItem{
    public static void main(String[] args){
        Item product = new Item(1234,5,"Masks",32.23);
        product.printItem();
        product.updateDescription("Bandana");
        product.printItem();
    }
}