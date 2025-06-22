import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {
    @Test
    public void checkboxes() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Проверяю, что чекбокс 1 unchecked
        WebElement checkbox1 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        boolean isChecked1 = checkbox1.isSelected();
        softAssert.assertEquals(isChecked1, false);
        //Отмечаю чекбокс 1
        checkbox1.click();
        //Проверяю, что чекбокс 1 checked
        boolean isCheckedTrue1 = checkbox1.isSelected();
        softAssert.assertEquals(isCheckedTrue1, true);
        //Проверяю, что чекбокс 2 checked
        WebElement checkbox2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);
        boolean isChecked2 = checkbox1.isSelected();
        softAssert.assertEquals(isChecked2, true);
        //Убираю отметку с чекбокса 2
        checkbox2.click();
        //Проверяю, что чекбокс 2 unchecked
        boolean isCheckedTrue2 = checkbox1.isSelected();
        softAssert.assertEquals(isCheckedTrue2, true);
        driver.quit();
        softAssert.assertAll();
    }
}
