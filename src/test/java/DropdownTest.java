import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DropdownTest {
    @Test
    public void dropdown() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        //Проверяю наличие элементов
        WebElement option1 = dropdownElement.findElement(By.xpath("//*[@id=\"dropdown\"]/option[1]"));
        softAssert.assertEquals(option1.getText(), "Please select an option");
        WebElement option2 = dropdownElement.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
        softAssert.assertEquals(option2.getText(), "Option 1");
        WebElement option3 = dropdownElement.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        softAssert.assertEquals(option3.getText(), "Option 2");
        //Выбираю Option 1 и проверяю, что он выбран
        dropdown.selectByIndex(1);
        softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
        //Выбираю Option 2 и проверяю, что он выбран
        dropdown.selectByIndex(2);
        softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
        driver.quit();
        softAssert.assertAll();
    }
}
