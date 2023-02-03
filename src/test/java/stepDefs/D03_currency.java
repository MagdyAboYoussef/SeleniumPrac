package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Homepage;

public class D03_currency {
    Homepage home = new Homepage();
    @Given("user press on currency button and selects euro")
    public void user_selects_euro() {
        home.select_euro();
    }

    @Then("€ should be displayed for product currency")
    public void euroVerificationSymbol() {
        Assert.assertTrue(home.verify_currency(),("Text doesn't contain euro symbol"));
    }
}
