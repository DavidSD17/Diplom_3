import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AuthPage;
import pageObject.StartPage;

public class AuthTest {
    private WebDriver driver;
    private StartPage StartPage;
    private AuthPage authPage;

    private By loginBtn;

    @Before
    public void setUp() {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\dsladkov\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        // перейди на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        // создай объект класса страницы стенда
        // дождись загрузки страницы
//        metroPage.waitForLoadHomePage();
    }
    @Test
    public void loginOnAuthPage() {
        StartPage startPage = new StartPage(driver);
        AuthPage authPage = new AuthPage(driver);
        startPage.clickOnLoginBtn();
        authPage.waitToLoadStartPage();
    }

    @After
            public void tearDown(){
        driver.quit();
        }

}
