package com.testinium.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BaseTest.class);

    @Before
    public void setUp() {
        PropertyConfigurator.configure("properties/log4j.properties");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        logger.info("Before Run: Chrome Driver");
        logger.info("Installation finish");

        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
        logger.info("Driver quit");
    }
}
