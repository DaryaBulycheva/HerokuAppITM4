import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FramesTest {

    @Test
    public void checkFrames() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/frames");
        //Явное ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        //Клик по iFrame
        driver.findElement(By.linkText("iFrame")).click();
        //Переключение на iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
        driver.switchTo().frame(iframe);
        //Поиск параграфа внутри iframe и проверка текста
        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        String expectedText = "Your content goes here.";
        assertEquals(expectedText, paragraph.getText().trim(),
                "Текст внутри iframe не соответствует ожидаемому");
        //Возвращение к основному контенту
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
