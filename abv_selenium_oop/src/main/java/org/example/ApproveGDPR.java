package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ApproveGDPR {

    WebDriver driver;

    public ApproveGDPR(WebDriver driver) {
        this.driver = driver;
    }



    public void approveGDPR(){

        String mainWindow = driver.getWindowHandle();
        Set<String> handler = driver.getWindowHandles();


        for (String s : handler) {
            if (!s.equals(mainWindow)) {
                driver.switchTo().window(s);

                try {

                    WebElement button = driver.findElement(By.xpath("//p[@class='fc-button-label']"));
                    if (button.isDisplayed()) {
                        button.click();
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }

                driver.switchTo().window(mainWindow);
            }
        }

    }
}
