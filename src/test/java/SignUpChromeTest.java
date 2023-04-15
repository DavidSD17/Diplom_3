import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.SignUpPage;
import pageObject.StartPage;

public class SignUpChromeTest {
    private WebDriver driver;

    private By loginBtn;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void SignUpIncorrectPassword(){
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.waitToLoadStartPage();
        loginPage.clickOnSignUpBtn();
        loginPage.waitToLoadSignUpPage();
        signUpPage.pasteNameSignUp(signUpPage.nameGenerator());
        loginPage.pasteEmailAuth(signUpPage.nameGenerator()+"@yandex.ru");
        loginPage.pastePasswordAuth("ljUoS");
        signUpPage.clickOnSignUpBtn();
        loginPage.checkErrorPassText();

    }

    @Test
    @Description("Успешная регистрация")
    public void loginBySignUpBtn() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.clickOnSignUpBtn();
        loginPage.waitToLoadSignUpPage();
        signUpPage.pasteNameSignUp(signUpPage.nameGenerator());
        loginPage.pasteEmailAuth(signUpPage.nameGenerator()+"@yandex.ru");
        loginPage.pastePasswordAuth("ljUoSldk");
        signUpPage.clickOnSignUpBtn();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
