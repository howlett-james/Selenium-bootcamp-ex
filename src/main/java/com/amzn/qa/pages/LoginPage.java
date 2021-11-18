package com.amzn.qa.pages;

import com.amzn.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(css = "[id='nav-link-accountList']")
    WebElement account;

    @FindBy(css = "[id='nav-link-accountList-nav-line-1']")
    WebElement accountName;

    @FindBy(css = "[id='nav-flyout-ya-signin'] > a > span")
    WebElement signIn;

    @FindBy(css = "[id='ap_email']")
    WebElement Email;

    @FindBy(css = "input[id='continue']")
    WebElement Continue;

    @FindBy(css = "[id='ap_password']")
    WebElement Password;

    @FindBy(css = "[id='signInSubmit']")
    WebElement SignIn;

    @FindBy(css = "[id='auth-error-message-box']")
    WebElement authErrMsg;

    @FindBy(css = "[id='auth-warning-message-box']")
    WebElement authWarnMsg;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateTitle(){
        return driver.getTitle();
    }

    public void navSignIn(){
        Actions action = new Actions(driver);
        action.moveToElement(account).moveToElement(signIn).click().build().perform();
    }

    public void EnterEmail(String email){
        Email.sendKeys(email);
        Continue.click();
    }

    public void ValidLogin(String email,String password){
        this.EnterEmail(email);
        Password.sendKeys(password);
        SignIn.click();
    }

    public String ValidateAccount(){
        return accountName.getText();
    }

    public String ValidateErrorMsg(){
        return authErrMsg.getText();
    }

    public String ValidateWarnMsg(){
        return authWarnMsg.getText();
    }

}
