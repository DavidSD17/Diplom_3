package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    WebDriver driver;

    public final By personalAccountTab = By.xpath("//a[contains(text(),'Профиль')]");
    public final By constructorBtn = By.xpath("//p[contains(text(),'Конструктор')]");
    public final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a");

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkPersonalAccountTab(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(personalAccountTab));

    }
    public void clickOnConstructorBtn(){
        driver.findElement(constructorBtn).isDisplayed();
        driver.findElement(constructorBtn).click();

    }

    public void clickOnLogo(){
        driver.findElement(logo).isDisplayed();
        driver.findElement(logo).click();

    }
}

