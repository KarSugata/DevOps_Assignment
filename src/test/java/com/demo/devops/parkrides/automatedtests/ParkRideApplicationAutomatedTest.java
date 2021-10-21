package com.demo.devops.parkrides.automatedtests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkRideApplicationAutomatedTest extends BaseSeleniumTests {

    @Test
    public void TestA_checkPageElements() {
        final String URL = "http://localhost:8082/";
        this.driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, 180);

        // Title of the Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h2")));
        String Title = driver.findElement(By.xpath("/html/body/div/h2"))
                .getText();
        assertEquals(String.format("Title of the page '%s' is not matched: ", Title), "New ride entry",
                Title);

        // Submit Button
        assertEquals("Submit Button not found", driver.findElements(By.xpath("//*[@id='Submit']")).size(), 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Submit']")));
    }

    @Test
    public void TestB_createRide() {
        String URL = "http://localhost:8082/";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, 180);

        // Title of the Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/h2")));
        String Title = driver.findElement(By.xpath("/html/body/div/h2"))
                .getText();
        assertEquals(String.format("Title of the page '%s' is not matched: ", Title), "New ride entry",
                Title);

        // Name of the ride
        driver.findElement(By.xpath("//*[@id='fname']")).clear();
        driver.findElement(By.xpath("//*[@id='fname']")).sendKeys("TestRide");

        // Description of the ride
        driver.findElement(By.xpath("//*[@id='description']")).clear();
        driver.findElement(By.xpath("//*[@id='description']")).sendKeys("TestDescription");

        // Thrill factor of the ride
        driver.findElement(By.xpath("//*[@id='thrill']")).clear();
        driver.findElement(By.xpath("//*[@id='thrill']")).sendKeys("10");

        // Capacity of the ride
        driver.findElement(By.xpath("//*[@id='capacity']")).clear();
        driver.findElement(By.xpath("//*[@id='capacity']")).sendKeys("25");

        // Click on Submit button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Submit']")));
        driver.findElement(By.xpath("//*[@id='Submit']")).click();

        driver.navigate().refresh();

        // Check the persisted data

        URL = "http://localhost:8082/ride";
        driver.get(URL);

        String expectedValue = driver.findElement(By.xpath("/html/body/pre")).getText();
        System.out.println(expectedValue);
        String actualValue = "[{\"id\":1,\"name\":\"TestRide\",\"description\":\"TestDescription\",\"thrillFactor\":10,\"capacity\":25}]";
        assertEquals("Data Mismatch", expectedValue, actualValue);
    }
}
