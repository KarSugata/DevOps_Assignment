package com.demo.devops.parkrides.automatedtests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseSeleniumTests {
    private static final String CHROMEDRIVER_EXE = ".\\src\\test\\resources\\drivers\\chromedriver.exe";
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void closeAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
