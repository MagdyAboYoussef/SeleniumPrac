package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Homepage;

import static stepDefs.Hooks.driver;


public class D04_search {
    Homepage home = new Homepage();

        @Given("user searches for {string}")
        public void user_searches_for (String string){
            home.search(string);
            String url = driver.getCurrentUrl();
            Assert.assertTrue(url.contains("https://demo.nopcommerce.com/search?q="));
        }
        @Then("{string} should appear in the search results")
        public void should_appear_in_the_search_results (String string){
            Assert.assertTrue(home.verify_product(string));
        }


    @Then("user clicks on each product and checks if sku matches{string}")
    public void userClicksOnEachProductAndChecksIfSkuMatchesSku(String string) {
        home.check_serial(string);

    }
}
