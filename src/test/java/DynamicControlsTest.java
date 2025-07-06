import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest {

    @Test
    public void checkDynamicControls() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Явное ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        //Клик по Remove
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        //Ожидание сообщения "It's gone"
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        //Проверка исчезновения чекбакса
        assertTrue(driver.findElements(By.id("checkbox")).isEmpty(),
                "Чекбокс должен был исчезнуть");
        //Проверка, что инпут disabled
        assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(),
                "Инпут должен быть disabled");
        //Клик по Enable
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        //Ожидание сообщения "It's enabled!"
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        //Проверка, что инпут enabled
        assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(),
                "Инпут должен быть enabled");
        driver.quit();
    }
}
