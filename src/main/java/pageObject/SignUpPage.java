package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;

     final By nameField = By.xpath("//label[contains(text(),'Имя')]/following-sibling::input");
    final By signUpBtn = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    final By loginBtn = By.xpath("//a[contains(text(),'Войти')]");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public String nameGenerator(){
        String name = RandomStringUtils.randomAlphabetic(7);
        return name;
    }

    public void pasteNameSignUp(String name){
        driver.findElement(nameField).isDisplayed();
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);

    }
    public void clickOnSignUpBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
        driver.findElement(signUpBtn).click();

    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtn).isDisplayed();
        driver.findElement(loginBtn).click();


    }
}
