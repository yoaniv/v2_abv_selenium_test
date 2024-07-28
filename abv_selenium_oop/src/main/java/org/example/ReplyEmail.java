package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReplyEmail {

    public WebDriver driver;

    public WebDriverWait wait;

    public ReplyEmail(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void replyEmail(){


        List<WebElement> options= driver.findElements(By.xpath("//div[@class='abv-letterMItem']"));
        for (WebElement option : options) {
            if (option.getText().equals("Отговори")){
                option.click();
                break;
            }
        }
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='gwt-RichTextArea']")));
            WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@contenteditable='true']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(messageInput)
                    .click()
                    .sendKeys(Keys.HOME)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys(Keys.ARROW_UP)
                    .sendKeys("Test reply")
                    .perform();
//                    messageInput.click();
//                    messageInput.sendKeys(reply);
        } catch (Exception e) {
            System.out.println("error");
        }
        driver.switchTo().defaultContent();
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='abv-button']")));
        sendButton.click();
    }
}
