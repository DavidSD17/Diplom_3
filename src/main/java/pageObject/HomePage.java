package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public final By arrangeOrderBtn = By.xpath("//button[contains(text(),'Оформить заказ')]");
    public final By personalAccountBtn = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    public final By assembleTheBurgerText = By.xpath("//h1[contains(text(),'Соберите бургер')]");
    public final By sauceTab = By.xpath("//span[contains(text(),'Соусы')]");
    public final By fillingsTab = By.xpath("//span[contains(text(),'Начинки')]");
    public final By bunTab = By.xpath("//span[contains(text(),'Булки')]");
    public final By currentTab = By.xpath("//div[contains(@class,'tab_tab_type_current')]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnPersonalAccountOnHomePage(){
        driver.findElement(personalAccountBtn).isDisplayed();
        driver.findElement(personalAccountBtn).click();

    }

    public void checkAssembleTheBurgerText(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(assembleTheBurgerText));

    }
    public void clickOnBunTab(){
        driver.findElement(bunTab).isDisplayed();
        driver.findElement(bunTab).click();

    }
    public void clickOnSauceTab(){
        driver.findElement(sauceTab).isDisplayed();
        driver.findElement(sauceTab).click();

    }
    public void clickOnFillingsTab(){
        driver.findElement(fillingsTab).isDisplayed();
        driver.findElement(fillingsTab).click();

    }

    public String checkCurrentTab(){
        return driver.findElement(currentTab).getText();

    }
}
