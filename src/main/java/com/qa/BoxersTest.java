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


public class BoxersTest {
    private ChromeDriver driver;

    private String webLocation = "file:///C:/Users/Admin/Desktop/boxing/boxers.html";

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
    public void addBoxer() throws InterruptedException {
        driver.get(webLocation);
        Thread.sleep(2000);
        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElementById("firstName");
        firstName.sendKeys("Canelo");
        Thread.sleep(1000);
        WebElement lastName = driver.findElementById("lastName");
        lastName.sendKeys("Alvarez");
        Thread.sleep(1000);
        WebElement age = driver.findElementById("age");
        age.sendKeys("29");
        Thread.sleep(1000);
        WebElement nationality = driver.findElementById("nationality");
        nationality.sendKeys("Mexico");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);

        WebElement boxerFirstName = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Canelo", boxerFirstName.getText());
    }

    @Test
    public void editBoxer() throws InterruptedException {
        driver.get(webLocation);

        Thread.sleep(1000);
        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElementById("firstName");
        firstName.sendKeys("Canelo");
        Thread.sleep(1000);
        WebElement lastName = driver.findElementById("lastName");
        lastName.sendKeys("Alvarez");
        Thread.sleep(1000);
        WebElement age = driver.findElementById("age");
        age.sendKeys("29");
        Thread.sleep(1000);
        WebElement nationality = driver.findElementById("nationality");
        nationality.sendKeys("Mexico");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);



        WebElement editButton = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[6]/button[1]");
        editButton.click();
        Thread.sleep(1000);
        WebElement editfirstName = driver.findElementByXPath("//*[@id=\"editForm\"]/input[1]");
        editfirstName.clear();
        editfirstName.sendKeys("Saul");
        WebElement editSubmit = driver.findElementByXPath("//*[@id=\"editForm\"]/input[5]");
        editSubmit.click();
        Thread.sleep(1000);
        WebElement boxerFirstName = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Saul", boxerFirstName.getText());

    }


    @Test
    public void deleteBoxer() throws InterruptedException {
        driver.get(webLocation);
        Thread.sleep(2000);
        WebElement addButton = driver.findElementById("addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElementById("firstName");
        firstName.sendKeys("Canelo");
        Thread.sleep(1000);
        WebElement lastName = driver.findElementById("lastName");
        lastName.sendKeys("Alvarez");
        Thread.sleep(1000);
        WebElement age = driver.findElementById("age");
        age.sendKeys("29");
        Thread.sleep(1000);
        WebElement nationality = driver.findElementById("nationality");
        nationality.sendKeys("Mexico");
        Thread.sleep(1000);
        WebElement modalSubmit = driver.findElementById("modalSubmit");
        modalSubmit.click();
        Thread.sleep(1000);

        WebElement boxerFirstName = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertEquals("Canelo", boxerFirstName.getText());

        Thread.sleep(2000);
        addButton.click();
        Thread.sleep(2000);
        WebElement firstName2 = driver.findElementById("firstName");
        firstName2.sendKeys("James");
        Thread.sleep(1000);
        WebElement lastName2 = driver.findElementById("lastName");
        lastName2.sendKeys("Irish");
        Thread.sleep(1000);
        WebElement age2 = driver.findElementById("age");
        age2.sendKeys("69");
        Thread.sleep(1000);
        WebElement nationality2 = driver.findElementById("nationality");
        nationality2.sendKeys("U.K");
        Thread.sleep(1000);
        modalSubmit.click();
        Thread.sleep(1000);

        WebElement deleteButton = driver.findElementByXPath("//*[@id=\"returned\"]/tr[1]/td[6]/button[2]");
        deleteButton.click();
        Thread.sleep(1000);

        WebElement newBoxerFirstName = driver.findElementByXPath("//*[@id=\"returned\"]/tr/td[2]");

        assertNotEquals(newBoxerFirstName.getText(), "Canelo");
        assertEquals(newBoxerFirstName.getText(), "James");


    }
}
