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

public class HomePageTest {

    private WebDriver driver;
    private String yandexBrowser = "C:\\Users\\dsladkov\\WebDriver\\bin\\yandexdriver.exe";
    private StartPage StartPage;
    private LoginPage loginPage;

    private By loginBtn;
    private final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";



    @Before
    public void setUp() {

        /**  Ревьюер предложил такой вариант: вынести путь до драйвера в строковую переменную.
          Для запуска на Хроме просто закомментировать строку с System.setProperty */

        System.setProperty("webdriver.chrome.driver",yandexBrowser);
        driver = new ChromeDriver();
        driver.get(MAIN_URL);

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
