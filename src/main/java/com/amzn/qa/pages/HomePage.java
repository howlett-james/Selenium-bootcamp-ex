package com.amzn.qa.pages;

import com.amzn.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HomePage extends TestBase {

    @FindBy(css = "[id='twotabsearchtextbox']")
    WebElement searchbar;

    @FindBy(css = "h2 > a[href*='OnePlus-Nord-Charcoal-128GB-Storage']")
    WebElement myProduct;

    @FindBy(css = "[id='add-to-cart-button']")
    WebElement Add2Cart;

    @FindBy(css = "[id='attachDisplayAddBaseAlert'] div h4")
    WebElement cartMsg;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public void SearchProduct(String product){
        searchbar.sendKeys(product, Keys.ENTER);
    }
    public void SelectProduct(){
        myProduct.click();
    }
    public void switchTab(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        for (String child_window : s) {
            if (!parent.equals(child_window)) {driver.switchTo().window(child_window);}
        }
    }
    public void Move2Cart(){
        Add2Cart.click();
    }
    public String ValidateAddedProduct(){
        WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(cartMsg));
        return foo.getText();
    }
}