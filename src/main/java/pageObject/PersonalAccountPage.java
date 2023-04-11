package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    WebDriver driver;

    public final By personalAccountTab = By.xpath("//a[contains(text(),'Профиль')]");

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkPersonalAccountTab(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(personalAccountTab));


    }
}

