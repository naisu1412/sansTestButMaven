package Tests.SanityTests;

import java.time.Duration;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenu {
    public void MethodA(WebDriver driver) {
        /*
         * Steps:
         * Click About DOH
         * Click Procurement
         * Click Beat Covid-19
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // // Procurment
        // driver.findElement(By.cssSelector("a[href=\"/procurement\"]")).click();
        // driver.findElement(By.cssSelector("a[href=\"Procurement\"]"));

        // Beat Covid 19
        SelectElement(driver, wait, "a[href=\"/2019-nCoV\"]",
                "//h5[text()=\"Updates on Novel Coronavirus Disease 2019 (COVID-19)\"]");

        // DOH
        SelectElement(driver, wait, "a[href=\"/about-us\"]",
                "//h5[text()=\"About Us\"]");


    }

    private void SelectElement(WebDriver driver, WebDriverWait wait, String main_menuSelector,
            String waitElementXpath) {
        driver.findElement(By.cssSelector(main_menuSelector)).click();
        By covD = By.xpath(waitElementXpath);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(covD));
            System.out.println("Element exists selector: " + waitElementXpath);
        } catch (Exception e) {
            System.out.println("Element does not exists selector: " + waitElementXpath);
        }
    }
}
