package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ToDoList extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testAddNewToDo() {
        WebElement input_field = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        input_field.click();
        input_field.sendKeys("Do magic exercises");
        input_field.sendKeys(Keys.ENTER);
        assertEquals(driver.findElement(By.xpath("//ul/li[last()]")).getText(), "Do magic exercises");
    }

    @Test
    public void testDeleteToDo() {
        testAddNewToDo();
        WebElement trash_can_button = driver.findElement(By.xpath("//ul/li[last()]/span/i"));
        trash_can_button.click();
        //in order to overwait an deleting animation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.findElements(By.xpath("//li[contains(text(), ' Do magic exercises')]")).isEmpty(), "A newly created elements wasn't deleted");
    }
}
