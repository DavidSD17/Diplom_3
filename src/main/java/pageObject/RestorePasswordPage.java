package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestorePasswordPage {
    WebDriver driver;

    private final By restorePasswordTextHeader = By.xpath("//h2[contains(text(),'Восстановление пароля')]");

    final By loginBtnBtn = By.xpath("//a[contains(text(),'Войти')]");

    public RestorePasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitToloadRestorePasswordPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(restorePasswordTextHeader));

    }

    public void clickOnLoginBtnRestorePasswordPage(){
        driver.findElement(loginBtnBtn).isDisplayed();
        driver.findElement(loginBtnBtn).click();


    }
}
