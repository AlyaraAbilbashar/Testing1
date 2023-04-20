package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1
        driver.navigate().to("https://www.saucedemo.com/");

        //2
        WebElement usr_fld = driver.findElement(By.name("user-name"));
        usr_fld.sendKeys("standard_user");

        //3
        WebElement passwd_fld = driver.findElement(By.name("password"));
        passwd_fld.sendKeys("secret_sauce");

        //4
        WebElement log_btn = driver.findElement(By.id("login-button"));
        log_btn.click();

        //5
        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html") + " User redirected to products page");

        //6
        WebElement btn_first = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btn_first.click();
        WebElement btn_second = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        btn_second.click();

        //7
        WebElement btn_cart = driver.findElement(By.id("shopping_cart_container"));
        btn_cart.click();

        //8
        List<WebElement> cart_item = driver.findElements(By.className("cart_item"));
        System.out.println(cart_item.size()==2);

        //9
        WebElement btn_checkout = driver.findElement(By.id("checkout"));
        btn_checkout.click();

        //10
        WebElement first_name_fld = driver.findElement(By.name("firstName"));
        first_name_fld.sendKeys("Alyara");
        WebElement last_name_fld = driver.findElement(By.name("lastName"));
        last_name_fld.sendKeys("Abilbashar");
        WebElement zip_fld = driver.findElement(By.name("postalCode"));
        zip_fld.sendKeys("159357");

        //11
        WebElement btn_continue = driver.findElement(By.id("continue"));
        btn_continue.click();

        //12
        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html") + " Order summary page is displayed");

        //13
        WebElement btn_finish = driver.findElement(By.id("finish"));
        btn_finish.click();

        //14
        WebElement thnx_message = driver.findElement(By.className("complete-text"));

        //driver.quit();
    }
}