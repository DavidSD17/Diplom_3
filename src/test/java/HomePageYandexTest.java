import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalAccountPage;
import pages.StartPage;

public class HomePageYandexTest {

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
    @Description("Переход в конструктор по кнопке Конструктор")
    public void goToConstructorFromPersonalAccount() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        startPage.clickOnPersonalAccountBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnLoginBtn();
        homePage.clickOnPersonalAccountOnHomePage();
        personalAccountPage.checkPersonalAccountTab();
        personalAccountPage.clickOnConstructorBtn();
        homePage.checkAssembleTheBurgerText();

    }

    @Test
    @Description("Переход в конструктор по Лого")
    public void goToConstructorByLogo() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        startPage.clickOnPersonalAccountBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnLoginBtn();
        homePage.clickOnPersonalAccountOnHomePage();
        personalAccountPage.checkPersonalAccountTab();
        personalAccountPage.clickOnLogo();
        homePage.checkAssembleTheBurgerText();

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
    public void goOnBunTab() {
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
