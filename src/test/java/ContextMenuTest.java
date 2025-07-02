import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest {
    @Test
    public void checkContextMenu() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Явное ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hot-spot")));
        WebElement hotspot = driver.findElement(By.id("hot-spot"));
        //Правый клик
        Actions actions = new Actions(driver);
        actions
                .contextClick(hotspot)
                .perform();
        //Переход к алерту
        Alert alert = driver.switchTo().alert();
        //Проверка текста
        String expectedText = "You selected a context menu";
        assertEquals(expectedText, alert.getText(), "Текст алерта не совпадает");
        //Закрытие алерта
        alert.accept();
        //Проверка исчезновения алерта
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        driver.quit();
    }
}
