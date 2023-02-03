package stepDefs;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Homepage;

public class D06_externalLinks {
    Homepage home = new Homepage();
    String title= "";

    @Given("user clicks on {string}")
    public void user_clicks_on(String string) {
        title = home.clickContactLink(string);

    }


    @And("link opens in a new tab")
    public void link_opens_in_new_tab() throws InterruptedException {
        Assert.assertTrue(home.checkTabSize()>1);
    }
    @Then("link matches")
    public void link_matches(){
        Assert.assertEquals(home.getTab2Link(), title);
    }



}
