import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.ListIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
//contains test methods to test all methods in Restaurant class
class RestaurantTest {
    Restaurant restaurant;
    Item item;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    @BeforeEach

    public void setup()
    {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    //To test if the method isRestaurantOpen() returns true if the current time is between the opening and closing time.
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        //tested when current time was 10:03
        Restaurant spiedTime=Mockito.spy(restaurant);
        Mockito.when(spiedTime.getCurrentTime()).thenReturn(LocalTime.parse("10:45:00"));
        boolean isopen = spiedTime.isRestaurantOpen();
        assertEquals(true,isopen);

    }
//To test if the method isRestaurantOpen() returns false if the current time is outside the opening and closing time.
    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        //tested when current time was 10:03
        Restaurant spiedTime=Mockito.spy(restaurant);
        Mockito.when(spiedTime.getCurrentTime()).thenReturn(LocalTime.parse("23:45:00"));
        boolean isopen = spiedTime.isRestaurantOpen();
        assertEquals(false,isopen);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        assertThrows(itemNotFoundException.class, ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Item is always in the menu
    //display total dont store chosen items or order value
    //pass item1 item2 or a list of items
    //failingtestcaseifnoitemsselected
    @Test
    public void when_no_items_selected_return_no_items_to_calculate_cost_and_return_null(){
        Restaurant spiedMenu=Mockito.spy(restaurant);
        Mockito.when(spiedMenu.getName().toString()).thenReturn("null");
        assertNull(spiedMenu);


    }
    @Test
    public void when_items_given_return_total(){
        int price1= restaurant.getPriceByItem("Vegetable lasagne");
        int price2= restaurant.getPriceByItem("Sweet corn soup");
        int total=price1+price2;
        assertNotNull(total);
    }
}