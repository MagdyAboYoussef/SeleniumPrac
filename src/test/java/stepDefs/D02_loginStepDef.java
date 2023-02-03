package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Homepage;
import pages.LoginPage;

public class D02_loginStepDef {
    LoginPage loginPage = new LoginPage();
    Homepage home = new Homepage();


    @Given("user go to login page")
    public void user_go_to_login_page() {
        home.loginPageClick();
    }

    @When("login with valid info {string} and {string}")
    public void login_with_valid(String string, String string2) {
        loginPage.set_login_info(string, string2);
    }

    @And("user press on login button")
    public void user_press_on_login_button() {
        loginPage.submit();
    }

    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() {
        Assert.assertTrue(loginPage.logoutExists(), "login not successful");
    }

    @When("user login with invalid info {string} and {string}")
    public void userLoginWithInvalidInfoAnd(String arg0, String arg1) {
        loginPage.set_login_info(arg0, arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        Assert.assertFalse(loginPage.logoutExists(), "logs in with invalid info");
    }
}
