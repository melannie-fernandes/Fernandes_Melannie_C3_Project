public class Item {
    private String name;
    private int price;
    public int getPrice(){
        return price;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }
}
//This code holds the details of an item