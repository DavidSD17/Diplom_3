import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SignUpPage;
import pages.StartPage;

public class SignUpChromeTest {
    private WebDriver driver;


    private By loginBtn;
    private String email;

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
        signUpPage.pasteEmailSignUp(signUpPage.emailGenerator());
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
        email = signUpPage.emailGenerator();
        signUpPage.pasteEmailSignUp(email);
        loginPage.pastePasswordAuth("ljUoSldk");
        signUpPage.clickOnSignUpBtn();

        UserCreds userCreds = new UserCreds(email,"ljUoSldk");
        UserClient userClient = new UserClient();
        ValidatableResponse loginResponse = userClient.login(userCreds);
        String accessToken = loginResponse.extract().path("accessToken");
        userClient.delete(accessToken);

    }

    @After
    public void tearDown(){
        driver.close();
    }

}
