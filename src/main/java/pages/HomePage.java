package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    private final By personalAccountBtn = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    private final By assembleTheBurgerText = By.xpath("//h1[contains(text(),'Соберите бургер')]");
    private final By sauceTab = By.xpath("//span[contains(text(),'Соусы')]");
    private final By fillingsTab = By.xpath("//span[contains(text(),'Начинки')]");
    private final By bunTab = By.xpath("//span[contains(text(),'Булки')]");
    private final By currentTab = By.xpath("//div[contains(@class,'tab_tab_type_current')]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnPersonalAccountOnHomePage(){
        driver.findElement(personalAccountBtn).isDisplayed();
        driver.findElement(personalAccountBtn).click();

    }

    public void checkAssembleTheBurgerText(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(assembleTheBurgerText));

    }
    public void clickOnBunTab(){
        driver.findElement(bunTab).click();

    }
    public void clickOnSauceTab(){
        driver.findElement(sauceTab).click();

    }
    public void clickOnFillingsTab(){
        driver.findElement(fillingsTab).click();

    }

    public String checkCurrentTab(){
        return driver.findElement(currentTab).getText();

    }
}
