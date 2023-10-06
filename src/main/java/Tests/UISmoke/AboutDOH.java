package Tests.UISmoke;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AboutDOH {
    public void uiSmoke(WebDriver driver) {

        /*
         *
         * Steps:
         * Assert the text
         * Click the element
         * Go back
         * Repeat for all the element
         * 
         */
        try {
            driver.findElement(By.cssSelector("a[href=\"/about-us\"]")).click();

            assertTitle(driver, "a[href=\"https://doh.gov.ph/profile\"] strong", "Profile");
            driver.findElement(By.cssSelector("a[href=\"/about-us\"]")).click();

            assertTitle(driver, "a[href=\"https://doh.gov.ph/mission-vision\"] strong", "Mision and Vision");
            driver.findElement(By.cssSelector("a[href=\"/about-us\"]")).click();

            assertTitle(driver, "a[href=\"https://doh.gov.ph/milestones\"] strong", "Milestones");
            driver.findElement(By.cssSelector("a[href=\"/about-us\"]")).click();
        } catch (Exception e) {
            System.out.println("Failed Assertion");
        }
    }

    private void assertTitle(WebDriver driver, String selector, String expectedValue) {
        By titleBy = By.cssSelector(selector);

        String title = driver.findElement(titleBy).getText();
        Assert.assertEquals(title, expectedValue);
        driver.findElement(By.cssSelector(selector)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(titleBy));
        System.out.println("Success Assertion");
    }
}
