import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//this code acts as a service to interact with the actors
public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    public RestaurantService() {
        LocalTime openingTime = LocalTime.parse("09:00:00");
        LocalTime closingTime = LocalTime.parse("23:00:00");
        restaurants.add(new Restaurant("Amelie's cafe","Chennai",openingTime, closingTime));
    }

    //findRestaurantByname searches for and returns the restaurant matching the input string
    public Restaurant findRestaurantByName(String restaurantName){
        for (Restaurant restaurant : restaurants) {

            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
            if (!(restaurant.getName().equals(restaurantName)))
                throw new restaurantNotFoundException(restaurantName);

        }
        return null;

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
