package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        System.out.println("Insert user1 username!");
        String senderEmail=scan.nextLine();
        System.out.println("Insert user1 password!");
        String senderPassword=scan.nextLine();

        System.out.println("Insert user2 username!");
        String receiverEmail=scan.nextLine();
        System.out.println("Insert user2 passwordyo!");
        String receiverPassword=scan.nextLine();

        String user1="yoan ivanov";
        String user2="Калоян Иванов";

        String testText="Test text";
        String testReply="Test reply";

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //1. Login user1
        Login login=new Login(senderEmail,senderPassword,driver, wait);
        login.login();

        //1.2. Send mail to user2
        SendEmail sendMail=new SendEmail(driver,wait);
        sendMail.sendEmail();

        //1.3. Logout user1
        Logout logout=new Logout(driver,wait);
        logout.logout();
        driver.quit();

        WebDriver driver2=new ChromeDriver();
        WebDriverWait wait2=new WebDriverWait(driver2, Duration.ofSeconds(10));

        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. Login user2
        Login login2=new Login(receiverEmail,receiverPassword,driver2, wait2);
        login2.login();

        //2.1. Verify that mail from user1 is correct
        VerifyEmail verifyEmail=new VerifyEmail(driver2,wait2,user1,testText);
        verifyEmail.verifyEmail();

        //2.2. Send reply to user1
        ReplyEmail replyEmail=new ReplyEmail(driver2,wait2);
        replyEmail.replyEmail();

        //2.3. Logout user2
        Logout logout2=new Logout(driver2,wait2);
        logout2.logout();
        driver2.quit();

        WebDriver driver3=new ChromeDriver();
        WebDriverWait wait3=new WebDriverWait(driver3, Duration.ofSeconds(10));

        driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //3. Login user1
        Login login3=new Login(senderEmail,senderPassword,driver3, wait3);
        login3.login();
        //3.1. Verify that mail from user2 is correct
        VerifyEmail verifyEmail2=new VerifyEmail(driver3,wait3,user2,testReply);
        verifyEmail2.verifyEmail();
        //3.2. Logout user1
        Logout logout3=new Logout(driver3,wait3);
        logout3.logout();
        driver3.quit();

    }
}