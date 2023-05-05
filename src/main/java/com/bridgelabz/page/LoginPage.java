package com.bridgelabz.page;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

    @FindBy(id="email")
    private WebElement email;

    @FindBy(name = "pass")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement loginbtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);

    }
    public HomePage login(String uname, String pwd) {
        email.sendKeys(uname);
        password.sendKeys(pwd);
        loginbtn.click();
        return new HomePage();
    }

    public String verifyLoginPageTitle(){
        return driver.getTitle();
    }
}
