package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefs.Hooks;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver = Hooks.driver;


    public void selectGender() {
        driver.findElement(By.id("gender-male")).click();
    }

    public void setFirstName(String firstName) {

        driver.findElement(By.id("FirstName")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.id("LastName")).sendKeys(lastName);
    }

    public void setDate(String day, String month, String year) {


        Select daySelect = new Select(driver.findElement(By.name("DateOfBirthDay")));
        Select monthSelect = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        Select yearSelect = new Select(driver.findElement(By.name("DateOfBirthYear")));

        daySelect.selectByValue(day);
        monthSelect.selectByValue(month);
        yearSelect.selectByValue(year);
    }

    public void setEmail(String email) {

        driver.findElement(By.id("Email")).sendKeys(email);
    }

    public void setPassword(String password, String confirmPassword) {
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }

    public void submit() {
        driver.findElement(By.id("register-button")).click();
    }

    public String result_output_successful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        return driver.findElement(By.className("result")).getText();
    }


}