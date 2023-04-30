package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    WebDriver driver;

    private final By personalAccountTab = By.xpath("//a[contains(text(),'Профиль')]");
    private final By constructorBtn = By.xpath("//p[contains(text(),'Конструктор')]");
    private final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a");

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkPersonalAccountTab(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(personalAccountTab));

    }
    public void clickOnConstructorBtn(){
        driver.findElement(constructorBtn).click();

    }

    public void clickOnLogo(){
        driver.findElement(logo).click();

    }
}

