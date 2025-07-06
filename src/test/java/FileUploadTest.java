import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FileUploadTest {

    @Test
    public void checkFileUpload() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/upload");
        //Явное ожидание загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        //Загрузка файла
        File file = new File("src/test/java/resources/FILE.html");
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());
        //Клик по Upload
        driver.findElement(By.id("file-submit")).click();
        //Ожидание завершения загрузки и появления результата
        WebElement uploadedFileName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files"))
        );
        //Проверка, что имя файла на странице совпадает с именем загруженного файла
        String actualFileName = uploadedFileName.getText();
        String expectedFileName = "FILE.html";
        assertEquals(expectedFileName, actualFileName, "Имя загруженного файла не совпадает с ожидаемым");
        driver.quit();
    }
}
