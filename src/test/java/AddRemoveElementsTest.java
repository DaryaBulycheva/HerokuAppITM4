import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddRemoveElementsTest {
    @Test
    public void addRemoveElements() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Добавляю 2 кнопки
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //Проверяю, что добавлено 2 кнопки
        int buttonsAddElement = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(buttonsAddElement, 2);
        //Удаляю 1 кнопку
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        //Проверяю, что осталась 1 кнопка
        int buttonAddElement = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(buttonAddElement, 1);
        driver.quit();
        softAssert.assertAll();
    }
}
