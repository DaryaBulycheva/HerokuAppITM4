import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TyposTest {
    @Test
    public void typos() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        int checksCount = 10;
        int trueCount = 0;
        int falseCount = 0;
        for (int i = 1; i <= checksCount; i++) {
            driver.get("https://the-internet.herokuapp.com/typos");
            WebElement paragraph = driver.findElements(By.tagName("p")).get(1);
            String actualText = paragraph.getText();
            if (actualText.contains("won't")) {
                trueCount += 1;
            } else {
                falseCount += 1;
            }
            Thread.sleep(1000);
        }
        driver.quit();
        System.out.println("Корректная орфография: " + trueCount);
        System.out.println("Некорректная орфография: " + falseCount);
    }
}
