package com.amzn.qa.tests;

import com.amzn.qa.base.TestBase;
import com.amzn.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase01 extends TestBase {
    LoginPage loginPage;

    public TestCase01(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        loginPage.navSignIn();
    }
    @Test(priority = 1)
    public void Login(){
        Assert.assertEquals(prop.getProperty("title"),loginPage.validateTitle());
        loginPage.ValidLogin(prop.getProperty("email"),prop.getProperty("password"));
        Assert.assertEquals(prop.getProperty("accountName"),loginPage.ValidateAccount());
    }
    @Test(priority = 2)
    public void InvalidLoginPass(){
        Assert.assertEquals(prop.getProperty("title"),loginPage.validateTitle());
        loginPage.ValidLogin(prop.getProperty("email"),prop.getProperty("InvalidPassword"));
        System.out.println(loginPage.ValidateWarnMsg());
        Assert.assertEquals(prop.getProperty("warningMsg"),loginPage.ValidateWarnMsg());
    }
    @Test(priority = 3)
    public void InvalidLoginEmail(){
        Assert.assertEquals(prop.getProperty("title"),loginPage.validateTitle());
        loginPage.EnterEmail(prop.getProperty("InvalidEmail"));
        System.out.println(loginPage.ValidateErrorMsg());
        Assert.assertEquals(prop.getProperty("errorMsg"),loginPage.ValidateErrorMsg());
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
