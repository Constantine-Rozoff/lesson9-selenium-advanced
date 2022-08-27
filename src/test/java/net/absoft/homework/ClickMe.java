package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ClickMe extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test
    void testClickMeWait() {
        WebElement clickMe = driver.findElement(By.xpath("//p[contains(text(), 'CLICK ME!')]"));
        WebElement modal = driver.findElement(By.xpath("//div[@class='modal-content']"));
        WebElement modalText = driver.findElement(By.xpath("//div[@class='modal-content']//p"));
        WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(), 'Close')]"));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(
                ExpectedConditions.visibilityOf(clickMe));
        driver.findElement(By.xpath("//p[contains(text(), 'CLICK ME!')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(6)).until(
                ExpectedConditions.visibilityOf(modal));
        assertEquals(modalText.getText(), "The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits.",
                "Unexpected alert text");
        closeButton.click();
        assertTrue(clickMe.isDisplayed(), "Modal window is still displayed");
        assertTrue(clickMe.isEnabled(), "Modal window is still displayed");
    }
}
