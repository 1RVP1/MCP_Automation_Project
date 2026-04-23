package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import utils.ExcelUtil;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AmazonSteps {

    WebDriver driver;

    // 🔥 start from row 1 (skip header "search")
    static int rowIndex = 1;

    @Given("user opens Amazon website")
    public void openAmazon() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");

        driver = new RemoteWebDriver(
                new URL(" http://172.21.0.57:4444"), cap);

        driver.get("https://www.amazon.in");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    @When("user searches for a product")
    public void searchProduct() {

        int totalRows = ExcelUtil.getRowCount();

        // 🔥 random row (skip header → start from 1)
        int row = 1 + (int)(Math.random() * totalRows);

        String product = ExcelUtil.getData(row);

        System.out.println("Searching for: " + product);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );

        searchBox.clear();
        searchBox.sendKeys(product);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Then("search results should be displayed")
    public void verifyResults() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement results = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot"))
        );

        Assert.assertTrue(results.isDisplayed());
    }

    @Then("results count should be greater than zero")
    public void countResults() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> items = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']")
                )
        );

        int count = items.size();

        System.out.println("Total Products Found: " + count);

        Assert.assertTrue(count > 0);
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}