package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    WebDriver driver;

    private final By nameField = By.xpath("//label[contains(text(),'Имя')]/following-sibling::input");
    private final By emailField = By.xpath("//fieldset[2]//div[1]//div[1]//input[1]");
    private final By passwordField = By.xpath("//input[@name='Пароль']");

    protected final By signUpBtn = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private final By loginBtn = By.xpath("//a[contains(text(),'Войти')]");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public String nameGenerator(){
        String name = RandomStringUtils.randomAlphabetic(7);
        return name;
    }

    public String emailGenerator(){
        String name = RandomStringUtils.randomAlphabetic(7);
        return name+"@yandex.ru";
    }

    public String passGenerator(){
        String password = RandomStringUtils.randomAlphabetic(7);
        return password;
    }

    public String incorrectPassGenerator(){
        String inPassword = RandomStringUtils.randomAlphabetic(5);
        return inPassword;
    }

    public void pasteNameSignUp(String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);

    }
    public void pasteEmailSignUp(String name){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(name);

    }
    public void pastePassSignUp(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);

    }
    public String getEmailSignUp(){
      return driver.findElement(emailField).getText();

    }

    public void clickOnSignUpBtn(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
        driver.findElement(signUpBtn).click();

    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtn).click();


    }


}
