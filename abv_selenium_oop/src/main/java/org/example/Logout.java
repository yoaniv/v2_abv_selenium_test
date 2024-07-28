package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

public WebDriver driver;
public WebDriverWait wait;

    public Logout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }

    public void logout(){

        WebElement menuLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='gwt-uid-387']")));
        menuLogout.click();
       // Thread.sleep(5000);
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='gwt-uid-390']")));
        logoutButton.click();
       // Thread.sleep(5000);

    }
}
