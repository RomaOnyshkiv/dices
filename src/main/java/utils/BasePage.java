package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickOn(By by) {
        driver.findElement(by).click();
    }

    protected int gettext(By by) {
        return Integer.valueOf(driver.findElement(by).getAttribute("alt"));
    }

    protected void selectFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    protected int summOfPoints(By by) {
        int sum = 0;
        for (WebElement element : driver.findElements(by)) {
            sum = sum + Integer.valueOf(element.getAttribute("alt"));
        }
        return sum;
    }
}
