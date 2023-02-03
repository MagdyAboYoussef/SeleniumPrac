package pages;

import org.apache.commons.text.StringEscapeUtils;
import org.checkerframework.checker.lock.qual.ReleasesNoLocks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefs.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homepage {
    private WebDriver driver = Hooks.driver;


    public void registerButtonClick() {
        driver.findElement(By.className("ico-register")).click();
    }

    public void loginPageClick() {
        driver.findElement(By.className("ico-login")).click();
    }

    public void logout() {
        driver.findElement(By.className("ico-logout")).click();
    }

    public void select_euro() {
        WebElement currencyDropdown = driver.findElement(By.id("customerCurrency"));
        Select currency = new Select(currencyDropdown);
        currency.selectByVisibleText("Euro");
    }

    public Boolean verify_currency() {
        List<WebElement> prices = driver.findElements(By.cssSelector(".price.actual-price"));
        for (int i = 0; i < prices.size(); i++) {
            if ( !prices.get(i).getText().contains("€") ) {
                return false;
            }
        }
        return true;
    }

    public void search(String stringToFind) {
        WebElement searchField = driver.findElement(By.id("small-searchterms"));
        WebElement searchButton = driver.findElement(By.cssSelector(".button-1.search-box-button"));
        searchField.sendKeys(stringToFind);
        searchButton.click();
    }

    public Boolean verify_product(String string) {
        string = string.toLowerCase();
        List<WebElement> product = driver.findElements(By.className("product-title"));
        for (int i = 0; i < product.size(); i++) {
            if ( !product.get(i).getText().toLowerCase().contains(string) ) {
                return false;
            }
        }
        return true;
    }

    public Boolean check_serial(String string) {
        List<WebElement> products = driver.findElements(By.cssSelector("h2.product-title a"));
        Boolean found = false;
        for (WebElement product : products) {
            String href = product.getAttribute("href");
            driver.get(href);
            WebElement serial = driver.findElement(By.className("value"));
            found = serial.getText().toLowerCase().contains(string.toLowerCase());
            if ( found == false ) {
                return false;
            }
            driver.navigate().back();

        }
        return true;
    }


    public String clickRandomCategory() {
        List<WebElement> bar = driver.findElements(By.xpath("//ul[contains(@class, \"top-menu\") and contains(@class, \"notmobile\")]/li"));
        Random random = new Random();
        int headerRandomNumber = random.nextInt(6);

        WebElement toTest = bar.get(1);
        String title = "";
        List<WebElement> contains = toTest.findElements(By.tagName("li"));

        List<WebElement> subCategoryLinks = toTest.findElements(By.tagName("a"));

        if ( contains.size() == 0 ) {
            title = toTest.getText().trim().toLowerCase();
            toTest.click();
        } else {
            int randomNum = random.nextInt(contains.size() - 1);
            title = StringEscapeUtils.unescapeHtml4(subCategoryLinks.get(randomNum).getAttribute("innerHTML")).trim().toLowerCase();

            String linkUrl = subCategoryLinks.get(randomNum).getAttribute("href");
            driver.get(linkUrl);
        }

        return title;
    }


    public String titleText() {
        return driver.findElement(By.xpath("//div[@class=\"page-title\"]/h1")).getText().trim().toLowerCase();
    }


    public String clickContactLink(String string) {
        WebElement link = driver.findElement(By.linkText(string));
        String title = link.getAttribute("href");
        link.click();

        if ( title.substring(0, 5).equalsIgnoreCase("https") ) {
            return title.substring(5);
        } else {
            return title.substring(4);
        }


    }

    public int checkTabSize() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();

    }

    public String getTab2Link() {
        String link = "";
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        link = Hooks.driver.getCurrentUrl();
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
        return link.substring(5);
    }


    public void clickRandomProduct() {
        List<WebElement> products = driver.findElements(By.xpath("//h2[@Class=\"product-title\"]/a"));
        Random random = new Random();
        int x = random.nextInt(products.size() - 1);
        WebElement selected = products.get(x);
        selected.click();
    }

    public void clickWishlist() {
        WebElement selected = driver.findElement(By.className("add-to-wishlist"));
        selected.click();
    }

    public String getColorOfBar() {
        WebElement notif = driver.findElement(By.className("bar-notification"));
        notif.getCssValue("background-color");
        return notif.getCssValue("background-color");
    }

    public void clickWishCart() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        driver.findElement(By.className("wishlist-label")).click();

    }

    public Boolean qtyHigherThan0() {
        List<WebElement> qty = driver.findElements(By.xpath("//td[@class='quantity']/input"));
        if ( qty.size() < 1 ) {
            return false;
        }
        for (int i = 0; i < qty.size(); i++) {
            if (Integer.parseInt(qty.get(i).getAttribute("Value")) < 1){
                return false;
            }
        }
        return true;
    }
}


