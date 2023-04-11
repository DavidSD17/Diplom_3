import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

public class LoginTest {
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
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void loginOnAuthPage() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnLoginBtn();

    }

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void loginByPersonalAccount() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        startPage.clickOnPersonalAccountBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnLoginBtn();

    }

    @Test
    @Description("вход через кнопку в форме регистрации")
    public void loginBySignUpBtn() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.clickOnSignUpBtn();
        loginPage.waitToLoadSignUpPage();
        signUpPage.clickOnLoginBtn();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnSignUpBtn();
    }

    @Test
    @Description("вход через кнопку в форме восстановления пароля")
    public void loginByRestorePasswordBtn() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.clickOnRestorePasswordBtn();
        restorePasswordPage.waitToloadRestorePasswordPage();
        restorePasswordPage.clickOnLoginBtnRestorePasswordPage();
        loginPage.pasteEmailAuth("pkendzb@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        loginPage.clickOnLoginBtn();

    }

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void goToPersonalAccount() {
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



    }



    @After
    public void tearDown(){
        driver.close();
        }

}
