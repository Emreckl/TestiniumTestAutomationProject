package com.testinium.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private final WebDriverWait webDriverWait;
    protected Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 8);
    }

    protected WebElement findElement(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void clickObject(By by, String message) {
        WebElement webElement = findElement(by);
        webElement.click();
        logger(message);
    }

    protected void fillInputField(By by, String text, String message) {
        WebElement webElement = findElement(by);
        webElement.clear();
        webElement.sendKeys(text);
        logger(message);
    }

    protected boolean isElementDisplayed(By by) {
        boolean found = false;

        try {
            if (findElement(by) != null) {
                found = true;
                logger("Element görüntülendi");
            }
        } catch (NullPointerException ignored) {
            logger("Element görüntülenemedi.");
        }
        return found;
    }

    protected String getWebElementText(By by) {
        return findElement(by).getText();
    }

    protected List<WebElement> getWebElementList(By by) {
        return driver.findElements(by);
    }

    protected void logger(String message) {
        logger.info(message);
    }

    protected void scrollToCenter(WebElement webElement) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                    webElement);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}