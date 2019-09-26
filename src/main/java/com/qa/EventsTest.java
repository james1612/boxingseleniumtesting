package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class EventsTest {
    private ChromeDriver driver;

    private String webLocation = "http://35.246.122.192/events.html";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\boxingseleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }



    @Test
    public void addEvent() throws InterruptedException {
        driver.get(webLocation);
        Thread.sleep(2000);
        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement boxer1 = driver.findElementById("boxer1");
        boxer1.sendKeys("Errol Spence");
        Thread.sleep(1000);
        WebElement boxer2 = driver.findElementById("boxer2");
        boxer2.sendKeys("Terrence Crawford");
        Thread.sleep(1000);
        WebElement location = driver.findElementById("location");
        location.sendKeys("MSG");
        Thread.sleep(1000);
        WebElement result = driver.findElementById("result");
        result.sendKeys("UD12");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);

        WebElement boxer1WE = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Errol Spence", boxer1WE.getText());
    }

    @Test
    public void editEvent() throws InterruptedException {
        driver.get(webLocation);
        Thread.sleep(2000);

        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement boxer1 = driver.findElementById("boxer1");
        boxer1.sendKeys("Errol Spence");
        Thread.sleep(1000);
        WebElement boxer2 = driver.findElementById("boxer2");
        boxer2.sendKeys("Terrence Crawford");
        Thread.sleep(1000);
        WebElement location = driver.findElementById("location");
        location.sendKeys("MSG");
        Thread.sleep(1000);
        WebElement result = driver.findElementById("result");
        result.sendKeys("UD12");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);



        WebElement editButton = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[6]/button[1]");
        editButton.click();
        Thread.sleep(1000);
        WebElement editboxer1 = driver.findElementByXPath("//*[@id=\"editForm\"]/input[1]");
        editboxer1.clear();
        editboxer1.sendKeys("Manny Pacquiao");
        WebElement editSubmit = driver.findElementByXPath("//*[@id=\"editForm\"]/input[5]");
        editSubmit.click();
        Thread.sleep(1000);
        WebElement boxerFirstName = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Manny Pacquiao", boxerFirstName.getText());

    }


    @Test
    public void deleteEvent() throws InterruptedException {
        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement boxer1 = driver.findElementById("boxer1");
        boxer1.sendKeys("Errol Spence");
        Thread.sleep(1000);
        WebElement boxer2 = driver.findElementById("boxer2");
        boxer2.sendKeys("Terrence Crawford");
        Thread.sleep(1000);
        WebElement location = driver.findElementById("location");
        location.sendKeys("MSG");
        Thread.sleep(1000);
        WebElement result = driver.findElementById("result");
        result.sendKeys("UD12");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);

        WebElement boxer1WE = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Errol Spence", boxer1WE.getText());

        Thread.sleep(2000);
        addButton.click();
        Thread.sleep(2000);
        WebElement boxer12 = driver.findElementById("boxer1");
        boxer12.sendKeys("Manny Pacquiao");
        Thread.sleep(1000);
        WebElement boxer22 = driver.findElementById("boxer2");
        boxer22.sendKeys("Shawn Porter");
        Thread.sleep(1000);
        WebElement location2 = driver.findElementById("location");
        location2.sendKeys("Phillipines");
        Thread.sleep(1000);
        WebElement result2 = driver.findElementById("result");
        result2.sendKeys("KO10");
        Thread.sleep(1000);
        WebElement modalSubmit2 = driver.findElementById("modalSubmit");
        modalSubmit2.click();
        Thread.sleep(1000);

        WebElement deleteButton = driver.findElementByXPath("//*[@id=\"returned\"]/tr[1]/td[6]/button[2]");
        deleteButton.click();
        Thread.sleep(1000);

        WebElement newBoxer2 = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertNotEquals(newBoxer2.getText(), "Errol Spence");
        assertEquals(newBoxer2.getText(), "Manny Pacquiao");


    }
}
