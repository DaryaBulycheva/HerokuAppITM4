import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {
    @Test
    public void inputs() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        //Ввод букв и проверка, что ничего не ввелось
        input.sendKeys("Abcd");
        softAssert.assertEquals(input.getAttribute("value"), "");
        input.clear();
        //Ввод цифр и проверка, что цифры ввелись
        input.sendKeys("123");
        softAssert.assertEquals(input.getAttribute("value"), "123");
        //Проверка Keys.ARROW_UP
        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(input.getAttribute("value"), "124");
        //Проверка Keys.ARROW_DOWN
        input.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(input.getAttribute("value"), "123");
        driver.quit();
        softAssert.assertAll();
    }
}
