import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PersonalAccountPage;
import pageObject.StartPage;

public class HomePageTest {

    private WebDriver driver;
    private StartPage StartPage;
    private LoginPage loginPage;

    private By loginBtn;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\dsladkov\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    @Description("Переход на вкладку Начинки")
    public void goOnFillingsTab() {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFillingsTab();
        String currentTab =  homePage.checkCurrentTab();
        Assert.assertEquals("Начинки",currentTab);

    }

    @Test
    @Description("Переход на вкладку Соусы")
    public void goOnSauceTab() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSauceTab();
        String currentTab =  homePage.checkCurrentTab();
        Assert.assertEquals("Соусы",currentTab);

    }
    @Test
    @Description("Переход на вкладку Булки")
    public void goOnИгтTab() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSauceTab();
        homePage.clickOnBunTab();
        String currentTab =  homePage.checkCurrentTab();
        Assert.assertEquals("Булки",currentTab);

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
