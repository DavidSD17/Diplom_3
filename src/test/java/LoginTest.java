import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginTest {
    private WebDriver driver;
    private String yandexBrowser = "C:\\Users\\dsladkov\\WebDriver\\bin\\yandexdriver.exe";

    private String email;
    private String password;
    private String accessToken;

    private final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private User user;
    private UserClient userClient;


    @Before
    public void setUp() {

        /**  Ревьюер предложил такой вариант: вынести путь до драйвера в строковую переменную.
         Для запуска на Хроме просто закомментировать строку с System.setProperty */

        System.setProperty("webdriver.chrome.driver",yandexBrowser);
        driver = new ChromeDriver();
        driver.get(MAIN_URL);
        user = UserGenerator.generateRandomCredentials();
        userClient = new UserClient(user);

        ValidatableResponse loginResponse = userClient.create(user)
                .assertThat()
                .statusCode(200)
                .and()
                .body("accessToken", notNullValue());
        accessToken = loginResponse.extract().path("accessToken");
        email = loginResponse.extract().path("user.email");
        password = user.getPassword();


    }
    @Test
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void loginOnAuthPage() {


        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);


        startPage.clickOnLoginBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
        loginPage.clickOnLoginBtn();

    }

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void loginByPersonalAccount() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        startPage.clickOnPersonalAccountBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
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
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
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
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
        loginPage.clickOnLoginBtn();

    }

    @Test
    @Description("Переход в личный кабинет")
    public void goToPersonalAccount() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        startPage.clickOnPersonalAccountBtn();
        loginPage.waitToLoadStartPage();
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
        loginPage.clickOnLoginBtn();
        homePage.clickOnPersonalAccountOnHomePage();
        personalAccountPage.checkPersonalAccountTab();

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
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
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
        loginPage.pasteEmailAuth(email);
        loginPage.pastePasswordAuth(password);
        loginPage.clickOnLoginBtn();
        homePage.clickOnPersonalAccountOnHomePage();
        personalAccountPage.checkPersonalAccountTab();
        personalAccountPage.clickOnLogo();
        homePage.checkAssembleTheBurgerText();

    }


    @After
    public void tearDown(){
        driver.close();
        if (accessToken != null) {
            userClient.delete(accessToken)
                    .assertThat()
                    .statusCode(202);
        }
    }

}
