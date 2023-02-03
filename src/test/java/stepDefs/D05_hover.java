package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Homepage;

public class D05_hover {
    String selectedCategory = "";
    Homepage home = new Homepage();
    @Given("user selects random category and selects random subcategory if exists")
    public void user_selects_random_category() {
       selectedCategory= home.clickRandomCategory();
    }

    @Then("sub category title is equal to title")
    public void sub_category_title_is_equal_to_title() {
        Assert.assertEquals(home.titleText(), selectedCategory);

    }
}
