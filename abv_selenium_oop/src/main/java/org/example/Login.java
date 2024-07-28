package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends ApproveGDPR {

    public String username;
    public String password;
    public WebDriver driver;

    public WebDriverWait wait;

    public Login(String username, String password, WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.wait = wait;
    }

    public void login() {

        driver.get("https://www.abv.bg/");

//
//        try {
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("abv-GDPR-frame")));
//            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='didomi-notice-agree-button']")));
//            acceptCookiesButton.click();
//            driver.switchTo().defaultContent();
//        } catch (Exception e) {
//            System.out.println("error");
//            driver.switchTo().defaultContent();
//        }

        driver.findElement(By.xpath("//input[@class='abv-LoginField']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        approveGDPR();


//        String mainWindow = driver.getWindowHandle();
//        Set<String> handler = driver.getWindowHandles();
//
//
//
//        for (String s : handler) {
//            if (!s.equals(mainWindow)) {
//                driver.switchTo().window(s);
//
//                try {
//
//                    WebElement button = driver.findElement(By.xpath("//p[@class='fc-button-label']"));
//                    if (button.isDisplayed()) {
//                        button.click();
//                    }
//                } catch (Exception e) {
//                    System.out.println("error");
//                }
//
//                driver.switchTo().window(mainWindow);
//            }
//        }

//        try {
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("abv-GDPR-frame")));
//            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='fc-button-label']")));
//            acceptCookiesButton.click();
//            driver.switchTo().defaultContent();
//        } catch (Exception e) {
//            System.out.println("error");
//            driver.switchTo().defaultContent();
//        }

    }


}
