package com.example;

import Tests.SanityTests.MainMenu;
import Tests.UISmoke.AboutDOH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "auto\\src\\main\\java\\com\\example\\drivers\\chromedriver.exe");
        System.out.println("Hello world");
        WebDriver driver = new ChromeDriver();

        MainMenu DohSanity = new MainMenu();
        AboutDOH AboutUiSmoke = new AboutDOH();

        driver.get("https://doh.gov.ph/");
        try {
            DohSanity.MethodA(driver);
            AboutUiSmoke.uiSmoke(driver);
            driver.quit();
        } catch (Exception e) {
            Thread.sleep(1000);
            driver.quit();
        }

    }

    /*
     * To Work out
     * 
     * User DOH websites
     * 
     * Sanity (Done)
     * Positive Test (Done)
     * UI Smoke
     * 
     * API Testing
     * 
     * Other type of Testing
     * 
     */
}
