import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NotificationMessagesTest {
    @Test
    public void notificationMessages() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement button = driver.findElement(By.linkText("Click here"));
        button.click();
        WebElement notification = driver.findElement(By.id("flash"));
        String notificationText = notification.getText().trim();
        if (notificationText.contains("Action successful")) {
            System.out.println("Уведомление: " + notificationText + " прошло валидацию");
        } else if (notificationText.contains("Action unsuccesful, please try again")) {
            System.out.println("Уведомление: " + notificationText + " прошло валидацию");
        } else {
            System.out.println("Неизвестное уведомление: " + notificationText);
        }
        driver.quit();
        softAssert.assertAll();
    }
}
