package com.amzn.qa.tests;

import com.amzn.qa.base.TestBase;
import com.amzn.qa.pages.HomePage;
import com.amzn.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public TestCase02(){
        super();
    }
    @BeforeTest
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage =  new HomePage();
    }
    @Test(priority = 1)
    public void Login(){
        loginPage.navSignIn();
        Assert.assertEquals(prop.getProperty("title"),loginPage.validateTitle());
        loginPage.ValidLogin(prop.getProperty("email"),prop.getProperty("password"));
        Assert.assertEquals(prop.getProperty("accountName"),loginPage.ValidateAccount());
    }
    @Test(priority = 2)
    public void AddToCart(){
        homePage.SearchProduct(prop.getProperty("productName"));
        homePage.SelectProduct();
        homePage.switchTab();
        homePage.Move2Cart();
        Assert.assertEquals(homePage.ValidateAddedProduct(),prop.getProperty("cartMsg"));
    }
    @AfterTest
    public void TearDown(){
        driver.quit();
    }
}
