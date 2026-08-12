package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By productTitle = By.cssSelector("h2.name");
    private final By productPrice = By.cssSelector("h3.price-container");
    private final By productDescription = By.id("more-information");
    private final By addToCartButton = By.xpath("//a[text()='Add to cart']");
    private final By cartLink = By.id("cartur");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    public String getProductTitle(){
        return waitUtils.waitForVisibility(productTitle).getText();
    }
    public String getProductPrice(){
        return waitUtils.waitForVisibility(productPrice).getText();
    }
    public String getProductDescription(){
        return waitUtils.waitForVisibility(productDescription).getText();
    }
    public void clickAddToCart(){
        waitUtils.waitForClickable(addToCartButton).click();
    }
    public CartPage openCart(){
        waitUtils.waitForClickable(cartLink).click();
        return new CartPage(driver);
    }

}


