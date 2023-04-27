package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;


    /** Страница авторизации **/
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginAuthBtn = By.xpath("//button[contains(text(),'Войти')]");
    private final By signUpBtn = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private final By inCorrectPasswordText = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By restorePasswordBtn= By.xpath("//a[contains(text(),'Восстановить пароль')]");



    public LoginPage(WebDriver driver) {
            this.driver = driver;
    }


    public void waitToLoadStartPage(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(loginAuthBtn));
    }
    public void waitToLoadSignUpPage(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Зарегистрироваться')]")));
    }

    public void pasteEmailAuth(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }
    public String getEmailSignUp(){
        return driver.findElement(emailField).getText();
    }

    public void pastePasswordAuth(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }


    public void clickOnLoginBtn(){
        driver.findElement(loginAuthBtn).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Оформить заказ')]")));

    }

    public void clickOnSignUpBtn(){
        driver.findElement(signUpBtn).click();

    }

    public void clickOnRestorePasswordBtn(){
        driver.findElement(restorePasswordBtn).click();

    }
    public void clickOnLoginBtnNotWait(){
        driver.findElement(loginAuthBtn).isDisplayed();
        driver.findElement(loginAuthBtn).click();

    }
    public void checkErrorPassText(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(inCorrectPasswordText));

    }

}
