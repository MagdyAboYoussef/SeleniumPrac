package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Homepage;

public class D07_wishList {
    Homepage home = new Homepage();
    @Given("user click on a product in the webpage")
    public void user_click_on_a_product_in_the_webpage() {
        home.clickRandomProduct();
    }
    @Given("user clicks add to wishlist")
    public void user_clicks_add_to_wishlist() {
       home.clickWishlist();
    }
    @Then("green msg appears saying it was added successfully and wishcart shows the item with qt higher than zero")
    public void green_msg_appears_saying_it_was_added_successfully_and_wishcart_shows_the_item_with_qt_higher_than_zero() {
        Assert.assertEquals(home.getColorOfBar(), "rgba(75, 176, 122, 1)");
        home.clickWishCart();
        Assert.assertTrue(home.qtyHigherThan0());
    }
}
