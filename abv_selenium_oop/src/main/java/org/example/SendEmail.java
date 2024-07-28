package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmail {



    public WebDriver driver;

    public WebDriverWait wait;

    public SendEmail(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait=wait;
    }

    public void sendEmail(){
        driver.findElement(By.xpath("//div[@class='abv-button']")).click();
        driver.findElement(By.xpath("//input[@class='fl']")).sendKeys("kaloyann.ivanov@abv.bg");
        driver.findElement(By.xpath("//input[@class='gwt-TextBox']")).click();
        driver.findElement(By.xpath("//input[@class='gwt-TextBox']")).sendKeys("Test subject");

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='gwt-RichTextArea']")));
            WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@contenteditable='true']")));
            messageInput.click();
            messageInput.sendKeys("Test text");
        } catch (Exception e) {
            System.out.println("error");
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@class='abv-button']")).click();

    }
}
