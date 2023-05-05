package com.bridgelabz.page;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class HomePage extends BaseClass {
        @FindBy(xpath = "//span[contains(text(),'John Smith')]")
        private WebElement profileLink;

        // initialization
        public HomePage() {
            PageFactory.initElements(driver, this);
        }

        public String verifyHomePageTitle() {
            return driver.getTitle();
        }
        public ProfilePage gotoProfile(){
            profileLink.click();
            return new ProfilePage();
        }

    }

