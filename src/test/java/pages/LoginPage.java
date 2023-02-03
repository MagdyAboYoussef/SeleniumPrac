package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.Hooks;

import java.util.List;

public class LoginPage {
    private WebDriver driver = Hooks.driver;



    public void set_login_info(String user, String password) {
        var emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys(user);
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    public void submit() {

        driver.findElement(By.className("login-button")).click();
    }

    public boolean logoutExists() {
        List<WebElement> logoutButtons = driver.findElements(By.className("ico-logout"));
        return logoutButtons.size() > 0;
    }
}
