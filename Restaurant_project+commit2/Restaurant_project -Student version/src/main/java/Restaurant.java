import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//This piece of code holds the details of a restaurant
public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    //isRestaurantOpen returns a boolean whether the restaurant is open or not
    public boolean isRestaurantOpen() {
        //LocalTime openingTime = LocalTime.parse("11:00:00");
        //LocalTime closingTime = LocalTime.parse("23:00:00");
        LocalTime nowtime = getCurrentTime();
        boolean returnvar = true;
        int value1 = nowtime.compareTo(openingTime);
        int value2 = nowtime.compareTo(closingTime);
        if ((value1 + value2) != 0)
            returnvar = false;
        else if ((value1 + value2) == 0)
            returnvar = true;
        return returnvar;
        /*LocalTime nowtime=getCurrentTime();
        boolean returnvar=true;
        if((nowtime.isAfter(openingTime))&&(nowtime.isBefore(closingTime)))
            returnvar=true;
        else if((nowtime.isBefore(openingTime))&&(nowtime.isBefore(closingTime)))
            returnvar=false;
        else if((nowtime.isAfter(openingTime))&&(nowtime.isAfter(closingTime)))
            returnvar=false;
        return returnvar;*/

    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    //getMenu returns the list of items in the menu
    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;

    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }


}

