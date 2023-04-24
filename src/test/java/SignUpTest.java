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

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class SignUpTest {

    private WebDriver driver;
    private WebDriver yaDriver;
    private String yandexBrowser = "C:\\Users\\dsladkov\\WebDriver\\bin\\yandexdriver.exe";
    private String chromeBrowser = "C:\\Users\\dsladkov\\WebDriver\\bin\\chromedriver.exe";


    private By loginBtn;
    private String email;
    private String password;
    private String accessToken;
    private UserClient userClient;

    @Before
    public void setUp() {
        /**  Ревьюер предложил такой вариант: вынести путь до драйвера в строковую переменную */


        System.setProperty("webdriver.chrome.driver", chromeBrowser);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        userClient = new UserClient();

    }

    @Test
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void signUpIncorrectPassword() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        startPage.clickOnLoginBtn();
        loginPage.waitToLoadStartPage();
        loginPage.clickOnSignUpBtn();
        loginPage.waitToLoadSignUpPage();
        signUpPage.pasteNameSignUp(signUpPage.nameGenerator());
        loginPage.pasteEmailAuth(signUpPage.nameGenerator() + "@yandex.ru");
        loginPage.pastePasswordAuth("ljUoS");
        signUpPage.clickOnSignUpBtn();
        loginPage.checkErrorPassText();

        UserCreds userCreds = new UserCreds(email, password);
        ValidatableResponse loginResponse = userClient.login(userCreds);
        accessToken = loginResponse.extract().path("accessToken");

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
        password = signUpPage.passGenerator();
        signUpPage.pastePassSignUp(password);
        signUpPage.clickOnSignUpBtn();

        UserCreds userCreds = new UserCreds(email, password);
        ValidatableResponse loginResponse = userClient.login(userCreds);
        accessToken = loginResponse.extract().path("accessToken");

    }

    @After
    public void tearDown() {
        driver.close();
        if (accessToken != null) {
            userClient.delete(accessToken)
                    .assertThat()
                    .statusCode(202);
        }
    }
}
