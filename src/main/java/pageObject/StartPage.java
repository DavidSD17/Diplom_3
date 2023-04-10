package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private WebDriver driver;

    public final By loginBtn = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    public StartPage(WebDriver driver) {
            this.driver = driver;
    }

    public void clickOnLoginBtn(){
    driver.findElement(loginBtn).click();
    }
}
