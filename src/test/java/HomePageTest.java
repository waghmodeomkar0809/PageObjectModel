import com.bridgelabz.base.BaseClass;
import com.bridgelabz.page.HomePage;
import com.bridgelabz.page.LoginPage;
import com.bridgelabz.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

        LoginPage loginPage;
        HomePage homePage;
        ProfilePage profilePage;

        @BeforeMethod
        public void setup() {
            launchBrowser();
            loginPage = new LoginPage();
            homePage = loginPage.login("8109555221", "Test12345");
        }

        @Test
        public void verifyHomePageTitleTest() {
            String homePageTitle = homePage.verifyHomePageTitle();
            Assert.assertEquals(homePageTitle, "Facebook");
        }

        @Test
        public void gotoProfileTest() {
            profilePage = homePage.gotoProfile();
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

    }

