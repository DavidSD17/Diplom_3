package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StartPage {
    LoginPage loginPage;
    private WebDriver driver;

    private final By loginBtn = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By personalAccountBtn = By.xpath("//p[contains(text(),'Личный Кабинет')]");



    public StartPage(WebDriver driver) {
            this.driver = driver;
    }

    public void clickOnLoginBtn(){
    driver.findElement(loginBtn).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Войти')]")));

    }


    public void clickOnPersonalAccountBtn(){
        driver.findElement(loginBtn).click();

    }

}
