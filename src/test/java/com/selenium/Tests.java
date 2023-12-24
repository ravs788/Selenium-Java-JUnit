package com.selenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Tests {
    public WebDriver driver = null;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement swagLabsLogo = driver.findElement(By.xpath("//div[@class='login_logo']"));
        String swagLabsLogoText = swagLabsLogo.getText();   
        Assert.assertEquals("Swag Labs", swagLabsLogoText); 
    }


    @Test
    public void testLogin() throws InterruptedException {
        

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(3000);

        List<WebElement> iconExists = driver.findElements(By.xpath("//div[text()='Swag Labs']"));

        if (iconExists.size() > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        WebElement sauceLabsBackpackAddToCartBtn =driver.findElement(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']//div[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item_description']//button"));
        sauceLabsBackpackAddToCartBtn.click();

        WebElement sauceLabsBikeLightAddToCartBtn =driver.findElement(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']//div[text()='Sauce Labs Bike Light']//ancestor::div[@class='inventory_item_description']//button"));
        sauceLabsBikeLightAddToCartBtn.click();

        WebElement sauceLabsBoltTShirtAddToCartBtn =driver.findElement(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']//div[text()='Sauce Labs Bolt T-Shirt']//ancestor::div[@class='inventory_item_description']//button"));
        sauceLabsBoltTShirtAddToCartBtn.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a"));
        shoppingCart.click();

        WebElement chckOutBtn = driver.findElement(By.id("checkout"));
        chckOutBtn.click();
        Thread.sleep(3000); 

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipElement = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Ravi");
        lastName.sendKeys("Kumar");
        zipElement.sendKeys("560037");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
        Thread.sleep(3000); 

        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();
        Thread.sleep(3000); 
        
        WebElement completeHeader = driver.findElement(By.xpath("//div[@class='checkout_complete_container']/h2"));
        String completeHeaderText = completeHeader.getText();

        Assert.assertEquals("Thank you for your order!", completeHeaderText);

        WebElement backHomeBtn = driver.findElement(By.id("back-to-products"));
        backHomeBtn.click();    
    
        WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
        menuBtn.click();
        Thread.sleep(3000); 

        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        logoutBtn.click();
        Thread.sleep(3000);

        WebElement swagLabsLogo = driver.findElement(By.xpath("//div[@class='login_logo']"));
        String swagLabsLogoText = swagLabsLogo.getText();   
        Assert.assertEquals("Swag Labs", swagLabsLogoText); 
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}