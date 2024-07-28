package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VerifyEmail {

    public WebDriver driver;

    public WebDriverWait wait;

    public String user;

    public String text;

    public VerifyEmail(WebDriver driver, WebDriverWait wait, String user,String text) {
        this.driver = driver;
        this.wait = wait;
        this.user=user;
        this.text=text;
    }

    public void verifyEmail(){
        List<WebElement> emailRows = driver.findElements(By.xpath("//*[@id='inboxTable']"));

        for (WebElement emailRow : emailRows) {
            String sender = emailRow.findElement(By.xpath(".//td[contains(@class, 'inbox-cellTableSecondColumn')]//div")).getText();
            String subject1 = emailRow.findElement(By.xpath(".//td[contains(@class, 'inbox-cellTableSubjectColumn')]//div")).getText();
            String date = emailRow.findElement(By.xpath(".//td[contains(@class, 'inbox-cellTableLastColumn')]//div")).getText();

            if (sender.equals(user)) {

                driver.findElement(By.xpath(".//td[contains(@class, 'inbox-cellTableSecondColumn')]//div")).click();
                String currentText = driver.findElement(By.xpath("//div[@class='abv-omExternalClass']")).getText();
                String [] currentTextArray=currentText.split("\n");
                String index1=currentTextArray[0];

                System.out.println(index1);
                System.out.println(text);
                Assert.isTrue(currentText.contains(text),"Error");

                System.out.println("Test is OK.");

            }
    }
}}
