package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StartPage {
    private WebDriver driver;

    private final By loginBtn = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By loginAuthBtn = By.xpath("//button[contains(text(),'Войти')]");
    private final By personalAccountBtn = By.xpath("//p[contains(text(),'Личный Кабинет')]");



    public StartPage(WebDriver driver) {
            this.driver = driver;
    }

    public void waitToLoadStartPage(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Войти')]")));
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
