package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Homepage;
import pages.RegisterPage;

public class D01_registerStepDef {

    RegisterPage registerPage = new RegisterPage();
    Homepage home = new Homepage();

    @Given("user go to register page")
    public void goRegisterPage() {
    home.registerButtonClick();
    }

    @Given("user select gender type")
    public void user_select_gender_type() {
        registerPage.selectGender();
    }

    @Given("user enter first name {string} and last name {string}")
    public void user_enter_first_name_and_last_name(String string, String string2) {
        registerPage.setFirstName(string);
        registerPage.setLastName(string2);

    }

    @Given("user enter date of birth")
    public void user_enter_date_of_birth() {
        registerPage.setDate("27", "10", "1997");

    }

    @Given("user enter email {string} field")
    public void user_enter_email_field(String string) {
        registerPage.setEmail(string);

    }

    @Given("user fills Password fields {string} {string}")
    public void user_fills_password_fields(String string, String string2) {
        registerPage.setPassword(string, string2);

    }

    @Given("user clicks on register button")
    public void user_clicks_on_register_button() {
        registerPage.submit();

    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {
        Assert.assertEquals(registerPage.result_output_successful(), "Your registration completed");
    }

}


